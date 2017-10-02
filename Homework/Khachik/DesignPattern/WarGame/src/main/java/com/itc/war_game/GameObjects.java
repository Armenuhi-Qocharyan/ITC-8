package com.itc.war_game;

public abstract class GameObjects {
    public double radius;
    public double x;
    public double y;
    public double vectorX;
    public double vectorY;

    public GameObjects(double x, double y, double angle, double speed, double radius) {
        this.radius = radius;
        this.x = x;
        this.y = y;
        double x1 = x +  Math.cos(Math.toRadians(angle));
        double y1 = y +  Math.sin(Math.toRadians(angle));
        this.vectorX = x1 - x;
        this.vectorY = y1 - y;
    }
    
    public abstract boolean shot(Weapon weapon, Soldiery shotter);

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getVectorX() {
        return vectorX;
    }

    public void setVectorX(double vectorX) {
        this.vectorX = vectorX;
    }

    public double getVectorY() {
        return vectorY;
    }

    public void setVectorY(double vectorY) {
        this.vectorY = vectorY;
    }

}
