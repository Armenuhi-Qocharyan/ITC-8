package shapes;
import shapes.Shape;
import java.io.*;

public class Line implements Shape {

    @Override
    public void draw(PrintStream print, char symbol) {
        int size = 10;
        char line[][] = new char[size][size];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (4 == i) {
                    line[i][j] = symbol;
                } else {
                    line[i][j] = ' ';
                }
            }
        }
        for (int i = 0; i < size; ++i) {
            print.println(line[i]);
        }
    }
}
