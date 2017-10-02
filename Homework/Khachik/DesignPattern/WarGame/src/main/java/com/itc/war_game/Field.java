package com.itc.war_game;

import java.util.ArrayList;

public class Field {
    static private Field instance = null;
    private static ArrayList<GameObjects> objects;

    private Field() {
        objects = new ArrayList<GameObjects>();
    }

    /**
     * Get Meadow singleton class object
     */
    public static synchronized Field getInstance() {
        if (instance == null)
            instance = new Field();
        return instance;
    }
    
    public static void setObjects (GameObjects obj) {
        objects.add(obj);
    }
    
    public ArrayList<GameObjects> getObjs () {
        return objects;
    }
    
    public void fire(Weapon weapon, Soldiery shotter) {
        for(int i = 0; i < weapon.getRange(); ++i ) { 
            weapon.setX(weapon.getX() + weapon.getVectorX());
            weapon.setY(weapon.getY() + weapon.getVectorY());
            for(GameObjects target: objects) {
                if (target.shot(weapon, shotter)) {
                    if(((Soldiery)target).getLife() <= 0){
                        System.out.println("\nSoldier " + ((Soldiery)target).getName() + " died." );
                        objects.remove(target);
                        return;
                    }
                    System.out.println("\nSoldier " + ((Soldiery)target).getName() + " have " + ((Soldiery)target).getLife() + " life.");
                    return;
                }
            }
        }
        System.out.println("You missed.");
    }
}
