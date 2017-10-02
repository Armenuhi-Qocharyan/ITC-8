package Balls;
import java.util.ArrayList;

public class Board implements BallsCollisionObserver {
    private ArrayList<BallInterface> balls;
    private static Board board = null;
    private int height;
    private int wigth;
    private boolean endGame = false;

    private Board(int height, int wigth) { 
        this.height = height;
        this.wigth = wigth;
        this.balls = new ArrayList<BallInterface>();
    }

    public static Board getInstance(int height, int wigth) {
        if (null == board) {
            board = new Board(height, wigth);
        }
        return board;
    }

    // Board height getter
    public int getHeight() {
        return this.height;
    }

    // Board wigth getter
    public int getWigth() {
        return this.wigth;
    }
    
    // Add balls in boards ArrayList
    public void setBall(BallInterface ball) {
        balls.add(ball);
    }

    // Get all balls
    public ArrayList<BallInterface> getBalls() {
        return this.balls;
    }


    public boolean getEndGame() {
        return this.endGame;
    }

    
    public void start(int minut) {
        boolean check = false;
        int second = 0;
        BallInterface tmp = new Ball(0,0,0,0,0);
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
        System.out.println("\nNotification. Two balls are collided!\n       ***** End Game *****\n");
        this.endGame = true;
    }

}
