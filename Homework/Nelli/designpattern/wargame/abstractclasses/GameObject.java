/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wargame.abstractclasses;

import java.awt.Point;

/**
 *
 * @author nelliM
 */
 public abstract class GameObject {
    private int strength;
    private int radius;
    private Point position;
    private Point velocity;
    
    abstract public void move(int time);
    public boolean collide(GameObject other) {
        if (Math.abs(other.getPosition().x - this.position.x) < other.getRadius() + this.radius) {
            return true;
        }
        if (Math.abs(other.getPosition().y - this.position.y) < other.getRadius() + this.radius) {
            return true;
        }
        return false;
    }

    public GameObject(int strength, int radius, Point position, Point velocity) {
        this.strength = strength;
        this.radius = radius;
        this.position = position;
        this.velocity = velocity;
    }

    public int getStrength() {
        return strength;
    }

    public int getRadius() {
        return radius;
    }

    public Point getPosition() {
        return position;
    }

    public Point getVelocity() {
        return velocity;
    }
    
    public void setPosition(Point position) {
        this.position = position;
    }

    public void setVelocity(Point velocity) {
        this.velocity = velocity;
    }
    
}
