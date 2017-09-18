package com.example.student.pattern;

import android.provider.ContactsContract;

/**
 * Created by student on 9/18/17.
 */

public class ApplePhone implements Phone {
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
        return R.drawable.apple;
    }
}
