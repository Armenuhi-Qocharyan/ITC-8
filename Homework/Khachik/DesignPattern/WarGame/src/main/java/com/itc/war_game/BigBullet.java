package com.itc.war_game;

public class BigBullet extends Weapon {
    public BigBullet(double x, double y, double angle) {
        super(x, y, angle, 1, 0.6, 140);
    }
    
    public boolean shot(Weapon weapon, Soldiery shotter) {
        return false;
    }
    
    @Override
    public void hitting(Ordinary ordinary) {
        ordinary.setLife(ordinary.getLife() - 50);
        System.out.print("The bullet reached its goal: (" + this.getX() + ", " + this.getY() + ")");
    }
    
    @Override
    public void hitting(Major major) {
        major.setLife(major.getLife() - 40);
        System.out.print("The bullet reached its goal: (" + this.getX() + ", " + this.getY() + ")");
    }
    
    @Override
    public void hitting(General general) {
        general.setLife(general.getLife() - 30);
        System.out.print("The bullet reached its goal: (" + this.getX() + ", " + this.getY() + ")");
    }

}
