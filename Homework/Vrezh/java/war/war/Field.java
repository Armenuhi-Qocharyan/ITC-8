package war;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

public class Field {
    public final int width;
    public final int height;
    private final ArrayList<Soldier> soldiers;
    private final ArrayList<Bullet> bullets;
    //enum side { TOP, BOTTOM, LEFT, RIGHT, MIDDLE }; 
    
    public Field(int w, int h) {
        width = w;
        height = h;
        soldiers = new ArrayList<Soldier>();
        bullets = new ArrayList<Bullet>();
    }

    public void setSoldier(Soldier b) {
        soldiers.add(b);
    }

    public ArrayList<Soldier> getSoldiers() {
        return soldiers;
    }
    
    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }   
    
    public void shoot(int index, float scoreVX, float scoreVY) {
        bullets.add(soldiers.get(index).shoot(scoreVX, scoreVY));
        System.out.println(soldiers.get(index).getName() + " shoot ->");
        if (bullets.size() != 0) {
            controllBullet(soldiers.get(index));
        }
    }

    public void controllBullet(Soldier soldier) {
        while (bullets.get(0).isMoving()) {
            //for (Bullet bullet : bullets) {
            boolean isCll= isCollide(bullets.get(0), soldier);
            if (!isCll) {
                bullets.get(0).move();
            }

            if (bullets.size() == 0) { 
                break;
            }
        }
    }

    public boolean isCollide(Bullet bullet, Soldier shootSld) {
        for (Soldier soldier : soldiers) {
            if (soldier != shootSld) {
                if (bullet.getCoordX() - soldier.getCoordX() < Math.abs(soldier.getWidth()) && bullet.getCoordX() - soldier.getCoordX() < Math.abs(soldier.getWidth())) {
                    System.out.println("Bullet received " + soldier.getName() + " <-");
                    soldier.setLives(soldier.getLives() - bullet.getDamage());
                    if (soldier.getLives() <= 0) {
                        soldiers.remove(soldier);
                    }
                    bullets.remove(bullet);
                    bullet.setMoving(false);
                    return true;
                }
            }
        }
        return false;
    }

}

