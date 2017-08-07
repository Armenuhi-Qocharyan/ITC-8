import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class WeaponTest {
    private Bullet bullet;
    private Weapon weapon;
/*    
    @BeforeClass
    public void init() {
        bullet = new Bullet(10, 1);
        weapon = new Weapon("pistol", 35, 500, 500, bullet); // type, damage, diapason, speed
    }
*/
    @Test
    public void getTypeTest() {
        System.out.println("WeaponTest getTypeTest() runned");
        bullet = new Bullet(10,1);
        weapon = new Weapon("pistol", 35, 500, 500, bullet); // type, damage, diapason, speed
        assertEquals("pistol", weapon.getType());
    }
    
    @Test
    public void getDamageTest() {
        System.out.println("WeaponTest getDamageTest() runned");
        bullet = new Bullet(10,1);
        weapon = new Weapon("pistol", 35, 500, 500, bullet); // type, damage, diapason, speed
        assertEquals(35, weapon.getDamage());
    }

    @Test
    public void getDiapasonTest() {
        System.out.println("WeaponTest getDiapasonTest() runned");
        bullet = new Bullet(10,1);
        weapon = new Weapon("pistol", 35, 500, 500, bullet); // type, damage, diapason, speed
        assertEquals(500, weapon.getDiapason());
    }

    @Test
    public void getSpeedTest() {
        System.out.println("WeaponTest getSpeedTest() runned");
        bullet = new Bullet(10,1);
        weapon = new Weapon("pistol", 35, 500, 500, bullet); // type, damage, diapason, speed
        assertEquals(500, weapon.getSpeed());
    }
}

