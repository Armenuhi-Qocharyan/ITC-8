package war;
import java.util.concurrent.TimeUnit;
import java.lang.InterruptedException;

public class Bullet extends Moving implements Visitor { 
    private int damage;//uron
    private float caliber;

    public Bullet(float c, int d) {
        super();
        caliber = c;
        damage = d;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void visit(Soldier soldier) {
        System.out.println("Bullet received " + soldier.getName() + " <-");
        soldier.setLives(soldier.getLives() - damage);
    } 

    @Override
    public void visit(Tank tank) {
        System.out.println("Bullet received " + tank.getName()  + " <-");
        tank.setLives(tank.getLives() - damage);
    }

    @Override
    public void visit(Bullet bullet) {
        // bullets callide
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
