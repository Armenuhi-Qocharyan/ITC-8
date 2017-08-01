package Shapes;
import Shapes.Shape;
import java.io.PrintStream;

public class Line implements Shape {

    public void draw(PrintStream out, char symbol) {
        System.out.println("Line: Write to file completed.");
        for (int i = 0; i < 10; ++i) {
            out.print(symbol);
        }
    }
}
