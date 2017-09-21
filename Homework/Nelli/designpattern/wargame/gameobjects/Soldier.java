package wargame.gameobjects;

import java.awt.Point;
import wargame.interfaces.Ammunitions;
import wargame.abstractclasses.GameObject;
import wargame.interfaces.Militaries;


public class Soldier extends GameObject implements Militaries {

    private int life;
    
    public Soldier(int strength, int radius, Point position, Point velocity, int life) {
        super(strength, radius, position, velocity);
        this.life = life;
    }

    @Override
    public void move(int time) {
        int newX = this.getPosition().x + this.getVelocity().x * time;
        int newY = this.getPosition().y + this.getVelocity().y * time;
        this.getPosition().setLocation(newX, newY);
    }

    @Override
    public void accept(Ammunitions amm) {
        amm.vsSoldier(this);
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getLife() {
        return life;
    }
}
