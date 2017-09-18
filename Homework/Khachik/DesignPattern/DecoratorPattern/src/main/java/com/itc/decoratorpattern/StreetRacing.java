package com.itc.decoratorpattern;


public class StreetRacing implements ComputerGame {

    /**
     * Starts the street racing game
     */
    @Override
    public void startGame() {
        System.out.println("Street racing game is starting.");
    }

    /**
     * Exit from street racing game 
     */
    @Override
    public void exit() {
        System.out.println("Exiting");
    }
}
