package Balls;
import java.util.ArrayList;

public class Board implements BallsCollisionObserver {
    private ArrayList<Ball> balls;
    private static Board board = null;
    private int height;
    private int wigth;
    private boolean endGame = false;

    private Board(int height, int wigth) { 
        this.height = height;
        this.wigth = wigth;
        this.balls = new ArrayList<Ball>();
    }

    public static Board getInstance(int height, int wigth) {
        if (null == board) {
            board = new Board(height, wigth);
        }
        return board;
    }

    public int getHeight() {
        return this.height;
    }
    public int getWigth() {
        return this.wigth;
    }

    public void setBall(Ball ball) {

        balls.add(ball);
    }

    public ArrayList<Ball> getBalls() {
        return this.balls;
    }


    public boolean getEndGame() {
        return this.endGame;
    }
    public void start(int minut) {
        boolean check = false;
        int second = 0;
        Ball tmp = new Ball(0,0,0,0,0);
        for (second = 1; second < minut; ++second) {
            for (int i = 0; i < this.balls.size(); ++i) {
                balls.get(i).move(i);
            }
            for (int i = 0; i < this.balls.size(); ++i) {
                tmp = balls.get(i);
                for (int j = 0; j < this.balls.size(); ++j) {
                    if (i == j) {
                        continue;
                    } else {
                        balls.get(i).checkCollisionTwoBalls(balls.get(j));
                        if (true == endGame) {
                            break;
                        }
                    }
                }
                if (true == endGame) { break; }
            }
            if (true == endGame) { break; }
        }
        checkCollision(check, second);
    }

    public void checkCollision(boolean check, int sec) {
        if (endGame) {
            System.out.println("In the " + sec + "`th minut two balls collided");
        } else {
            System.out.println("Not Collision");
        }
    }
    
    @Override
    public void notifyBallsCollision() {
        System.out.println("")
        this.endGame = true;
    }

}
