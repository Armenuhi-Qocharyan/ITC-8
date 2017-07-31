import Shapes.*;

public class Main {
       public static void main(String[] args) {
        // Point example
        Point point = new Point(10, 5);
        System.out.println("Point: ");
        point.draw(System.out, '*');
        
        // Line example
        Line line = new Line(0, 5);
        System.out.println("Line: ");
        line.draw(System.out, '*');

        // Circle example
        Circle circle = new Circle(5, 5, 8);
        System.out.println("Circle: ");
        circle.draw(System.out, '*');
    }
}
