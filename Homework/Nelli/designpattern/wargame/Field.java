/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wargame;

import java.awt.Point;
import java.util.ArrayList;
import wargame.abstractclasses.GameObject;
import wargame.gameobjects.Soldier;
import wargame.interfaces.Ammunitions;
import wargame.interfaces.Militaries;

/**
 *
 * @author nelliM
 */
public class Field {
    private int height;
    private int width;
    private ArrayList<GameObject> gameObjects;

    public Field(int height, int width) {
        this.height = height;
        this.width = width;
        this.gameObjects = new ArrayList();
    }
    

    public void startGame() {
        while (gameObjects.size() > 1) {
            moveAllObjects();
        }
    }
    
    public void moveAllObjects() {
        for (GameObject object: gameObjects) {
            object.move(1);
            if (object.getPosition().y >= this.height || object.getPosition().x >= this.width) {
                changeObjectDirection(object);
            }
            for (GameObject other: gameObjects) {
                if ((!object.equals(other)) && object.collide(other)) {
                    if (object instanceof Militaries && other instanceof Ammunitions) {
                        ((Militaries) object).accept((Ammunitions) other);
                        System.out.println("Boom");
                     
                        changeObjectDirection(object);
                        changeObjectDirection(other);
                        //removeObject(other);
                    } else {
                        if (other instanceof Militaries && object instanceof Ammunitions) {
                            ((Militaries) other).accept((Ammunitions) object);
                            // removeObject(object);
                        }
                    }
                }
            }
        }
    }
    
    public void addObject(GameObject newObject) {
        this.gameObjects.add(newObject);
    }
    
    public boolean removeObject(GameObject object) {
        if (this.gameObjects.indexOf(object) > -1) {
            this.gameObjects.remove(object);
            return true;
        }
        return false;
    }
    
    private void changeObjectDirection(GameObject object) {
        Point newVelocity = new Point(0 - object.getVelocity().x, 0 - object.getVelocity().y);
        object.setVelocity(newVelocity);
    }
    
}
