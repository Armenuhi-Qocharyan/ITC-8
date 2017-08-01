
import java.lang.Math;
import objects.*;

public class Controller {
    public static void start() {
        Ball[] balls = new Ball[2];
        balls[0] = new Ball(10, 10, 4, 2, 3, 0);
        balls[1] = new Ball(20, 10, 4, 2, -2, 0);

        int time = 10;
        double delta = 0.1;

        print(balls);
        
        for(double t = 0; t <= time; t += delta) {
            moveBalls(balls, delta);
            cheackCollisions(balls);
        }

        print(balls);
    }

    public static void moveBalls(Ball[] balls, double spendTime) {
        for (Ball ball:balls) {
            ball.move(spendTime);
        }
    }

    public static void cheackCollisions(Ball[] balls) {
        for (int i = 0; i < balls.length; ++i) {
            for (int j = i + 1; j < balls.length; ++j) {
                if (isCollision(balls[i], balls[j])) {
                    calculateCollision(balls[i], balls[j]);
                }
            } 
        }
    }

    public static void calculateCollision(Ball ball1, Ball ball2) {
        System.out.println("Collision");
        ball1.print();
        ball2.print();
    }

    public static boolean isCollision(Ball ball1, Ball ball2) {
        double distanse = Math.hypot( (ball2.getX() - ball1.getX()), (ball2.getY() - ball1.getY()) );
        if ( distanse <= ( ball1.getR() + ball2.getR() ) ) {
            return true;
        }
        return false;
    }

    public static void print(Ball[] balls) {
        for (Ball ball:balls) {
            ball.print();
        }
    
    }
}
