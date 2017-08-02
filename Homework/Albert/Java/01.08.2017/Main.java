import Balls.*;

public class Main {
    public static void main(String[] args) {
        Ball ball1 = new Ball(0, 0,5,10,90);
        Ball ball2 = new Ball(50,0,5,10,180);
        int time = 150;
        boolean check = false;
        int minut = 0;
        for (minut = 1; minut < time; ++minut) {
            ball1.move();
            ball2.move();
            if (ball1.ballCollision(ball2)) {
                check = true;
                break;
            }        
        }
        checkCollision(check, ball1, ball2, minut);
    }

    public static void checkCollision(boolean check, Ball ball1, Ball ball2, int sec) {
        if (check) {
            System.out.println("In the " + sec + "`th minut two balls collided");
        } else {
            System.out.println("Not Collision");
        }
    }
}

