package com.example.student.patternex;

import android.widget.TextView;

/**
 * Created by student on 9/18/17.
 */

public class WinButton implements CustomButton {
    private String type="";

    public WinButton() {
        type = "Windows_Button";
    }
    @Override
    public String getButtonType() {
        return this.type;

    }
}
