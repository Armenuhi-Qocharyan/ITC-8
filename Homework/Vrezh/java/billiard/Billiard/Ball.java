package Billiard;
import java.util.concurrent.TimeUnit;
import java.lang.InterruptedException;
public class Ball {
    private float radius;
    private float weight;
    private float coordX;
    private float coordY;
    private float vectorX;
    private float vectorY;     

    public Ball(float r, float w, float cX, float cY, float vX, float vY) {
        radius = r;
        weight = w;
        coordX = cX;
        coordY = cY;
        vectorX = vX;
        vectorY = vY;
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
        vectorX = x;
        vectorY = y;
    }

    public float getVectorX() {
        return vectorX;
    }

    public float getVectorY() {
        return vectorY;
    }
 
    public void move() {
        setCoords(coordX + vectorY*1, coordY + vectorY*1);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException err) {
            System.out.print(err);
        }

    }
 
}
