import war.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Bullet bulletFirst = new Bullet(20, 1); //bullet count, bullet size
        Weapon weaponFirst = new Weapon("pistol", 35, 500, 500, bulletFirst); //type, damage, diapason, speed, bulletObj
        Soldier soldierFirst = new Soldier("Jack", "us", 100, weaponFirst, 0, 0, 25); // name, nationality, life, weaponObj, x, y, size

    
        Bullet bulletSecond = new Bullet(20, 1); //bullet count, bullet size
        Weapon weaponSecond = new Weapon("pistol", 35, 500, 500, bulletSecond); //type, damage, diapason, speed, bulletObj
        Soldier soldierSecond = new Soldier("Sim", "rus", 100, weaponSecond, 200, 200, 25); // name, nationality, life, weaponObj, x, y, size
        
        BattleField battleField = new BattleField();
        battleField.setSoldier(soldierFirst);
        battleField.setSoldier(soldierFirst);
        
        soldierFirst.fire(soldierSecond, 45); 

        soldierFirst.printSoldierInfo();      
        soldierSecond.printSoldierInfo();     
    }
/*
    public static Bullet createBullet(int count, int size) {
        if (count >= 0 && size >= 1) {
            return (new Bullet(count, size)); //bullet count, bullet size
        }
        return null;
    }
    public static Weapon createWeapon(String type, int damage, int diapason, int speed, Bullet bullet) {
        if ((type == "pistol" || type == "sniper") && damage >= 1 && diapason >= 300 && speed >= 100) {
            return (new Weapon(type, damage, diapason, speed, bullet)); //type, damage, diapason, speed, bullet obj
        }
        return null;
    }

    public static Soldier createSoldiers(String name, String nation, int life, int x, int y, int size, Weapon weapon) {
        if (life > 0 && size > 15) {
            return (new Soldier(name, nation, life, weapon, x, y, size)); // name, nationality, life, weaponObj
        }
        return null;
    }
*/
}
