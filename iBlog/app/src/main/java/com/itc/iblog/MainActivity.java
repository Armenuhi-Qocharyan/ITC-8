package com.itc.iblog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.itc.iblog.adapters.listAdapter;
import com.itc.iblog.fragments.loginFragment;
import com.itc.iblog.fragments.postsFragment;
import com.itc.iblog.fragments.usersFragment;
import com.itc.iblog.models.DataModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private CircleImageView avatar;
    private DatabaseReference mDatabase;
    private TextView userName;
    private TextView email;
    private String avatarUrl;
    private StorageReference storageRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setAvatar();


        final Context context = this;
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog);

        dialog.setTitle(" Add your post ");
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Button dialogButtonOk = (Button) dialog.findViewById(R.id.dialogButtonOK);
                dialogButtonOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText addTitle = dialog.findViewById(R.id.add_post_title);
                        String title = addTitle.getText().toString();

                        EditText addText = dialog.findViewById(R.id.add_post_title);
                        String text = addTitle.getText().toString();

                        final FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference ref = database.getReference("Posts");
                        ref.child(userName.getText().toString() + new Date().toString()).setValue(new DataModel(userName.getText().toString(),email.getText().toString(),R.drawable.user,0,"2 Sep 11:40",title,text,0,0));
                        Toast.makeText(MainActivity.this, " Your post successfuly added. ", Toast.LENGTH_SHORT).show();
                        EditText postTitle = dialog.findViewById(R.id.add_post_title);
                        postTitle.setText("");
                        EditText postText = dialog.findViewById(R.id.add_post_text);
                        postText.setText("");
                        dialog.dismiss();
                    }
                });
                Button dialogButtonCencel = (Button) dialog.findViewById(R.id.dialogButtonCencel);
                dialogButtonCencel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText postTitle = dialog.findViewById(R.id.add_post_title);
                        postTitle.setText("");
                        EditText postText = dialog.findViewById(R.id.add_post_text);
                        postText.setText("");
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        if(null == savedInstanceState) {
            Fragment fragment = new postsFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.replace(R.id.contentFragment, fragment);
            transaction.commit();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.Posts) {

        } else if (id == R.id.Folowers) {

        } else if (id == R.id.Favorite_post) {

        } else if (id == R.id.Users) {
            Fragment fragment = new usersFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.replace(R.id.contentFragment, fragment);
            transaction.commit();

        } else if (id == R.id.About_us) {

        } else if (id == R.id.Language) {

        } else if (id == R.id.Log_out) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Get user avatar image, username and email from firebase.
     */
    private void setAvatar() {
        this.storageRef = FirebaseStorage.getInstance().getReference();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference dbRef = mDatabase.child("Users");
        dbRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addListenerForSingleValueEvent (new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                userName = (TextView) findViewById(R.id.header_user_name);
                email = (TextView) findViewById(R.id.header_user_email);
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
            public void onCancelled(DatabaseError databaseError) {}

        });
    }
    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0 ){
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    private void addPost() {

    }
}
