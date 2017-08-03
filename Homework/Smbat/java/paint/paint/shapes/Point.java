package paint.shapes;

import java.io.PrintStream;
import java.util.Arrays;
import paint.Shape;

public class Point implements Shape {
    private int x;
    private int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    

    public boolean draw(PrintStream out, char symbol) {
        String[][] canvas = new String[100][100];
        for (String[] canva : canvas) {
            Arrays.fill(canva, "~");
        }
        canvas[y][x] = symbol + "";
        
        for (int i = 0; i < canvas.length; i++) {
            for (String pixel : canvas[i]) {
                out.print(pixel);
            }
            out.println();
        }
        return true;
    }
}