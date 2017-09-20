package Billiard;
import java.util.ArrayList;
import java.util.Random;


public class Table {
    private ArrayList<Ball> movingBalls;
    private ArrayList<Ball> balls;
    private float width;
    private float height;
    private static Table table;

    private Table(float w, float h) {
        movingBalls = new ArrayList<Ball>();
        width = w;
        height = h;
    }

    public static Table getInstance(float w, float h) {
        if (null == table) {
            table = new Table(w, h);
        }
        return table;
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
            for (int j = 0; j < movingBalls.size(); ++j) {
                isCollideChangeBallsVectors(movingBalls.get(j));            
                movingBalls.get(j).move();
            }
        }
    }

    public void addObserver(Ball ball) {
        movingBalls.add(ball);
    }

    public void removeObserver(Ball ball) {
        movingBalls.remove(ball);
    }

    public void isCollideChangeBallsVectors(Ball ball) {
        for (int i = 0; i < balls.size(); ++i) {
            balls.get(i).isCollideWhitBallChageVectors(ball);
        }
        ball.isCollideWithBoudChangeVectors();
    } 

    public void createBalls(int count, float radius, float weight) {
        balls = new ArrayList<Ball>();
        Random random = new Random();
       
        System.out.println("Balls coords ...");
        for (int i = 0; i < count; ++i) {
            Ball ball = new Ball(radius, weight, random.nextFloat() * (width - radius) + radius, random.nextFloat() * (height - radius) + radius, 0 , 0);
            balls.add(ball);
        
        System.out.print(ball.getCoordX());
        System.out.print("  ");
        System.out.println(ball.getCoordY());
        }

    }
}
