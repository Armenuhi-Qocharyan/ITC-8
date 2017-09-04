package com.instigatemobile.imessenger.data;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.net.URL;

public class Profile {
    private String name;
    private String email;
    private String avatarURL;
    private String backgroundURL;
    private int favoritesCount;
    private int contactsCount;

    public Profile(String name, String email, String avatarURL, String backgroundURL, int favoritesCount, int contactsCount) {
        this.name = name;
        this.email = email;
        this.avatarURL = avatarURL;
        this.backgroundURL = backgroundURL;
        this.favoritesCount = favoritesCount;
        this.contactsCount = contactsCount;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAvatar() {
        return avatarURL;
    }

    public String getBackground() {
        return backgroundURL;
    }

    public Bitmap getAvatarWithBitmap() {
        Bitmap bitmap;
        try {
            URL url = new URL(avatarURL);
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            return bitmap;
        } catch (IOException exception) {
            System.out.println(exception);
        }
        return null;
    }

    public Bitmap getBackgroundWithBitmap() {
        Bitmap bitmap;
        try {
            URL url = new URL(backgroundURL);
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            return bitmap;
        } catch (IOException exception) {
            System.out.println(exception);
        }
        return null;
    }


    public int getFavoritesCount() {
        return favoritesCount;
    }

    public int getContactsCount() {
        return contactsCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAvatar(String avatar) {
        this.avatarURL = avatar;
    }

    public void setBackground(String backgrount) {
        this.backgroundURL = backgrount;
    }

    public void setFavoritesCount(int favoritesCount) {
        this.favoritesCount = favoritesCount;
    }

    public void setContactsCount(int contactsCount) {
        this.contactsCount = contactsCount;
    }
}
