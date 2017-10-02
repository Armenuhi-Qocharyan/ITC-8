package visitorpattern;

import static java.lang.Math.abs;

public abstract class GameObject {
    private final String name;
    private double x;
    private double y;
    private double velocityX;
    private double velocityY;

    public GameObject(String name, double x, double y, double velocityX, double velocityY) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }
    
    public void move() {
        this.x += this.velocityX;
        this.y += this.velocityY;
        if (abs(this.x) >= Field.getInstance().getWidth()) {
            this.velocityX = -this.velocityX;
        }
        if (abs(this.y) >- Field.getInstance().getHeight()) {
            this.velocityY = -this.velocityY;
        }
        System.out.println(this.name + "\tx: " + this.x + "\ty: " + this.y);
    }
    
    public abstract void notifyCollision(GameObject other);
}
