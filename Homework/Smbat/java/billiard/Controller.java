// This class controls objects moving

import java.lang.Math;
import objects.*;

public class Controller {
    public static void start() {
//-----------------------------------Create objects--------
        Ball[] balls = new Ball[2];
        balls[0] = new Ball(10, 10, 4, 2, 3, 0);
        balls[1] = new Ball(20, 10, 4, 2, -2, 0);

        int time = 10;
        double delta = 0.1;

        print(balls);
//-----------------------------moving objects by delta time and call chacking Collision
        for(double t = 0; t <= time; t += delta) {
            moveBalls(balls, delta);
            cheackCollisions(balls);
        }

        print(balls);
    }
//-------------------------Moving object----
    public static void moveBalls(Ball[] balls, double spendTime) {
        for (Ball ball:balls) {
            ball.move(spendTime);
        }
    }
//-----------------------Check Collision All objects---------------
    public static void cheackCollisions(Ball[] balls) {
        for (int i = 0; i < balls.length; ++i) {
            for (int j = i + 1; j < balls.length; ++j) {
                if (isCollision(balls[i], balls[j])) {
                    calculateCollision(balls[i], balls[j]);
                }
            } 
        }
    }
//--------------------------Calculating Collision------------------
    public static void calculateCollision(Ball ball1, Ball ball2) {
        System.out.println("Collision");
        ball1.setV(ball1.getVx() * (-1), ball1.getVy() * (-1));
        ball2.setV(ball2.getVx() * (-1), ball2.getVy() * (-1));
        
        ball1.print();
        ball2.print();
    }
//------------------------Check collision thwo objects--------------
    public static boolean isCollision(Ball ball1, Ball ball2) {
        double distanse = Math.hypot( (ball2.getX() - ball1.getX()), (ball2.getY() - ball1.getY()) );
        if ( distanse <= ( ball1.getR() + ball2.getR() ) ) {
            return true;
        }
        return false;
    }
//--------------------------Print Object Array-------------------
    public static void print(Ball[] balls) {
        int i = 0;
        for (Ball ball:balls) {
            System.out.print ("Ball [" + ++i + "] : ");
            ball.print();
        }
    
    }
}
