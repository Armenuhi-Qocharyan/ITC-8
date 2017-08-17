package shape;
import java.io.*;
import interfaces.Shape;
import java.util.*;

public class Line implements Shape {
    public void draw(PrintStream printStream, char ch) {
        int length;        
        printStream.println("Input line length.");
        Scanner scan = new Scanner(System.in);
	length = scan.nextInt();
        printStream.println("\n");
        for (int i = 0; i < length; ++i) {
            printStream.print(ch);
        }
        printStream.println("\n");
    }
}
