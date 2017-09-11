package com.itc.iblog.interfaces;

import android.graphics.Bitmap;

import com.itc.iblog.models.PostModel;

/**
 * Created by student on 9/11/17.
 */

public interface ImageLoaderInterface {
    public Bitmap loadImage(PostModel post);

}
