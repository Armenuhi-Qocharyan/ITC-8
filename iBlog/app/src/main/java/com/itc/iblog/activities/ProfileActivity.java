package com.itc.iblog.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
import com.itc.iblog.R;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Locale;


public class ProfileActivity extends AppCompatActivity {
    private String whatImage;
    private FloatingActionButton avatar;
    private ImageView editIcon;
    private ImageView bgImage;
    private TextView userName;
    private TextView email;
    private TextView userAge;
    private FloatingActionButton floatingActionButton;
    private Button follow;
    private FirebaseDatabase database;
    private StorageReference storageRef;
    private String userKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        Configuration config = getBaseContext().getResources().getConfiguration();

        String lang = settings.getString("LANG", "");
        if (! "".equals(lang) && ! config.locale.getLanguage().equals(lang)) {
            Locale locale = new Locale(lang);
            Locale.setDefault(locale);
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        }

        database =  FirebaseDatabase.getInstance();
        floatingActionButton = (FloatingActionButton) findViewById(R.id.floating_avatar);
        editIcon = (ImageView) findViewById(R.id.edit_icon);
        bgImage = (ImageView) findViewById(R.id.bg_image);
        follow = (Button) findViewById(R.id.profile_follow);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        boolean owner = true;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
            if(extras == null || extras.getString("key").equals(userId)) {
                userKey = FirebaseAuth.getInstance().getCurrentUser().getUid();
                follow.setVisibility(View.INVISIBLE);
            } else {
                owner = false;
                editIcon.setVisibility(View.INVISIBLE);
                findViewById(R.id.profile_follow).setVisibility(View.VISIBLE);
                userKey= extras.getString("key");
                if (extras.getBoolean("followed")) {
                    follow.setText("Unfollow");
                } else {
                    follow.setText("Follow");
                }
            }
        } else {
            userKey = FirebaseAuth.getInstance().getCurrentUser().getUid();
            follow.setVisibility(View.INVISIBLE);
        }
        setImage("bg");
        setImage("avatar");
        if ( owner ) {
            floatingActionButton.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    whatImage = "avatar";
                    Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(galleryIntent, 1);
                    return false;
                }
            });

            editIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    whatImage = "bg";
                    Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(galleryIntent, 1);
                }
            });
        } else {
            follow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final DatabaseReference reference = database.getReference("Users");
                    reference.addListenerForSingleValueEvent(new ValueEventListener() {
                        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            if(snapshot.child(userId).child("followers").hasChild(userKey)) {
                                snapshot.child(userId).child
                                        ("followers").child(userKey).getRef()
                                        .removeValue();
                                snapshot.child(userKey).child("following").child(userId).getRef().removeValue();
                                follow.setText("Follow");
                            } else {
                                reference.child(userId).child("followers").child(userKey).getRef().setValue(true);
                                reference.child(userKey).child("following").child(userId).getRef().setValue(true);
                                follow.setText("Unfollow");
                            }

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                }
            });

        }




    }

    private void setImage(final String img) {
        this.storageRef = FirebaseStorage.getInstance().getReference();
        DatabaseReference dbRef = database.getReference().child("Users");
        dbRef.child(userKey).addListenerForSingleValueEvent (new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String url = "";
                if (img.equals("avatar")) {
                    userName = (TextView) findViewById(R.id.profile_username);
                    email = (TextView) findViewById(R.id.profile_email);
                    userAge = (TextView) findViewById(R.id.profile_age);
                    String user = (String) dataSnapshot.child("userName").getValue();
                    String userEmail = (String) dataSnapshot.child("email").getValue();
                    userName.setText(user);
                    email.setText(userEmail);
                    Long age = (Long) dataSnapshot.child("age").getValue();
                    userAge.append(age.toString());
                    url = (String) dataSnapshot.child("url").getValue();
                } else if(img.equals("bg")) {
                    url = (String) dataSnapshot.child("bgUrl").getValue();
                }
                // Get avatar image
                if (url != null) {
                    StorageReference pathReference = storageRef.child(url);
                    if(url.equals("null") && img.equals("bg")) {
                        bgImage.setImageResource(R.drawable.background_img);
                        return;
                    }
                    final long ONE_MEGABYTE = 1024 * 1024;
                    pathReference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                        @Override
                        public void onSuccess(byte[] bytes) {
                            Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                            if (bmp.equals(null)) {
                                Toast.makeText(ProfileActivity.this, R.string.image_not_found, Toast.LENGTH_SHORT).show();
                                return;
                            }
                            if (img.equals("avatar")) {
                                Bitmap bitmap = Bitmap.createScaledBitmap(bmp, 200, 200, false);
                                Bitmap result = getCroppedBitmap(bitmap);
                                ProfileActivity.this.avatar = (FloatingActionButton) findViewById(R.id.floating_avatar);
                                avatar.setImageBitmap(result);
                            } else if(img.equals("bg")) {
                                ProfileActivity.this.bgImage = (ImageView) findViewById(R.id.bg_image);
                                bgImage.setImageBitmap(bmp);
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            System.out.println(R.string.image_not_found);
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
                if(whatImage.equals("avatar")) {
                    putImageToStorage(selectedImage, filename);
                    changeUserInfo("images/" + filename);
                    this.avatar = (FloatingActionButton) findViewById(R.id.floating_avatar);
                    Bitmap bitmap = Bitmap.createScaledBitmap(selectedImage, 200, 200, false);
                    Bitmap result = getCroppedBitmap(bitmap);
                    avatar.setImageBitmap(result);
                } else if (whatImage.equals("bg")) {
                    putImageToStorage(selectedImage, filename);
                    changeUserInfo("bgImages/" + filename);
                    this.bgImage = (ImageView) findViewById(R.id.bg_image);
                    bgImage.setImageBitmap(selectedImage);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, R.string.something_went_wrong, Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(this, R.string.not_picked_image,Toast.LENGTH_LONG).show();
        }
    }

    public void putImageToStorage(Bitmap btm, String filename) {
        Bitmap selectedImage = null;
        if(whatImage.equals("avatar")) {
            selectedImage = scaleDown(btm, 300, true);
        } else if (whatImage.equals("bg")) {
            selectedImage = scaleDown(btm, 600, true);
        }
        StorageReference ImageRef = null;
        if (whatImage.equals("avatar")) {
            ImageRef = storageRef.child("images/" + filename);
        } else if (whatImage.equals("bg")) {
            ImageRef = storageRef.child("bgImages/" + filename);
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        selectedImage.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] buteData = baos.toByteArray();

        UploadTask uploadTask = ImageRef.putBytes(buteData);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
                Toast.makeText(ProfileActivity.this, R.string.not_upload_image, Toast.LENGTH_SHORT).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                Uri downloadUrl = taskSnapshot.getDownloadUrl();
                Toast.makeText(ProfileActivity.this, R.string.upload_successfully, Toast.LENGTH_SHORT).show();
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
        //String userId = user.getUid();
        DatabaseReference mRef = null;
        if (whatImage.equals("avatar")) {
            mRef = database.getReference().child("Users").child(userKey).child("url");
        } else if(whatImage.equals("bg")) {
            mRef = database.getReference().child("Users").child(userKey).child("bgUrl");
        }
        mRef.setValue(path);
    }


    public static Bitmap scaleDown(Bitmap realImage, float maxImageSize, boolean filter) {
        float ratio = Math.min(
                (float) maxImageSize / realImage.getWidth(),
                (float) maxImageSize / realImage.getHeight());
        int width = Math.round((float) ratio * realImage.getWidth());
        int height = Math.round((float) ratio * realImage.getHeight());

        Bitmap newBitmap = Bitmap.createScaledBitmap(realImage, width,
                height, filter);
        return newBitmap;
    }

}
