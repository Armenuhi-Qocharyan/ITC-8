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
        int x1 = point1.getX();
        int y1 = point1.getY();
        int x2 = point2.getX();
        int y2 = point2.getY();

        double m = (Math.abs(y2-y1)/Math.abs(x2-x1));
        double b = y1 - (m * x1);
        
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (i < (m * j + b + 0.5) && i > (m * j + b - 0.5)) {
                    canvas[i][j] = symbol + "";
                    out.print(symbol);
                } else {
                    canvas[i][j] = " ";
                    out.print("~");
                }
            }
            out.println();
        }
        return true;
    }
}
