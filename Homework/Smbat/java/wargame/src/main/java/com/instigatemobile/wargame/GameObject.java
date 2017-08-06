/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instigatemobile.wargame;

import java.awt.Point;

/**
 * This class represents an object that exists on the game area.
 * 
 * All specific objects have the following common properties:
 * <pre>
 * - position
 * - velocity
 * - size
 * </pre>
 * 
 * @author areg.gareginyan
 */
public class GameObject {
    
    private Point position;
    private Point velocity;
    private int size;
    
    /**
     * Creates a GameObject with specified parameters
     * 
     * @param position initial object position (an not be null)
     * @param velocity initial object velocity (can not be null)
     * @param size object size (i.e. radius). Must be greater than 0.
     */
    public GameObject(Point position, Point velocity, int size) {
        // TODO - check parameters (e.g. size)
        this.position = position;
        this.velocity = velocity;
        this.size = size;
    }
    
    /**
     * 
     * @return Current object position
     */
    public Point getPosition() {
        return this.position;
    }
    
    /**
     * 
     * @return Current object velocity
     */
    public Point getVelocity() {
        return this.velocity;
    }
    
    /**
     * 
     * @return Object size
     */
    public int getSize() {
        return this.size;
    }
    
    /**
     * 
     * @param velocity new velocity to be set
     */
    public void setVelocity(Point velocity) {
        this.velocity = velocity;
    }
    
    /**
     * Move the object based on its current position and velocity.
     * 
     * @param time time (in seconds) during which the object is moved.
     */
    public void move(int time) {
        position.x += velocity.x * time;
        position.y += velocity.y * time;
    }
    
    /**
     * @param other checking current object collision with object "other"
     * @return true if objects have collision
     */    
    public boolean isCollision (GameObject other) {
        return ( this.position.distance(other.position) <= (this.size + other.size) );
    }
    
    public int getChildClassId(){return 0;}
    public boolean realiseCollision(GameObject other){return false;}

}
