package war;
import java.util.concurrent.TimeUnit;
import java.lang.InterruptedException;

public class Bullet extends Moving { 
    private int damage;//uron
    private float caliber;

    public Bullet(float c, int d) {
        caliber = c;
        damage = d;
    }
    
    public void setCaliber(float c) {
        caliber = c;
    }

    public float getCaliber() {
        return caliber;
    }

    public void setDamage(int d) {
        damage = d;
    }

    public int getDamage() {
        return damage;
    }

}
