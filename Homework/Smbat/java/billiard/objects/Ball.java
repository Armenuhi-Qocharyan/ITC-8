// This Class impliments object Ball

package objects; 

public class Ball {
    private double x;   //  coordinate X
    private double y;   //  coordinate Y
    private double vx;  //  Speed Y
    private double vy;  //  Speed Y
    private double m;   //  Weight
    private double r;   //  Radius

//-------------------------- Constructors----------------------
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

//------------------ Getters -------------------------
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public double getR() {
        return r;
    }
    public double getVx() {
        return vx;
    }
    public double getVy() {
        return vy;
    }

//----------------------------Seters---------------------------
    public void setV(double vx, double vy) {
        this.vx = vx;
        this.vy = vy;
    }

//---------------------------Calculate coordinates from spendTime-----------------
    public void move (double spendTime) {
        x += vx * spendTime;
        y += vy * spendTime;
        
    }

//-----------------------------Print Ball Parameters----------------------------------
    public void print() {
        System.out.println ("x = " + x + "  y = " + y + "  vx = " + vx + "  vy = " + vy);
    }
}
