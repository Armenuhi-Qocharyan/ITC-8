package com.itc.iblog.activities;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import com.itc.iblog.R;
import com.itc.iblog.fragments.AboutUsFragment;
import com.itc.iblog.fragments.PostsFragment;
import com.itc.iblog.fragments.UsersFragment;
import com.itc.iblog.fragments.FollowersFragment;
import com.itc.iblog.interfaces.ImageLoaderInterface;
import com.itc.iblog.models.PostModel;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;


//@RuntimePermissions
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ImageLoaderInterface {

    private final int WRITE_EXTERNAL_STORAGE_PERMISSIONS_REQUEST = 1;
    private final int READ_EXTERNAL_STORAGE_PERMISSIONS_REQUEST = 2;

    private CircleImageView avatar;
    private DatabaseReference mDatabase;
    private TextView userName;
    private TextView email;

    public TextView getEmail() {
        return email;
    }

    public TextView getUserName() {
        return userName;
    }

    private String avatarUrl;
    private StorageReference storageRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        if (null == savedInstanceState) {
            Fragment fragment = new PostsFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.replace(R.id.contentFragment, fragment);
            transaction.commit();
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    WRITE_EXTERNAL_STORAGE_PERMISSIONS_REQUEST);
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    READ_EXTERNAL_STORAGE_PERMISSIONS_REQUEST);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        userName = (TextView) findViewById(R.id.header_user_name);
        email = (TextView) findViewById(R.id.header_user_email);
        setAvatar();
        return true;
    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.My_profile) {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.Posts) {
            Fragment fragment = new PostsFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.replace(R.id.contentFragment, fragment);
            transaction.commit();
        } else if (id == R.id.Folowers) {
            Fragment fragment = new FollowersFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.replace(R.id.contentFragment, fragment);
            transaction.commit();

        } else if (id == R.id.Favorite_post) {

        } else if (id == R.id.Users) {
            Fragment fragment = new UsersFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.replace(R.id.contentFragment, fragment);
            transaction.commit();

        } else if (id == R.id.About_us) {
            Fragment fragment = new AboutUsFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.replace(R.id.contentFragment, fragment);
            transaction.commit();

        } else if (id == R.id.Language) {
            showChangeLangDialog();
        } else if (id == R.id.Log_out) {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Log out")
                    .setMessage("Are you sure you want to log out?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            FirebaseAuth.getInstance().signOut();
                            startActivity(new Intent(MainActivity.this, LoginRegisterActivity.class)); //Go back to home page
                            finish();
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Get user avatar image, username and email from firebase.
     */

    public void showChangeLangDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.language_dialog, null);
        dialogBuilder.setView(dialogView);

        final Spinner spinner1 = (Spinner) dialogView.findViewById(R.id.spinner1);

        dialogBuilder.setTitle(getResources().getString(R.string.lang_dialog_title));
        //dialogBuilder.setMessage(getResources().getString(R.string.lang_dialog_message));
        dialogBuilder.setPositiveButton("Change", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                int langpos = spinner1.getSelectedItemPosition();
                switch (langpos) {
                    case 0: //English
                        PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("LANG", "en").commit();
                        setLangRecreate("en");
                        return;
                    case 1:
                        PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("LANG", "hy").commit();
                        setLangRecreate("hy");
                        return;
                    case 2:
                        PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("LANG", "ru").commit();
                        setLangRecreate("ru");
                        return;
                    default: //By default set to english
                        PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("LANG", "en").commit();
                        setLangRecreate("en");
                        return;
                }
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    public void setLangRecreate(String langval) {
        Configuration config = getBaseContext().getResources().getConfiguration();
        Locale locale = new Locale(langval);
        Locale.setDefault(locale);
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }

    private void setAvatar() {
        this.storageRef = FirebaseStorage.getInstance().getReference();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference dbRef = mDatabase.child("Users");
        dbRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String user = (String) dataSnapshot.child("userName").getValue();
                String userEmail = (String) dataSnapshot.child("email").getValue();
                String url = (String) dataSnapshot.child("url").getValue();
                MainActivity.this.userName.setText(user);
                MainActivity.this.email.setText(userEmail);
                avatarUrl = url;
                // Get avatar image
                if (avatarUrl != null) {
                    StorageReference pathReference = MainActivity.this.storageRef.child(avatarUrl);

                    final long ONE_MEGABYTE = 1024 * 1024;
                    pathReference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                        @Override
                        public void onSuccess(byte[] bytes) {
                            Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                            if (bmp.equals(null)) {
                                Toast.makeText(MainActivity.this, "Avatar image not found.", Toast.LENGTH_SHORT).show();
                            }
                            MainActivity.this.avatar = (CircleImageView) findViewById(R.id.profile_avatar);
                            avatar.setImageBitmap(Bitmap.createScaledBitmap(bmp, 120, 120, false));
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
            public void onCancelled(DatabaseError databaseError) {
            }

        });
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        // Make sure it's our original READ_CONTACTS request
        if (requestCode == WRITE_EXTERNAL_STORAGE_PERMISSIONS_REQUEST) {
            if (grantResults.length == 1 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Read Contacts permission granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Read Contacts permission denied", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == READ_EXTERNAL_STORAGE_PERMISSIONS_REQUEST) {
            if (grantResults.length == 1 &&
                    grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Read Contacts permission granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Read Contacts permission denied", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public Bitmap loadImage(PostModel post) {
        final Bitmap[] bitmap = new Bitmap[1];

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    WRITE_EXTERNAL_STORAGE_PERMISSIONS_REQUEST);
        } else {
            String root = Environment.getExternalStorageDirectory().toString();
            File dir = new File(root + "/iBlog_posts_images");

            if (!dir.exists()) {
                dir.mkdir();
            }
            final File file = new File(dir, "post" + post.getPostId() + ".png");

            if (!file.exists()) {
                final Bitmap[] bmp = new Bitmap[1];
                StorageReference pathReference = storageRef.child("Posts").child(post.getPostId()).child("image");
                final long ONE_MEGABYTE = 1024 * 1024;
                pathReference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                    @Override
                    public void onSuccess(byte[] bytes) {
                        bmp[0] = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
//                    holder.postImage.setImageBitmap(bmp);
//                    holder.postImage.setVisibility(View.VISIBLE);
                        FileOutputStream fOut = null;

                        try {
                            fOut = new FileOutputStream(file);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }

                        bmp[0].compress(Bitmap.CompressFormat.PNG, 85, fOut);
                        try {
                            fOut.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            fOut.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }

                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        System.out.println("Image not found.");
                    }
                });
                return bmp[0];
            } else {
                System.out.println("bla read");
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                bitmap[0] = BitmapFactory.decodeFile(String.valueOf(file), options);
                return bitmap[0];
//            holder.postImage.setImageBitmap(bitmap);
//            holder.postImage.setVisibility(View.VISIBLE);
            }

        }
        return  null;
    }
}
