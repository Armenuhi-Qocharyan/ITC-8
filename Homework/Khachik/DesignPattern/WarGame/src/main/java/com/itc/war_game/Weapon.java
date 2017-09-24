package com.itc.war_game;

public abstract class Weapon extends GameObjects{
    int range;

    public Weapon(double x, double y, double angle, double speed, double radius, int range) {
        super(x, y, angle, speed, radius);
        this.range = range;
    }
    
    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
    
    public abstract void hitting(Ordinary ordinary);
    public abstract void hitting(Major major);
    public abstract void hitting(General general);
}
