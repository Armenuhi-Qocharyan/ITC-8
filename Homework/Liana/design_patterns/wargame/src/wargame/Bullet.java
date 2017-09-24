package wargame;

import java.awt.Point;
import java.util.ArrayList;

/**
 * This class specifies bullets, which will be used during war.
 *
 * All bullets have following properties:
 * <p>
 * -range
 * <p>
 * -attack
 *
 */
public class Bullet extends GameObject implements Weapon {

    private int range;
    private int attack;

    /**
     * Creates a bullet with specified parameters
     *
     * @param range
     * @param attack
     * @param position
     * @param velocity
     * @param size
     */
    public Bullet(int range, int attack, Point position, Point velocity, int size) {
        super(position, velocity, size);
        this.range = range;
        this.attack = attack;
    }


    /**
     *
     * @return bullet range
     */
    public int getRange() {
        return range;
    }

    /**
     *
     * @return bullet attack
     */
    public int getAttack() {
        return attack;
    }

    /**
     *
     * @param objects
     * @param time
     */
    @Override
    public void checkCollision (ArrayList<GameObject> objects, int time) {
        double sizeDistance;
        double pointsDistance;        
        
        for (int i = 0; i < objects.size(); ++i) {
            GameObject object = objects.get(i);
            sizeDistance = this.getSize() + object.getSize();
            pointsDistance = this.getPosition().distance(object.getPosition());
            if (pointsDistance < sizeDistance) {
                object.accept(this, objects);
            } else {
                double move;
                move = Math.sqrt(Math.pow(this.getVelocity().x, 2) + Math.pow(this.getVelocity().y, 2));
                this.range -= move * time;
                if (0 >= this.range) {
                    objects.remove(this);
                }
            }
        }

    }

    @Override
    public void visit(Soldier soldier, ArrayList<GameObject> objects) {
        soldier.loseHealth(this.attack);
        System.out.println("Bullet hurts soldier");
        if (soldier.killed()) {
            System.out.println("Soldier killed");
            objects.remove(soldier);
        }
        objects.remove(this);
    }

    @Override
    public void visit(Bullet bullet, ArrayList<GameObject> objects) {
        System.out.println("Collision between bullets");
        objects.remove(this);
        objects.remove(bullet);
    }

    @Override
    public void visit(Projectile projectile, ArrayList<GameObject> objects) {
        System.out.println("Collision between bullet and projectile");
        objects.remove(this);
    }


    @Override
    public void accept(Weapon weapon, ArrayList<GameObject> objects) {
        weapon.visit(this, objects);
    }
    
}
