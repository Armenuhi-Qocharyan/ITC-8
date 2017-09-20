package war;
import java.util.ArrayList;

public class Weapon {
    private String name;
    private final Bullet bullet;
    private ArrayList<Bullet> bullets;
    private int curentBllCount;
    private final int maxBllCount;

    public Weapon(String n,  int maxBC, Bullet b) {
        name = n;
        bullet = b;
        curentBllCount = 0;
        maxBllCount = maxBC;
        bullets = new ArrayList<Bullet>();
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }
 
    public ArrayList<Bullet> getBullets() {
        return bullets;
    }   

    public void setBullets(int count) {
        Bullet b;
        for (int i = 0; i < count; ++i) {
            if (curentBllCount < maxBllCount) {
                    b = new Bullet(bullet.getCaliber(), bullet.getDamage());
                    bullets.add(b);
                    ++curentBllCount;
            } else {
                //console log max bullet counnt is
                break;
            }
        }
    }
    
    public void refill() {
        Bullet b;   
        bullets = new ArrayList<Bullet>(); 
        for (int i = 0; i < maxBllCount; ++i) {
            b = new Bullet(bullet.getCaliber(), bullet.getDamage());
            bullets.add(b);
        }
        curentBllCount = maxBllCount;
    }

    public Bullet shoot(float scoreVX, float scoreVY) {
        Bullet movingBll;
        if (curentBllCount != 0) {
            movingBll = bullets.get(bullets.size() - 1);
            movingBll.setScoreV(scoreVX, scoreVY);
            movingBll.move();
            bullets.remove(movingBll);
            --curentBllCount;
            return movingBll;
        } else {
            return null;
            //console log current bullet count is 0
        }
    }

}
