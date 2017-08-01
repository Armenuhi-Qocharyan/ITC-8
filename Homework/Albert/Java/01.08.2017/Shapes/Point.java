package Shapes;
import Shapes.Shape;
import java.io.PrintStream;

public class Point implements Shape {

    public void draw(PrintStream out, char symbol) {
        System.out.println("Point: Write to file completed.");
        out.print(symbol);
    }
}
