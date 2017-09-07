package com.instigatemobile.imessenger.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.instigatemobile.imessenger.R;
import com.instigatemobile.imessenger.adapters.ProfileContentAdapter;
import com.instigatemobile.imessenger.controllers.DataBase;
import com.instigatemobile.imessenger.controllers.ProfileCallbackInterface;
import com.instigatemobile.imessenger.controllers.RoundImage;
import com.instigatemobile.imessenger.controllers.Storage;
import com.instigatemobile.imessenger.models.Profile;


import java.io.FileNotFoundException;
import java.io.InputStream;


import static android.app.Activity.RESULT_OK;

public class ProfileFragment extends Fragment implements View.OnClickListener, View.OnLongClickListener {
    private final int RESULT_LOAD_IMAGE = 0;
    private int clickAction = 0;
    private Profile profile;

    private DataBase database;
    private Storage storage;
    private ProfileCallbackInterface callback;


    private View rootView;
    private ImageView imageView;
    private ImageButton changeBackground;
    private LinearLayout background;
    private TextView name;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initProfileCallbackMethods();
        database = DataBase.initDataBase();
        database.getCurrentProfile(callback);
    }

    private void initProfileCallbackMethods() {
        callback = new ProfileCallbackInterface() {
            @Override
            public void responseProfile(Profile prf) {
                profile = prf;
                storage = Storage.initStorage();
                storage.downloadImageFromStorage(profile.getBackground(), "background", callback);
                storage.downloadImageFromStorage(profile.getAvatar(), "avatar", callback);
                name.setText(profile.getName());
                initProfileRecycleViewContent();
            }

            @Override
            public void changeImage(String path, String imageName) {
                if (imageName == "avatar") {
                    database.changeProfileAvatar(path);
                } else if (imageName == "background") {
                    database.changeProfileBackground(path);
                }
            }

            @Override
            public void setBackgroundAvatar(Bitmap imageBitmap) {
                if (imageBitmap != null) {
                    int sdk = android.os.Build.VERSION.SDK_INT;
                    if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                        background.setBackgroundDrawable(new BitmapDrawable(imageBitmap));
                    } else {
                        background.setBackground(new BitmapDrawable(imageBitmap));
                    }
                }
            }

            @Override
            public void setAvatar(Bitmap imageBitmap) {
                if (imageBitmap != null) {
                    imageBitmap = quadraticImage(imageBitmap);
                    RoundImage roundedImage = new RoundImage(imageBitmap);
                    imageView.setImageDrawable(roundedImage);
                } else {
                    imageView.setImageResource(R.drawable.avatar1);

                }
            }
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        initView();
        return rootView;
    }

    private  void initView() {
        imageView = (ImageView) rootView.findViewById(R.id.avatar);
        changeBackground = (ImageButton) rootView.findViewById(R.id.changeBackground);
        background = (LinearLayout) rootView.findViewById(R.id.linerBackground);
        name = (TextView) rootView.findViewById(R.id.profile_name);
        setListeners();
    }

    @Override
    public void onClick(View view) {
        if (view == changeBackground) {
            clickAction = 0;// clicked change background button
            choseImageFromMedia(RESULT_LOAD_IMAGE);
        }
    }

    @Override
    public boolean onLongClick(View view) {
        if (view ==  imageView) {
            clickAction = 1;// clicked avatar ImageView
            choseImageFromMedia(RESULT_LOAD_IMAGE);
        }
        return false;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();

            Bitmap bitmap = null;
            try {
                bitmap = BitmapFactory.decodeStream(this.getActivity().getContentResolver().openInputStream(selectedImage));
                String path = getRealPathFromURI(selectedImage);
                InputStream stream = this.getActivity().getContentResolver().openInputStream(selectedImage);

                if (clickAction == 1) {
                    storage.uploadImageToStorage(stream, path, "avatar", callback);

               /* bitmap = quadraticImage(bitmap);
                RoundImage roundedImage = new RoundImage(bitmap);
                imageView.setImageDrawable(roundedImage);*/
                } else if (clickAction == 0) {
                    storage.uploadImageToStorage(stream, path, "background", callback);

               /* LinearLayout layout = (LinearLayout) rootView.findViewById(R.id.linerBackground);
                int sdk = android.os.Build.VERSION.SDK_INT;
                if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    layout.setBackgroundDrawable(new BitmapDrawable(bitmap));
                } else {
                    layout.setBackground(new BitmapDrawable(bitmap));
                }*/
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();


            }

        }

    }

    private String getRealPathFromURI(Uri contentURI) {

        String thePath = "no-path-found";
        String[] filePathColumn = {MediaStore.Images.Media.DISPLAY_NAME};
        Cursor cursor = this.getActivity().getContentResolver().query(contentURI, filePathColumn, null, null, null);
        if(cursor.moveToFirst()){
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            thePath = cursor.getString(columnIndex);
        }
        cursor.close();
        return  thePath;
    }

    private void setListeners() {
        imageView.setOnLongClickListener(this);
        changeBackground.setOnClickListener(this);
    }


    private void choseImageFromMedia(final int loadImage) {
        Intent intent = new Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(intent, loadImage);
    }

    private void initProfileRecycleViewContent() {
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.rv);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(llm);


        ProfileContentAdapter adapter = new ProfileContentAdapter(profile);
        recyclerView.setAdapter(adapter);
    }

    private Bitmap quadraticImage(Bitmap bitmap) {
        if (bitmap.getWidth() >= bitmap.getHeight()){
            bitmap = Bitmap.createBitmap(
                    bitmap,
                    bitmap.getWidth()/2 - bitmap.getHeight()/2,
                    0,
                    bitmap.getHeight(),
                    bitmap.getHeight()
            );

        } else {
            bitmap = Bitmap.createBitmap(
                    bitmap,
                    0,
                    bitmap.getHeight()/2 - bitmap.getWidth()/2,
                    bitmap.getWidth(),
                    bitmap.getWidth()
            );
        }
        return bitmap;
    }
/*
    private void setBackgoundAvatar(int imageResourcesId) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imageResourcesId);
        int sdk = android.os.Build.VERSION.SDK_INT;
        if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            background.setBackgroundDrawable(new BitmapDrawable(bitmap));
        } else {
            background.setBackground(new BitmapDrawable(bitmap));
        }
    }

    private void setAvatar(int imageResourcesId) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imageResourcesId);
        bitmap = quadraticImage(bitmap);
        RoundImage roundedImage = new RoundImage(bitmap);
        imageView.setImageDrawable(roundedImage);
    }*/

}