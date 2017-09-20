package Balls;
import java.lang.Math;
import java.util.ArrayList;

public class Ball {
    private int x;
    private int y;
    private int r;
    private int v;
    private int angle;
    private ArrayList<BallsCollisionObserver> observer;

    public Ball(int x, int y, int r, int v, int angle) {
        this.setX(x);
        this.setY(y);
        this.r = r;
        this.v = v;
        this.angle = angle;
        this.observer = new ArrayList<BallsCollisionObserver>();
    }
    
    public void addObserver(BallsCollisionObserver object) {
        observer.add(object);
    }

    public void removeObserver(BallsCollisionObserver object) {
        observer.remove(object);
    }

    public int getX() {
        return this.x;
    }
    public void setX(int x) {
        if (0 <= x && 500 >= x) {
            this.x = x;
        } else {
            this.x = 250;
        }
    }

    public int getY() {
        return this.y;
    }
    public void setY(int y) {
        if (0 <= y && 500 >= y) {
            this.y = y;
        } else {
            this.y = 250;
        }
    }

    public int getR() {
        return this.r;
    }
    public void setR(int r) {
        this.r = r;
    }
    public void move(int i) {
        this.x += this.v * Math.sin(Math.toRadians(this.angle));
        this.y += this.v * Math.sin(Math.toRadians(90 - this.angle));
        this.printCoord(i+1);            
    }

     public double getDistance(Ball ball) { 
        return Math.sqrt((this.x - ball.x) * (this.x - ball.x) + (this.y - ball.y) * (this.x - ball.x));
    }

    public void checkCollisionTwoBalls(Ball ball) {
        if (this.getDistance(ball) <= this.getR() + ball.getR()) {
            for (BallsCollisionObserver obs : observer) {
                obs.notifyBallsCollision();
            }
        }
    }
    public boolean checkCollisionBound(Ball ball) {
        return this.getDistance(ball) <= this.getR() + ball.getR();
    }
    public void printCoord(int i) {
        System.out.println("     Ball-" + i + "     ");
        System.out.print("x: " + this.x);
        System.out.print("   y: " + this.y);
        System.out.println("   r: " + this.r);
        System.out.println("------------------------");
    }
}
