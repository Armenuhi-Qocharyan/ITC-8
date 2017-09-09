package com.instigatemobile.imessenger.controllers;

import android.graphics.Bitmap;


public interface ProfileCallbackInterface {
    void changeImage(String path, String imageName);

    void setBackgroundAvatar(Bitmap bitmap);

    void setAvatar(Bitmap bitmap);

}
