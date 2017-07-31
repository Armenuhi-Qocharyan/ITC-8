package paint.shapes;

import java.io.PrintStream;
import java.util.Arrays;
import paint.Shape;

public class Line implements Shape {
    private Point point1;
    private Point point2;

    public Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }
    
    public boolean draw(PrintStream out, char symbol) {
        String[][] canvas = new String[100][100];
        for (String[] canva : canvas) {
            Arrays.fill(canva, "~");
        }
        
        
        return true;
    }
    
}
