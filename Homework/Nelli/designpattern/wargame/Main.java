package wargame;

import java.awt.Point;
import wargame.gameobjects.Bullet;
import wargame.gameobjects.Soldier;

public class Main {

    public static void main(String[] args) {
        Field field = new Field(1000,1000);
        Soldier soldier = new Soldier(2, 20, new Point(50,50), new Point(10,10), 100);
        Bullet bullet = new Bullet(10, 2, new Point(0,0), new Point(10,10)); 
        field.addObject(soldier);
        field.addObject(bullet);
        field.startGame();
    }
    
}
