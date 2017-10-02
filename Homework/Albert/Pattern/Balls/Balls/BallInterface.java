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
    double getDistance(BallInterface ball); 
    void addObserver(BallsCollisionObserver object);
    void removeObserver(BallsCollisionObserver object);
    void checkCollisionTwoBalls(BallInterface ball);
    void printCoord(int i); 
    //public void checkCollisionBound(BallInterface ball);
}     
