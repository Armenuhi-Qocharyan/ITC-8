package Balls;
import java.lang.Math;

public class Ball {
    private int x;
    private int y;
    private int r;
    private int v;
    private int angle;

    public Ball(int x, int y, int r, int v, int angle) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.v = v;
        this.angle = angle;
    }
    
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    public void move() {
        this.x += this.v * Math.sin(Math.toRadians(this.angle));
        this.y += this.v * Math.sin(Math.toRadians(90 - this.angle));
    }

     public boolean ballCollision(Ball ball) { 
        return (Math.sqrt((this.x - ball.x) * (this.x - ball.x) + (this.y - ball.y) * (this.x - ball.x)) <= this.r + ball.r);
    }
}
