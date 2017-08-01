package shapes;

import java.io.PrintStream;

public class Line implements Shape{
    int length = 20;

    public Line(int length ) {
        this.length = length;
    }
    public boolean Drow(PrintStream ps, char x) {
            System.setOut(ps);
            System.out.println("Line \n\n");
            for (int i = 0; i< length; ++i) {
                 System.out.print(x);
            }
            return true;
    }
}