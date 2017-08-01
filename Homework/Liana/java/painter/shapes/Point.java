package shapes;
import shapes.Shape;
import java.io.*;

public class Point implements Shape {

    @Override
    public void draw(PrintStream print, char symbol) {
        int size = 10;
        char point[][] = new char[size][size];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                point[i][j] = ' ';
            }
        }
        point[size / 2][size / 2] = symbol;
        for (int i = 0; i < size; ++i) {
            print.println(point[i]);
        }
    }
}
