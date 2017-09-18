package com.itc.decoratorpattern;

public class Main {
    public static void main(String[] args) {
       ComputerGame streetRacing = new StreetRacing();

       ComputerGame hdStreetRacing = new HdGameDecorator(new StreetRacing());

       ComputerGame hdShooter = new HdGameDecorator(new Shooter());

       System.out.println("\nSimple graphic street racing game");
       streetRacing.startGame();

       System.out.println("\nHD graphic street racing game");
       hdStreetRacing.startGame();

       System.out.println("\nHD graphic shooter game");
       hdShooter.startGame();
    }    
}
