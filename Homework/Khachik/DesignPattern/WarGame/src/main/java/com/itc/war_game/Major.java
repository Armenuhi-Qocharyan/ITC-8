package com.itc.war_game;

import java.util.Scanner;

public class Major extends Soldiery {
    
     public Major() {
         super();
     }
    
    public Major(double x, double y, String name, int life) {
        super(x, y, 0, 0, 15, name, life);
    }
    
    @Override
    public Weapon takeWeapon() {
        Scanner scan =  new Scanner(System.in);
        System.out.print("Enter the shot angle:\nangle = ");
        int angle = scan.nextInt();
        System.out.println("\nEnter the weapon:\npistol - 1\nak-47 - 2");
        int weapon = scan.nextInt();
        Weapon bullet = null;
        switch(weapon) {
            case 1: bullet = new SmallBullet(x, y, angle);
                    break;
            case 2: bullet = new MediumBullet(x, y, angle);
                    break;
            default:System.out.println("Wrong weapon");
        };
        return bullet;
    }
    
    @Override
    public boolean shot(Weapon weapon, Soldiery shotter) {
        if (Math.abs(weapon.getX() - this.getX()) < (weapon.getRadius() + this.getRadius()) &&
                Math.abs(weapon.getY() - this.getY()) < (weapon.getRadius() + this.getRadius()) && this != shotter) {
            weapon.hitting(this);
            return true;
        }
        return false;
    }
}
