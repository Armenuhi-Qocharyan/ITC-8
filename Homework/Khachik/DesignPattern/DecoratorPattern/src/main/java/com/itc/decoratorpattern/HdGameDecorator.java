package com.itc.decoratorpattern;

public class HdGameDecorator extends GameDecorator {
    
    public HdGameDecorator(ComputerGame decoratedGame) {
        super(decoratedGame);
    }
    
    @Override
    public void startGame() {
        decoratedGame.startGame();
        enableHdMode();
    }
    
    
    @Override
    public void exit() {
        decoratedGame.exit();
    }
    
    /**
     * Enabled HD mode in game.
     */
    public void enableHdMode() {
        System.out.println("Hd mode enabled");
    }
}
