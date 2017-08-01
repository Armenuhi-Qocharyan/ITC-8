package balls;
import java.lang.*;

public class Ball {
    private int x;
    private int y;
    private int vx;
    private int vy;
    private int m;
    private int canvasX = 100;
    private int canvasY = 100;
    
    public Ball(int x, int y, int vx, int vy, int m) {
	this.x = x;
   	this.y = y;
   	this.vx = vx;
   	this.vy = vy;
     	this.m = m;
    }
    
    public int getX(int minute) {
        this.x += this.vx * minute;
	if (this.x > this.canvasX || this.x < 0) {
	    this.vx = -this.vx;
            this.vy = -this.vy;
 	}
	return this.x; 
    }
    
    public int getY(int minute) {
        this.y += this.vy * minute;
	return this.y;
    }
    
    private double getImpulse() {
	return this.m * getSpeed();
    }
    
    private double getSpeed() {
  	return Math.sqrt(this.vx * this.vx + this.vy * this.vy);
    }
    
    public boolean drag(Ball otherBall) {
	if (this.x == otherBall.getX(0) && this.y == otherBall.getY(0)) {
	    double impulse = getImpulse() - otherBall.getImpulse();
            this.vx = -this.vx;
            this.vy = -this.vy;
            otherBall.vx = -otherBall.vx;
            otherBall.vy = -otherBall.vy;
	    return true;
        }
        return false;
    }
    
}
