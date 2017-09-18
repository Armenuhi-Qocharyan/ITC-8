package com.example.student.pattern;

/**
 * Created by student on 9/18/17.
 */

public class SamsungFactory extends Factory {


    @Override
    public Phone createPhone() {
        return new SamsungPhone();
    }

    @Override
    public PhoneOs createOs() {
        return new Android();
    }
}
