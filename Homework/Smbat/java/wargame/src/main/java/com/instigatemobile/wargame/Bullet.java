/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instigatemobile.wargame;

import java.awt.Point;

/**
 * This class represents an Bullet object that exists on the game area
 * 
 * All specific objects have the following common properties:
 * <pre>
 * - range
 * - damage
 * </pre>
 * 
 * @author smbat
 */
public class Bullet extends GameObject {
        private int range;
        private int damage;

        /**
         * Creates a Bullet with specified parameters
         * 
         * @param position initial bullet position (an not be null)
         * @param velocity initial bullet velocity (can not be null)
         * @param size initial bullet size (i.e. radius). Must be greater than 0.
         * @param range initial bullet fly distance (Must be greater than 0.)
         * @param damage initial bullet inflicted damage by hitting (Must be greater than 0.)
         * **/
        
    public Bullet(Point position, Point velocity, int size, int range, int damage) {
        super(position, velocity, size);
        this.range = range;
        this.damage = damage;
    }

    public int getRange() {
        return range;
    }

    public int getDamage() {
        return damage;
    }

    
    @Override
    public boolean realiseCollision(GameObject other) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getChildClassId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    

}
