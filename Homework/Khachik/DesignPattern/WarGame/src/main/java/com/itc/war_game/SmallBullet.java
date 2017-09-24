package com.itc.war_game;

public class SmallBullet extends Weapon {

    public SmallBullet(double x, double y, double angle) {
        super(x, y, angle, 1, 0.2, 100);
    }
    
    public boolean shot(Weapon weapon, Soldiery shotter) {
        return false;
    }
    
    @Override
    public void hitting(Ordinary ordinary) {
        ordinary.setLife(ordinary.getLife() - 20);
        System.out.print("The bullet reached its goal: (" + this.getX() + ", " + this.getY() + ")");
    }
    
    @Override
    public void hitting(Major major) {
        major.setLife(major.getLife() - 15);
        System.out.print("The bullet reached its goal: (" + this.getX() + ", " + this.getY() + ")");
    }
    
    @Override
    public void hitting(General general) {
        general.setLife(general.getLife() - 10);
        System.out.print("The bullet reached its goal: (" + this.getX() + ", " + this.getY() + ")");
    }

    
}
