import balls.*;
public class Main {
    public static void main(String[] args) {
        
	Ball ball1 = new Ball(0, 0, 0, 0, 1); 
	Ball ball2 = new Ball(0, 10, 0, -10, 1); 
        int time = 0;

        while (time < 5) {
	    System.out.println(ball1.getX(1));
            System.out.println(ball1.getY(1));
        
            System.out.println(ball2.getX(1));
            System.out.println(ball2.getY(1));
            
            if (ball1.drag(ball2)) {
		System.out.println("Boom");
            }
            ++time;
        }
    }
}
