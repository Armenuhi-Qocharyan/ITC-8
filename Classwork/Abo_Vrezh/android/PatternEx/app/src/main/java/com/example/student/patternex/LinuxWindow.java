package com.example.student.patternex;

/**
 * Created by student on 9/18/17.
 */

public class LinuxWindow implements CustomWindow{
    private String type="";

    public LinuxWindow() {
        type = "Linux_Window";
    }
    @Override
    public String getWindowType() {
        return this.type;

    }
}
