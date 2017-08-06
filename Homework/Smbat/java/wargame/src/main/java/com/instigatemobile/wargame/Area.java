/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instigatemobile.wargame;

import java.util.ArrayList;

/**
 * This class represents the game are, class simulates and controls the objects moving
 * 
 * @author Smbat
 */
public class Area {
    private ArrayList <GameObject> gameObjects = new ArrayList<GameObject>();
    
    public void moveObjects() {
        for (GameObject object: gameObjects) {
            object.move(1);
            for (GameObject other: gameObjects) {
                if (object != other && object.isCollision(other)) {
                   object.realiseCollision(other);
                }
            }
        }
    }
    
}
