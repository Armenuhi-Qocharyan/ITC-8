package wargame;

import java.awt.Point;
import java.util.ArrayList;

/**
 * This class represents an object that exists on the game area.
 *
 * All specific objects have the following common properties:
 * <pre>
 * - position
 * - velocity
 * - size
 * </pre>
 *
 */
public abstract class GameObject {

    private Point position;
    private Point velocity;
    private int size;

    /**
     * Creates a GameObject with specified parameters
     *
     * @param position initial object position (can not be null)
     * @param velocity initial object velocity (can not be null)
     * @param size object size (i.e. radius). Must be greater than 0.
     */
    public GameObject(Point position,
            Point velocity,
            int size) {
        this.position = position;
        this.velocity = velocity;
        this.size = size;
    }

    /**
     *
     * @return Current object position
     */
    public Point getPosition() {
        return this.position;
    }

    /**
     *
     * @return Current object velocity
     */
    public Point getVelocity() {
        return this.velocity;
    }

    /**
     *
     * @return Object size
     */
    public int getSize() {
        return this.size;
    }

    /**
     *
     * @param velocity new velocity to be set
     */
    public void setVelocity(Point velocity) {
        this.velocity = velocity;
    }
    
    public void setPosition (Point position) {
        this.position = position;
    }

    /**
     * Move the object based on its current position and velocity.
     *
     * @param time time (in seconds) during which the object is moved.
     */
    public void move(int time) {
        position.x += velocity.x * time;
        position.y += velocity.y * time;
    }

    /**
     * Check if object collides with other objects
     *
     * @param objects all active objects from war area
     * @param time 
     */
    public abstract void checkCollision(ArrayList<GameObject> objects, int time);


    public abstract void accept(Weapon weapon, ArrayList<GameObject> objects);
}
