package visitorpattern;

public abstract class Weapon extends GameObject {
    private double letality;

    public Weapon(String name, double x, double y, double velocityX, double velocityY, double letality) {
        super(name, x, y, velocityX, velocityY);
        this.letality = letality;
        Field.getInstance().addObservable(this);
    }

    public double getLetality() {
        return letality;
    }

    public void setLetality(double damage) {
        this.letality = damage;
    }
    
    @Override
    public void notifyCollision(GameObject other) {
        if (other instanceof Soldier) {
            this.damage((Soldier) other);
            Field.getInstance().removeObservable(this);
        } else if (other instanceof Tank) {
            this.damage((Tank) other);
            Field.getInstance().removeObservable(this);
        }
    }
    
    public abstract void damage(Soldier soldier);
    public abstract void damage(Tank tank);
}
