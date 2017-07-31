package shape;
import java.io.*;
import interfaces.Shape;

public class Point implements Shape {
    public void draw(PrintStream printStream, char ch) {
        printStream.println("\n\t\t\t" + ch + "\n");
    }
}
