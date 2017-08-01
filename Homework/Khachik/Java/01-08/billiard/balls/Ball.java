package balls;
import java.util.*;
import java.lang.*;

public class Ball{
    public double x;
    public double y;
    public double speed;
    public double angle;
    public Ball() {
        this.x = 0;
        this.y = 0;
        this.speed = 0;
        this.angle = 0;
    }
    public void initialize () {
        System.out.print("Input balls coordinates:\nx = ");
        Scanner scan = new Scanner(System.in);
        this.x = scan.nextInt();
        System.out.print("y = ");
        this.y = scan.nextInt();
        System.out.print("Input ball speed (cm/sec).\nspeed = ");
        this.speed = scan.nextInt();
        System.out.print("Input ball movement angle (0 - 360).\nangle = ");
        this.angle = scan.nextInt();
    }
    public void move(Ball ball2) {
        double time = 0;
        double newX1 = 0;
        double newY1 = 0;
        double newX2 = 0;
        double newY2 = 0;
        System.out.print("\nInput the movement time (sec):\ntime = ");
        Scanner scan = new Scanner(System.in);
        time = scan.nextInt();
        for(int i = 0; i <= Math.max(this.speed, ball2.speed); ++i ) {
            if (this.speed >= i) {
                newX1 = i * Math.cos(Math.toRadians(this.angle)) + this.x;
                newY1 = i * Math.sin(Math.toRadians(this.angle)) + this.y;
            }
            if (ball2.speed >= i) {
                newX2 = ball2.speed * Math.cos(Math.toRadians(ball2.angle)) + ball2.x;
                newY2 = ball2.speed * Math.sin(Math.toRadians(ball2.angle)) + ball2.y;
            }
            if (newX1 == newX2 && newY1 == newY2) {
                System.out.print("Balls are collided.\n");
            }
        }
        System.out.print("First ball's coordinates after movement:\nx = " + newX1 + "\ny = " + newY1 + "\n");
        System.out.print("First ball's coordinates after movement:\nx = " + newX2 + "\ny = " + newY2 + "\n");
    }
}
