package com.instigatemobile.imessenger.controllers;

import android.graphics.Bitmap;
import com.instigatemobile.imessenger.models.Profile;


public interface ProfileCallbackInterface {
    void responseProfile(Profile profile);
    void changeImage(String path, String imageName);

    void setBackgroundAvatar(Bitmap bitmap) ;

    void setAvatar(Bitmap bitmap);

}
