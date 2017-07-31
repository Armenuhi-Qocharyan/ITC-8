package Painter;
import java.io.PrintStream;


public class Point implements Shape {
    public void draw(PrintStream stream, char symbol) {
        stream.print(symbol);
    }
}

