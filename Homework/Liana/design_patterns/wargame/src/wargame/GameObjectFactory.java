/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wargame;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author liana
 */
public class GameObjectFactory {
    private static Random random = new Random();
    private static ArrayList<GameObject> objects= new ArrayList<GameObject>() {
        {
            add(new Soldier(50, 100, new Point(0, 0), new Point(random.nextInt(3) + 1, random.nextInt(3) + 1), 10));
            add(new Bullet (10, 5, new Point(0, 0), new Point(random.nextInt(8) + 1, random.nextInt(6) + 1), 4));
            add(new Projectile (100, new Point(0, 0), new Point(random.nextInt(5) + 1, random.nextInt(4) + 1), 10));
        }
    };
    
    /**
     *
     * @param x
     * @param y
     * @returns random instance if GameObject 
     */
    public static GameObject getInstance (int x, int y) {
        GameObject object = objects.get(random.nextInt(3));
        object.getPosition().x = x;
        object.getPosition().y = y;
        return object;
    }
    
}
