package com.example.student.pattern;

/**
 * Created by student on 9/18/17.
 */

public class AppleFactory extends Factory {
    @Override
    public Phone createPhone() {
        return new ApplePhone();
    }

    @Override
    public PhoneOs createOs() {
        return new IOS();
    }
}
