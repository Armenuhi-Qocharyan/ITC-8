package com.example.student.patternex;

import android.widget.Button;

/**
 * Created by student on 9/18/17.
 */

public abstract class Factory {
    abstract public CustomButton getButton();
    abstract public CustomWindow getWindow();
}
