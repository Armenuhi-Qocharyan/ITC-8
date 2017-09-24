/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wargame;

import java.util.ArrayList;

public interface Weapon {
    public void visit(Soldier soldier, ArrayList<GameObject> objects);
    public void visit(Bullet bullet, ArrayList<GameObject> objects);
    public void visit(Projectile projectile, ArrayList<GameObject> objects);
}
