package shapes;

import java.io.PrintStream;
public class Point implements Shape {
    public boolean Drow(PrintStream ps, char x) {
            System.setOut(ps);
            System.out.println("Point \n\n" + x);
            return true;
    }
}