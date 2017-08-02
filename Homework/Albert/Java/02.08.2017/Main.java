import war.*;

public class Main {
    public static void main(String[] args) {
        Bullet bulletFirst = new Bullet(0, 0, 100, 5); //coordX, coordY, bollet count, bullet size
        Weapon weaponFirst = new Weapon("pistol", 35, 500, 500, bulletFirst); //type, damage, diapason, speed, bulletObj
        Soldier soldierFirst = new Soldier("Jack", "us", 100, weaponFirst, 20); // name, nationality, life, weaponObj

    
        Bullet bulletSecond = new Bullet(500, 0, 100, 5); //coordX, coordY, bollet count
        Weapon weaponSecond = new Weapon("pistol", 35, 500, 500, bulletSecond); //type, damage, diapason, speed, bulletObj
        Soldier soldierSecond = new Soldier("Sim", "rus", 100, weaponSecond, 20); // name, nationality, life, weaponObj

        soldierFirst.printSoldierInfo();     
        System.out.println("\n-------------------------------------------\n");
        soldierSecond.printSoldierInfo();     
        System.out.println("\n-------------------------------------------\n");

        soldierFirst.fire(soldierSecond, 90); 

        soldierFirst.printSoldierInfo();      
        System.out.println("\n-------------------------------------------\n");
        soldierSecond.printSoldierInfo();     
        System.out.println("\n-------------------------------------------\n");
    }


}
