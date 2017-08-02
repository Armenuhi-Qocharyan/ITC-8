package balls;
import java.util.*;
import java.lang.*;

public class Ball{
    public double radius;
    public double x;
    public double y;
    public double speed;
    public double vectorX;
    public double vectorY;
    public Ball() {
        this.x = 0;
        this.y = 0;
        this.speed = 0;
        this.vectorX = 0;
        this.vectorY = 0;
    }
    public void initialize () {
        System.out.print("Input balls coordinates:\nx = ");
        Scanner scan = new Scanner(System.in);
        this.x = scan.nextInt();
        System.out.print("y = ");
        this.y = scan.nextInt();
        System.out.print("Input balls radius:\nradius = ");
        this.radius = scan.nextInt(); 
        System.out.print("Input vectors coordinates:\nx = ");
        this.vectorX = scan.nextInt();
        System.out.print("y = ");
        this.vectorY = scan.nextInt();

    }
    public void move(Ball ball2) {
        double time = 0;
        double newX1 = 0;
        double newY1 = 0;
        double newX2 = 0;
        double newY2 = 0;
        if (Math.abs(this.x - ball2.x) < (this.radius + ball2.radius) && Math.abs(this.y - ball2.y) < (this.radius + ball2.radius)) {
            System.out.println("The balls are one on the other.");
            return;
        }

        System.out.print("\nInput the movement time (sec):\ntime = ");
        Scanner scan = new Scanner(System.in);
        time = scan.nextInt();

        newX1 = this.x;
        newY1 = this.y;
        newX2 = ball2.x;
        newY2 = ball2.y;
        for(int i = 0; i < time; ++i ) {
                newX1 += this.vectorX;
                newY1 += this.vectorY;
                newX2 += ball2.vectorX;
                newY2 += ball2.vectorY;
            if (Math.abs(newX1 - newX2) < (this.radius + ball2.radius) && Math.abs(newY1 - newY2) < (this.radius + ball2.radius)) {
                System.out.print("Balls are collided: (" + newX1 + ", " + newY1 + "), " + "(" + newX2 + ", " + newY2 + ")\n");
                this.vectorX *= -1;
                this.vectorY *= -1;
                ball2.vectorX *= -1;
                ball2.vectorY *= -1;
            }
        }
        System.out.print("First ball's coordinates after movement:\nx = " + newX1 + "\ny = " + newY1 + "\n");
        System.out.print("Second ball's coordinates after movement:\nx = " + newX2 + "\ny = " + newY2 + "\n");
    }
}
