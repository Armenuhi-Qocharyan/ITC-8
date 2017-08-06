/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.instigatemobile.wargame;

import java.awt.Point;

/**
 * This class represents an Soldier object that exists on the game area
 *
 * All specific objects have the following common properties:
 * <pre>
 * - name
 * - health
 * - weapon
 * - team
 * - position (GameObject)
 * - velocity (GameObject)
 * - size (GameObject)
 * </pre>
 * 
 * @author smbat
 */
public class Soldier extends GameObject {
    private String name;
    private int health;
    private Weapon weapon;
    private String team;
    
    /**
     * 
     * @param name initial soldier name
     * @param health initial soldier health
     * @param weapon initial soldier weapon type
     * @param team initial soldier team or nation
     * @param position initial soldier coordinates in area
     * @param velocity initial soldier moving velocity
     * @param size initial soldier size (i.e. radius). Must be greater than 0.
     */
    
    public Soldier(String name, int health, Weapon weapon, String team, Point position, Point velocity, int size) {
        super(position, velocity, size);
        this.name = name;
        this.health = health;
        this.weapon = weapon;
        this.team = team;
    }
    /**
     * 
     * @return Solder name
     */
    public String getName() {
        return name;
    }
    
    /**
     * 
     * @return soldier remaining health
     */
    public int getHealth() {
        return health;
    }
    
    /**
     * 
     * @return soldier weapon
     */
    public Weapon getWeapon() {
        return weapon;
    }
    
    /**
     * 
     * @param weapon set new weapon
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * 
     * @return soldier team name
     */
    public String getTeam() {
        return team;
    }

    @Override
    public int getChildClassId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean realiseCollision(GameObject other) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
