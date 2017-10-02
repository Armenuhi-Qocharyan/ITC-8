package com.itc.war_game;

import java.util.Scanner;

public abstract class Soldiery extends GameObjects {
    public String name;
    public String nationality;
    private int life;
    
    public Soldiery() {
        super(1, 1, 1, 1, 10);
        this.name  = "";
        this.nationality = "";
        this.life = 0;
    }
    
    public Soldiery(double x, double y, double angle, double speed, double radius, String name, int life) {
        super(x, y, angle, speed, radius);
        this.name = name;
        this.life = life;
    }
    
    public abstract Weapon takeWeapon();
    
    public void initialize (int radius) {
        System.out.print("Enter soldier coordinates:\nx = ");
        Scanner scan =  new Scanner(System.in);
        this.x = scan.nextInt();
        System.out.print("y = ");
        this.y = scan.nextInt();
        Scanner scanLine = new Scanner(System.in);
        System.out.print("Enter soldier name: ");
        this.name = scanLine.nextLine(); 
        System.out.print("Enter soldier nationality: ");
        this.nationality = scanLine.nextLine();
        System.out.print("Enter soldier life: ");
        this.life = scan.nextInt();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
