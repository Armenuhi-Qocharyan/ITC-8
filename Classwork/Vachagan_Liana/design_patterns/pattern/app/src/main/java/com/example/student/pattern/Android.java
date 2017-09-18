package com.example.student.pattern;

/**
 * Created by student on 9/18/17.
 */

public class Android implements PhoneOs {
    @Override
    public boolean turnOn() {
        return false;
    }

    @Override
    public boolean turnOff() {
        return false;
    }

    @Override
    public void setProgramm(String programm) {

    }

    @Override
    public String[] getProgramm() {
        return new String[0];
    }
}
