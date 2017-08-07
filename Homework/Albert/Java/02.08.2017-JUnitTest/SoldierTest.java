import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SoldierTest {
    private Bullet bullet;
    private Weapon weapon;
    private Soldier soldier;

/*
    @BeforeClass
    public void init() {
        bullet = new Bullet(10, 1);
        weapon = new Weapon("pistol", 35, 500, 500, bullet); // type, damage, diapason, speed
        soldier = new Soldier("Jack", "us", 100, weapon, 0, 0, 20);// name, nationality, life, x, y, size
    }
*/
    @Test
    public void getNameTest() {
        System.out.println("SoldierTest getNameTest() runned");
        bullet = new Bullet(10,1);
        weapon = new Weapon("pistol", 35, 500, 500, bullet); // type, damage, diapason, speed
        soldier = new Soldier("Jack", "us", 100, weapon, 0, 0, 20);// name, nationality, life, x, y, size
        assertEquals("Jack", soldier.getName());
    }

    @Test
    public void getNationTest() {
        System.out.println("SoldierTest getNatiionTest() runned");
        bullet = new Bullet(10,1);
        weapon = new Weapon("pistol", 35, 500, 500, bullet); // type, damage, diapason, speed
        soldier = new Soldier("Jack", "us", 100, weapon, 0, 0, 20);// name, nationality, life, x, y, size
        assertEquals("us", soldier.getNation());
    }

    @Test
    public void getLifeTest() {
        System.out.println("SoldierTest getLifeTest() runned");
        bullet = new Bullet(10,1);
        weapon = new Weapon("pistol", 35, 500, 500, bullet); // type, damage, diapason, speed
        soldier = new Soldier("Jack", "us", 100, weapon, 0, 0, 20);// name, nationality, life, x, y, size
        assertEquals(100, soldier.getLife());
    }

    @Test
    public void getXTest() {
        System.out.println("SoldierTest getXTest() runned");
        bullet = new Bullet(10,1);
        weapon = new Weapon("pistol", 35, 500, 500, bullet); // type, damage, diapason, speed
        soldier = new Soldier("Jack", "us", 100, weapon, 0, 0, 20);// name, nationality, life, x, y, size
        assertEquals(0, soldier.getX());
    }

    @Test
    public void getYTest() {
        System.out.println("SoldierTest getYTest() runned");
        bullet = new Bullet(10,1);
        weapon = new Weapon("pistol", 35, 500, 500, bullet); // type, damage, diapason, speed
        soldier = new Soldier("Jack", "us", 100, weapon, 0, 0, 20);// name, nationality, life, x, y, size
        assertEquals(0, soldier.getY());
    }

    @Test
    public void getSizeTest() {
        System.out.println("SoldierTest getSizeTest() runned");
        bullet = new Bullet(10,1);
        weapon = new Weapon("pistol", 35, 500, 500, bullet); // type, damage, diapason, speed
        soldier = new Soldier("Jack", "us", 100, weapon, 0, 0, 20);// name, nationality, life, x, y, size
        assertEquals(20, soldier.getSize());
    }

    @Test
    public void fireTest() {
        System.out.println("SoldierTest fireTest() runned");
        bullet = new Bullet(10,1);
        weapon = new Weapon("pistol", 35, 500, 500, bullet); // type, damage, diapason, speed
        soldier = new Soldier("Jack", "us", 100, weapon, 0, 0, 20);// name, nationality, life, x, y, size
        Soldier soldierSecond = new Soldier("Tom", "eng", 100, weapon, 200, 200, 20);// name, nationality, life, x, y, size
        assertEquals(true, soldier.fire(soldierSecond, 45));
    }
}

