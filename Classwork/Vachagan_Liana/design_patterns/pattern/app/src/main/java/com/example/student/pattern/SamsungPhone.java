package com.example.student.pattern;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by student on 9/18/17.
 */

public class SamsungPhone implements Phone {
    @Override
    public boolean call(String number) {
        return false;
    }

    @Override
    public boolean takePicture() {
        return false;
    }

    @Override
    public int show() {
        return R.drawable.samsung;
    }
}
