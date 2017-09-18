package com.example.student.patternex;

/**
 * Created by student on 9/18/17.
 */

public class WinWindow implements CustomWindow {
    private String type="";

    public WinWindow() {
        type = "Windows_Window";
    }

    @Override
    public String getWindowType() {
        return this.type;
    }
}
