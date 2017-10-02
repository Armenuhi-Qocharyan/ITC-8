/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wargame;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author liana
 */
class Projectile extends GameObject implements Weapon {
    int range;
    
    public Projectile(int range, Point position, Point velocity, int size) {
        super(position, velocity, size);
        this.range = range;
    }


    @Override
    public void checkCollision(ArrayList<GameObject> objects, int time) {
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
        System.out.println("Soldier explodes with projectile");
        objects.remove(soldier);
        objects.remove(this);
    }

    @Override
    public void visit(Bullet bullet, ArrayList<GameObject> objects) {
        System.out.println("Collision between bullet and projectile");
        objects.remove(bullet);
    }

    @Override
    public void visit(Projectile projectile, ArrayList<GameObject> objects) {
        System.out.println("Booom..collision between two projectiles");
        objects.remove(this);
        objects.remove(projectile);
         
    }

    @Override
    public void accept(Weapon weapon, ArrayList<GameObject> objects) {
        weapon.visit(this, objects);
    }

    
}
