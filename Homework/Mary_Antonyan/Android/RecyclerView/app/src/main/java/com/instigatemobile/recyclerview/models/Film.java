package com.instigatemobile.recyclerview.models;

import android.media.Image;
import android.widget.ImageView;

import java.net.URL;

/**
 * Created by student on 9/1/17.
 */

public class Film {
    private String title;
    private String description;
    private ImageView image;

    public Film(String title, String description, ImageView image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ImageView getimage() {
        return image;
    }

    public void setimage(ImageView image) {
        this.image = image;
    }
}