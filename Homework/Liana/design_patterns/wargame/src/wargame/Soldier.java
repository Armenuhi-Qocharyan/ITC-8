package wargame;

import java.awt.Point;
import java.util.ArrayList;

/**
 *This class specifies fighting soldiers
 * All soldiers have following fields:
 * <p>-health
 * <p>-energy
 *
 */
public class Soldier extends GameObject {
    private int health;
    private int energy;

    /**
     *
     * @param health
     * @param energy
     * @param position
     * @param velocity
     * @param size
     */
    public Soldier(int health, int energy, Point position, Point velocity, int size) {
        super(position, velocity, size);
        this.health = health;
        this.energy = energy;
    }

   @Override
   public void checkCollision (ArrayList<GameObject> objects, int time) {
        double sizeDistance;
        double pointsDistance;

        for (int i = 0; i < objects.size(); ++i) {
            GameObject object = objects.get(i);
            sizeDistance = this.getSize() + object.getSize();
            pointsDistance = this.getPosition().distance(object.getPosition());

            if (pointsDistance < sizeDistance && this != object) {
                this.accept((Weapon) object, objects);
            } else {
               if (0 >= energy) {
                   this.loseHealth(1);
                   if (this.killed()) {
                       objects.remove(this);
                   }
               } else {
                   energy--;
               }
            }
        }
    }

    /**
     *
     * @param attack health decreases according to attack value 
     */
    public void loseHealth(int attack) {
        this.health -= attack;
    }

    /**
     *
     * @return true when soldier killed
     */
    public boolean killed () {
        return 0 >= this.health;
    }
    
    @Override
    public void accept(Weapon weapon, ArrayList<GameObject> objects) {
        weapon.visit(this, objects);
    }
    
}
