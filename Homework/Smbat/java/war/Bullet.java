public class Bullet {
    private double power;
    private double radius;
    private double x;
    private double y;
    private double vx;
    private double vy;
    
    public Bullet(double power, double radius, double vx, double vy) {
        this.power = power;
        this.radius = radius;
        this.vx = vx;
        this.vy = vy;
    }

    public void move(double spendTime) {
        x += vx * spendTime;
        y += vy * spendTime;
    }

    public double getPower() {
        return power;
    }
    public double getRadius() {
        return radius;
    }
    public double getVx() {
        return vx;
    }
    public double getVy() {
        return vy;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
     public void setVx(double vx) {
        this.vx = vx;
    }
    public void setVy(double vy) {
        this.vy = vy;
    }
}