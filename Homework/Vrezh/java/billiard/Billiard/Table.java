package Billiard;
import java.util.ArrayList;
import java.util.Random;

public class Table {
    private ArrayList<Ball> balls;
    private float width;
    private float height;
    enum side { TOP, BOTTOM, LEFT, RIGHT, MIDDLE }; 

    public Table(float w, float h) {
        width = w;
        height = h;
    }

    public void setBall(Ball b) {
        balls.add(b);
    }

    public ArrayList<Ball> getBalls() {
        return balls;
    }

    public void setSize(float w, float h) {
        width = w;
        height = h;
    }
    
    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public void startGame(int moveTime) { 
        for (int i = 0; i < moveTime; ++i) {
            for (int j = 0; j < balls.size(); ++j) {
                isCollideBall(balls.get(i));            
                balls.get(i).move();
            }
        }
    }

    public boolean isCollideBall(Ball ball) {
        Ball b;
        for (int i = 0; i < balls.size(); ++i) {
            b = balls.get(i);
            if (ball.getCoordX() + ball.getRadius() == b.getCoordX() - b.getRadius()) {
                //change vectors
                return true;         
            } 
            if (ball.getCoordX() - ball.getRadius() == b.getCoordX() + b.getRadius()) {
                //change vectors
                return true;
            }
            if (ball.getCoordY() + ball.getRadius() == b.getCoordY() - b.getRadius()) {
                //change vectors
                return true;
            }
            if (ball.getCoordY() - ball.getRadius() == b.getCoordY() + b.getRadius()) {
                //change vectors
                return true;
            }
        }
        //change vectors
        isCollideBounds(ball);
        return false;
    } 

    public side isCollideBounds(Ball ball) {
        //for (int i = 0; i < balls.size(); ++i) {
            if (ball.getCoordX() == ball.getRadius()) {
                return side.LEFT;
            } else if(ball.getCoordX() == width - ball.getRadius()) {
                return side.RIGHT;
            } else if(ball.getCoordY() == ball.getRadius()) {
                return side.BOTTOM;
            } else if(ball.getCoordY() == height - ball.getRadius()) {
                return side.TOP;
            }
        //}
        return side.MIDDLE;
    }

    public void createBalls(int count, float radius, float weight) {
        balls = new ArrayList<Ball>();
        Random random = new Random();
        Ball ball;
        for (int i = 0; i < count; ++i) {
            ball = new Ball(radius, weight, random.nextFloat() * (width - radius) + width, random.nextFloat() * (height - radius) + height, 0 , 0);
            balls.add(ball);
        }
    }
}
