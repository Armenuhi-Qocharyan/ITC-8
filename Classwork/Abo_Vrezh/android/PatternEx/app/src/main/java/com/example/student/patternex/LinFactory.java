package com.example.student.patternex;

/**
 * Created by student on 9/18/17.
 */

public class LinFactory extends Factory {

        @Override
        public CustomButton getButton() {
            CustomButton button = new LinuxButton();
            return button;
        }

        @Override
        public CustomWindow getWindow() {
            CustomWindow button = new LinuxWindow();
            return button;
        }

}
