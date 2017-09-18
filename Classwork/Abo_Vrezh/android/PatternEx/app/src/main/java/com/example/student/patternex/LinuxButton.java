package com.example.student.patternex;

/**
 * Created by student on 9/18/17.
 */

public class LinuxButton implements  CustomButton{
    private String type="";

    public LinuxButton() {
        type = "Linux_Button";
    }
    @Override
    public String getButtonType() {
        return this.type;

    }
}
