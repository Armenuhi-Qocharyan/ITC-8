package com.itc.iblog;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.itc.iblog.models.UserModel;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static java.lang.Math.toIntExact;


public class ProfileActivity extends AppCompatActivity {

    private FloatingActionButton avatar;
    private DatabaseReference mDatabase;
    private TextView userName;
    private TextView email;
    private String avatarUrl;
    private TextView userAge;
    private StorageReference storageRef;
    private FloatingActionButton floatingActionButton;
    private FirebaseUser user;
    private FirebaseDatabase database;
    private Bitmap imageFromGallery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        database =  FirebaseDatabase.getInstance();
        user =  FirebaseAuth.getInstance().getCurrentUser();
        floatingActionButton = (FloatingActionButton) findViewById(R.id.floating_avatar);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        setImage("avatar");
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, 1);
            }
        });
    }

    private void setImage(final String img) {
        this.storageRef = FirebaseStorage.getInstance().getReference();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference dbRef = mDatabase.child("Users");
        dbRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addListenerForSingleValueEvent (new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                userName = (TextView) findViewById(R.id.profile_username);
                email = (TextView) findViewById(R.id.profile_email);
                userAge = (TextView) findViewById(R.id.profile_age);
                String user = (String) dataSnapshot.child("userName").getValue();
                String userEmail = (String) dataSnapshot.child("email").getValue();
                Long age = (Long) dataSnapshot.child("age").getValue();
                String url = "";
                if (img.equals("avatar")) {
                    url = (String) dataSnapshot.child("url").getValue();
                } else if(img.equals("bg")) {
                    url = (String) dataSnapshot.child("bg_url").getValue();
                }
                userName.setText(user);
                email.setText(userEmail);
                avatarUrl = url;
                userAge.append(age.toString());
                // Get avatar image
                if (avatarUrl != null) {
                    StorageReference pathReference = storageRef.child(avatarUrl);

                    final long ONE_MEGABYTE = 1024 * 1024;
                    pathReference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                        @Override
                        public void onSuccess(byte[] bytes) {
                            Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                            if (bmp.equals(null)) {
                                Toast.makeText(ProfileActivity.this, "Avatar image not found.", Toast.LENGTH_SHORT).show();
                            }
                            Bitmap bitmap = Bitmap.createScaledBitmap(bmp, 260, 260, false);
                            Bitmap result = getCroppedBitmap(bitmap);
                            if (img.equals("avatar")) {
                                ProfileActivity.this.avatar = (FloatingActionButton) findViewById(R.id.floating_avatar);
                                avatar.setImageBitmap(result);
                            } else if(img.equals("bg")) {
                                ImageView bgImage = (ImageView) findViewById(R.id.bg_image);
                                bgImage.setImageBitmap(bmp);
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            System.out.println("Image not found.");
                        }
                    });
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {}

        });
    }

    public Bitmap getCroppedBitmap(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2, bitmap.getWidth() / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);
        System.out.println(data);
        if (resultCode == RESULT_OK) {
            try {
                final Uri imageUri = data.getData();
                String imagePath = getRealPathFromURI(imageUri);
                String filename = imagePath.substring(imagePath.lastIndexOf("/")+1);

                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);

                putImageToStorage(selectedImage, filename);
                changeUserInfo("images/" + filename);


                this.avatar = (FloatingActionButton) findViewById(R.id.floating_avatar);
                Bitmap bitmap = Bitmap.createScaledBitmap(selectedImage, 200, 200, false);
                Bitmap result = getCroppedBitmap(bitmap);
                avatar.setImageBitmap(result);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(this, "You haven't picked Image",Toast.LENGTH_LONG).show();
        }
    }

    public void putImageToStorage(Bitmap selectedImage, String filename) {
        StorageReference ImageRef = storageRef.child("images/" + filename);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        selectedImage.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] buteData = baos.toByteArray();

        UploadTask uploadTask = ImageRef.putBytes(buteData);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
                Toast.makeText(ProfileActivity.this, "Can not download image to the storage.", Toast.LENGTH_SHORT).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                Uri downloadUrl = taskSnapshot.getDownloadUrl();
                Toast.makeText(ProfileActivity.this, "Downloaded successfully.", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private String getRealPathFromURI(Uri contentURI) {
        String result;
        Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) { // Source is Dropbox or other similar local file path
            result = contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        }
        return result;
    }

    public void changeUserInfo(String path) {
        String userId = user.getUid();
        DatabaseReference mRef =  database.getReference().child("Users").child(userId).child("url");
        mRef.setValue(path);
    }

}
