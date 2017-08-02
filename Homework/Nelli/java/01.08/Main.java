import balls.*;
public class Main {
    public static void main(String[] args) {
        
	Ball ball1 = new Ball(0, 8, 0, 5, 1); 
	Ball ball2 = new Ball(0, 10, 0, -10, 1); 
        int time = 0;
	int minutes = 120;
        while (time < minutes) {
	    ball1.getX(1);
            ball1.getY(1);
        
            ball2.getX(1);
            ball2.getY(0.1);
            
            if (ball1.drag(ball2)) {
		System.out.println("Boom");
            }
            ++time;
        }
    }
}
