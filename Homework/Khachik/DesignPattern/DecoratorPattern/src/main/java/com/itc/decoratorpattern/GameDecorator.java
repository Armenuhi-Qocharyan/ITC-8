package com.itc.decoratorpattern;

public abstract class GameDecorator implements ComputerGame {
    protected ComputerGame decoratedGame;

    
    public GameDecorator(ComputerGame decoratedGame) {
        this.decoratedGame = decoratedGame;
    }
    
    /**
     * Starts the game
     */
    @Override
    public void startGame() {
        decoratedGame.startGame();
    }
    
    /**
     * Exit from game
     */
    @Override
    public void exit() {
        decoratedGame.exit();;
    }
    
}
