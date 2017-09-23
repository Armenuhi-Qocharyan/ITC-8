package visitorpattern;

public class Soldier extends Target {

    public Soldier(String name, double x, double y, double velocityX, double velocityY, double health) {
        super(name, x, y, velocityX, velocityY, health);
    }

    @Override
    public void accept(Bullet bullet) {
        this.setHealth(this.getHealth() - bullet.getLetality());
        checkHealth();
    }

    @Override
    public void accept(Grenade grenade) {
        this.setHealth(0);
    }
}
