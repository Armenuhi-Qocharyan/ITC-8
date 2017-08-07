import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BulletTest {
    private Bullet bullet;
/*
    @BeforeClass
    public void init() {
        bullet = new Bullet(10, 1);
    }
*/
    @Test
    public void getCountTest() {
        System.out.println("BulletTest getCountTest() runned");
        bullet = new Bullet(10,1);
        assertEquals(10, bullet.getCount());
    }
    @Test
    public void getSizeTest() {
        System.out.println("BulletTest getSizeTest() runned");
        bullet = new Bullet(10,1);
        assertEquals(1, bullet.getSize());
    }
}
