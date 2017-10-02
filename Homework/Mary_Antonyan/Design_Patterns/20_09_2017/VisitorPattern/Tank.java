package visitorpattern;

public class Tank extends Target {

    public Tank(String name, double x, double y, double velocityX, double velocityY, double health) {
        super(name, x, y, velocityX, velocityY, health);
    }

    @Override
    public void accept(Bullet bullet) {
        //pass
    }

    @Override
    public void accept(Grenade grenade) {
        this.setHealth(this.getHealth() - grenade.getLetality());
    }
}
