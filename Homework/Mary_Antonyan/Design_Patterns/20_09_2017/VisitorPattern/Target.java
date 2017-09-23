package visitorpattern;

public abstract class Target extends GameObject {
    private double health;

    public Target(String name, double x, double y, double velocityX, double velocityY, double health) {
        super(name, x, y, velocityX, velocityY);
        this.health = health;
        Field.getInstance().addObservable(this);
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }
    
    public void checkHealth() {
        if (this.getHealth() <= 0) {
            System.out.println("Target is dead in x: " + this.getX() + " y: " + this.getY());
            Field.getInstance().removeObservable(this);
        } else {
            System.out.println("Collision\nTarget health: " + this.health);
        }
    }
    
    @Override
    public void notifyCollision(GameObject other) {
        //pass
    }
    
    public abstract void accept(Bullet bullet);
    public abstract void accept(Grenade grenade);
}
