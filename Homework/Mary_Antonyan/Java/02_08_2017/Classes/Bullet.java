package Classes;

public class Bullet {
    // Members
    private int radius;
    private int vx;
    private int vy;

    // Constructor
    public Bullet(int radius, int vx, int vy) {
        setRadius(radius);
        this.vx = vx;
        this.vy = vy;
    }

    // Copy constructor
    public Bullet(Bullet other) {
        this.radius = other.radius;
        this.vx = other.vx;
        this.vy = other.vy;
    }

    // Methods
    public void setRadius(int radius) {
        this.radius = (radius > 1) ? radius : 1;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    public int getVx() {
        return vx;
    }

    public int getVy() {
        return vy;
    }
}
