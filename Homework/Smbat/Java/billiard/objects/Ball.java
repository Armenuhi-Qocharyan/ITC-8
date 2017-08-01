
package objects; 

public class Ball {
    private double x;
    private double y;
    private double vx;
    private double vy;
    private double m;
    private double r;

    public Ball(double x, double y, double m, double r) {
        this.x = x;
        this.y = y;
        this.m = m;
        this.r = r;
        this.vx = 0;
        this.vy = 0;
    }
    
    public Ball(double x, double y, double m, double r, double vx, double vy) {
        this.x = x;
        this.y = y;
        this.m = m;
        this.r = r;
        this.vx = vx;
        this.vy = vy;
    }

    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public double getR() {
        return r;
    }

    public void move (double spendTime) {
        x += vx * spendTime;
        y += vy * spendTime;
        
    }

    public void print() {
        System.out.println ("x = " + x + "  y = " + y + "  vx = " + vx + "  vy = " + vy);
    }
}
