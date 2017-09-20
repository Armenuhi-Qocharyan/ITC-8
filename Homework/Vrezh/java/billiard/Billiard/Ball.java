package Billiard;
import java.util.concurrent.TimeUnit;
import java.lang.InterruptedException;
import java.lang.Math;

public class Ball {
    private float radius;
    private float weight;
    private float coordX;
    private float coordY;
    private float vectorX;
    private float vectorY;     
    private Table table;

    public Ball(float r, float w, float cX, float cY, float vX, float vY) {
        radius = r;
        weight = w;
        coordX = cX;
        coordY = cY;
        vectorX = vX;
        vectorY = vY;
        table = Table.getInstance(0, 0);
    }
    
    public void setRadius(float r) {
        radius = r;
    }

    public float getRadius() {
        return radius;
    }
     
    public void setWeight(float w) {
        weight = w;
    }

    public float getWeight() {
        return weight;
    }
 
    public void setCoords(float x, float y) {
        coordX = x;
        coordY = y;
    }

    public float getCoordX() {
        return coordX;
    }

    public float getCoordY() {
        return coordY;
    }
    
    public void setVector(float x, float y) {
        if (0 == x && 0 == y) {
            table.removeObserver(this);
        } else if (0 == vectorX && 0 == vectorY) {
            table.addObserver(this);
        }

        vectorX = x;
        vectorY = y;
    }

    public float getVectorX() {
        return vectorX;
    }

    public float getVectorY() {
        return vectorY;
    }

    public void isCollideWhitBallChageVectors(Ball ball) {
        if ( ball != this && Math.abs(ball.getCoordX() - coordX) <= ball.getRadius() + radius && Math.abs(ball.getCoordY() - coordY) <= ball.getRadius() + radius ) {
    setVector(-vectorX, -vectorY);
    System.out.println("Collide with ball ... ");
}

    }

    public void isCollideWithBoudChangeVectors() {
        if (coordX <= radius || coordX >= (table.getWidth() - radius)) {
            System.out.println("Collide with board ... ");
            vectorX = -vectorX;
        }
        if(coordY <= radius || coordY >= (table.getHeight() - radius)) {
            System.out.println("Collide with board ... ");
            vectorY = -vectorY;
        }
    }
 
    public void move() {
        setCoords(coordX + vectorX*1, coordY + vectorY*1);
        System.out.print(coordX );
        System.out.print("   ");
        System.out.println(coordY);
 
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException err) {
            System.out.print(err);
        }

    }
 
}
