package com.itc.decoratorpattern;

public class Shooter implements ComputerGame{

    /**
     * Starts the Shooter game
     */
    @Override
    public void startGame() {
        System.out.println("Shooter game is starting");
    }
    
    /**
     * Exit from Shooter game 
     */
    @Override
    public void exit() {
        System.out.println("Exiting");
    }
    
}
