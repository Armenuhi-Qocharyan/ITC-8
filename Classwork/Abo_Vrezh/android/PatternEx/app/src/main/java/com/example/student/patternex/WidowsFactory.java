package com.example.student.patternex;

/**
 * Created by student on 9/18/17.
 */

public class WidowsFactory extends Factory {
    @Override
    public CustomButton getButton() {
        CustomButton button = new WinButton();
        return button;
    }

    @Override
    public CustomWindow getWindow() {
        CustomWindow button = new WinWindow();
        return button;
    }
}
