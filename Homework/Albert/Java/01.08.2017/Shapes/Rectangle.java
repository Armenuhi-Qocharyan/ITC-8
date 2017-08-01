package Shapes;
import Shapes.Shape;
import java.io.PrintStream;

public class Rectangle implements Shape {

    public void draw(PrintStream out, char symbol) {
        System.out.println("Rectangle: Write to file completed.");
        int size = 10;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                out.print(symbol);
            }
            out.print("\n");
        }


    }
}
