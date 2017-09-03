package com.instigatemobile.imessenger.profile;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.instigatemobile.imessenger.R;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

public class Profile extends Fragment {
    private View rootView;
    private ImageView imageView;
    private ImageButton changeAvatar;
    private final int RESULT_LOAD_IMAGE = 0;
    private int clickAction = 0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.avatar);
        RoundImage roundedImage = new RoundImage(bm);

        imageView = (ImageView) rootView.findViewById(R.id.avatar);
        imageView.setImageDrawable(roundedImage);
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                clickAction = 0;// clicked avatar ImageView
                choseImageFromMedia(RESULT_LOAD_IMAGE);
                return true;
            }
        });

        changeAvatar = (ImageButton) rootView.findViewById(R.id.changeAvatar);
        changeAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View view) {
                clickAction = 1;// clicked change background button
                choseImageFromMedia(RESULT_LOAD_IMAGE);
            }
        });
        initProfileRecycleViewContent();

        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();

            Bitmap bitmap = null;
            try {
                bitmap = BitmapFactory.decodeStream(this.getActivity().getContentResolver().openInputStream(selectedImage));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            if (clickAction == 0) {
                bitmap = quadraticImage(bitmap);
                Bitmap quadratic = bitmap;
                RoundImage roundedImage = new RoundImage(bitmap);
                imageView.setImageDrawable(roundedImage);
            } else {
                LinearLayout layout = (LinearLayout) rootView.findViewById(R.id.linerBackground);
                int sdk = android.os.Build.VERSION.SDK_INT;
                if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    layout.setBackgroundDrawable(new BitmapDrawable(bitmap));
                } else {
                    layout.setBackground(new BitmapDrawable(bitmap));
                }
            }

        }

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

        ArrayList<ProfileContent> contentList  = new ArrayList<>();
        contentList.add(new ProfileContent("Favorits", 10, R.mipmap.favorites));
        contentList.add(new ProfileContent("Contacts", 10, R.mipmap.contacts));

        ProfileContentAdapter adapter = new ProfileContentAdapter(contentList);
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


}