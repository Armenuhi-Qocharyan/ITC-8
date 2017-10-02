package Balls;
import java.lang.Math;
import java.util.ArrayList;

public class Ball implements BallInterface {
    private int x;
    private int y;
    private int r;
    private int v;
    private int angle;
    private float weight;
    private ArrayList<BallsCollisionObserver> observer;

    public Ball(int x, int y, int r, int v, int angle) {
        this.setX(x);
        this.setY(y);
        this.r = r;
        this.v = v;
        this.angle = angle;
        this.weight = 1;
        this.observer = new ArrayList<BallsCollisionObserver>();
    }
    
    @Override
    public void addObserver(BallsCollisionObserver object) {
        observer.add(object);
    }

    @Override
    public void removeObserver(BallsCollisionObserver object) {
        observer.remove(object);
    }

    @Override
    public int getX() {
        return this.x;
    }
    @Override
    public void setX(int x) {
        if (0 <= x && 500 >= x) {
            this.x = x;
        } else {
            this.x = 250;
        }
    }

    @Override
    public int getY() {
        return this.y;
    }
    @Override
    public void setY(int y) {
        if (0 <= y && 500 >= y) {
            this.y = y;
        } else {
            this.y = 250;
        }
    }

    @Override
    public int getR() {
        return this.r;
    }
    @Override
    public void setR(int r) {
        this.r = r;
    }
    @Override
    public float getWeight() {
        return this.weight;
    }
    @Override
    public void setWeight(float w) {
        this.weight = w;
    }
    @Override
    public void move(int i) {
        this.x += (this.v / this.weight) * Math.sin(Math.toRadians(this.angle));
        this.y += (this.v / this.weight) * Math.sin(Math.toRadians(90 - this.angle));
        this.printCoord(i+1);            
    }

    @Override
     public double getDistance(BallInterface ball) { 
        return Math.sqrt((this.x - ball.getX()) * (this.x - ball.getX()) + (this.y - ball.getY()) * (this.x - ball.getY()));
    }

    @Override
    public void checkCollisionTwoBalls(BallInterface ball) {
        if (this.getDistance(ball) <= this.getR() + ball.getR()) {
            for (BallsCollisionObserver obs : observer) {
                obs.notifyBallsCollision();
            }
        }
    }
/*
    @Override
    public boolean checkCollisionBound(BallInterface ball) {
    }
*/
    @Override
    public void printCoord(int i) {
        System.out.println("     Ball-" + i + "     ");
        System.out.print("x: " + this.x);
        System.out.print("   y: " + this.y);
        System.out.println("   r: " + this.r);
        System.out.println("------------------------");
    }
}
