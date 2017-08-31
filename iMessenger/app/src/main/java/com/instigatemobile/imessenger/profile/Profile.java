package com.instigatemobile.imessenger.profile;

/**
 * Created by vachagan on 8/31/17.
 */
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.instigatemobile.imessenger.R;

public class Profile  extends Fragment {
    private ImageView  imageView;
    private ImageButton changeAvatar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.avatar);
        RoundImage roundedImage = new RoundImage(bm);

        imageView = (ImageView) rootView.findViewById(R.id.avatar);
        imageView.setImageDrawable(roundedImage);
        changeAvatar = (ImageButton) rootView.findViewById(R.id.changeAvatar);

        changeAvatar.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(
                        "content://media/internal/images/media"));
                startActivity(intent);
            }
        });



        return rootView;
    }
}