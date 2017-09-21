package Balls;
import java.lang.Math;

public interface BallInterface {

    
    float getWeight();
    void setWeight(float weight);
    int getX();
    void setX(int x);
    int getY();
    void setY(int y);
    int getR();
    void setR(int r);
    void move(int i);
    public double getDistance(BallInterface ball); 
    public void addObserver(BallsCollisionObserver object);
    public void removeObserver(BallsCollisionObserver object);
    public void checkCollisionTwoBalls(BallInterface ball);
    //public void checkCollisionBound(BallInterface ball);
    public void printCoord(int i);




}     
