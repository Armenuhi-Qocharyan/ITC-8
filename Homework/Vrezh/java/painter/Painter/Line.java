package Painter;
import java.io.PrintStream;


public class Line implements Shape {
    public void draw(PrintStream stream, char symbol) {
        Shape point = new Point();
        PrintStream printStream = new PrintStream(System.out);
 
        for (int i = 0; i < 10; ++i) {
            point.draw(printStream, symbol);
        }
    }
}
