import balls.Ball;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        Ball ball1 = new Ball();
        Ball ball2 = new Ball();
        try {
            System.out.println("\nFirst ball:\n");
            ball1.initialize();
            System.out.println("\nSecond ball:\n");
            ball2.initialize();
            ball1.move(ball2);
        } catch (InputMismatchException ex) {
            System.out.println("Input Error.");
        }
    }
}
