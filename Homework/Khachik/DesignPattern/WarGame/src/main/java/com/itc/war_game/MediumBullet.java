package com.itc.war_game;

public class MediumBullet extends Weapon {
    public MediumBullet(double x, double y, double angle) {
        super(x, y, angle, 1, 0.4, 120);
    }
    
    public boolean shot(Weapon weapon, Soldiery shotter) {
        return false;
    }
    
    @Override
    public void hitting(Ordinary ordinary) {
        ordinary.setLife(ordinary.getLife() - 35);
        System.out.print("The bullet reached its goal: (" + this.getX() + ", " + this.getY() + ")");
    }
    
    @Override
    public void hitting(Major major) {
        major.setLife(major.getLife() - 25);
        System.out.print("The bullet reached its goal: (" + this.getX() + ", " + this.getY() + ")");
    }
    
    @Override
    public void hitting(General general) {
        general.setLife(general.getLife() - 15);
        System.out.print("The bullet reached its goal: (" + this.getX() + ", " + this.getY() + ")");
    }

}
