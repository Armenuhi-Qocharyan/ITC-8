import war.Field;
import war.Soldier;
import war.Weapon;
import war.Bullet;
import java.util.ArrayList;

public class Main {
    public static void createSoldiers(Field field) {
        Soldier soldier;
        Weapon weapon;
        Bullet bullet;
        for (int i = 0; i < 4; ++i) {
            bullet = new Bullet(15, 1);// caliber, damage(uron)
            weapon = new Weapon("AK-47", 30, bullet);// name, max bullet count, bullet
            weapon.setBullets(30);
            soldier = new Soldier("Soldier" + i, 10, "ARM", weapon, 1, 1);// name, lives, nationality, weapon, width, height
            soldier.setCoords(2 * i, 5);// soldier coordinates
            Bullet bllSh = soldier.shoot(2*i, 2*i);
            field.setObject(bllSh);
            field.setObject(soldier);
        }
    }   

    public static void main(String[] args) {
        Field field = new Field(200, 200);
        createSoldiers(field);// initialization field soldiers
        field.startGame(10000);// time game
    }
}

