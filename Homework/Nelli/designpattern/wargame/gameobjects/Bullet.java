package wargame.gameobjects;

import java.awt.Point;
import wargame.interfaces.Ammunitions;
import wargame.abstractclasses.GameObject;

/**
 *
 * @author nelliM
 */
public class Bullet extends GameObject implements Ammunitions{
   
    public Bullet(int strength, int radius, Point position, Point velocity) {
        super(strength, radius, position, velocity);
    }
    
    @Override
    public void vsSoldier(Soldier soldier) {
        soldier.setLife(soldier.getLife() - this.getStrength());
    }

    @Override
    public void move(int time) {
        int newX = this.getPosition().x + this.getVelocity().x * time;
        int newY = this.getPosition().y + this.getVelocity().y * time;
        this.getPosition().setLocation(newX, newY);
    }
}
