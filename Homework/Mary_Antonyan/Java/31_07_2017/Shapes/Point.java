package Shapes;
import java.io.PrintStream;

public class Point implements Shape {
    // Constructor
    public Point(int x, int y) {
        mX = (x >= 0) ? x : 0;
        mY = (y >= 0) ? y : 0;
    } 

    // Method
    public boolean draw(PrintStream stream, char symbol) {
        if (symbol == ' ') {
            stream.println("Space is not valid symbol");
            return false;
        }

        char[][] matrix = new char[mY + 1][mX + 1];
        for (int i = 0; i <= mY; ++i) {
            for (int j = 0; j <= mX; ++j) {
                matrix[i][j] = ' ';
            }
        }
        matrix[mY][mX] = symbol;

        for (int i = 0; i <= mY; ++i) {
            stream.println(matrix[i]);
        }

        return !stream.checkError();
    }

    // Fields
    private int mX;
    private int mY;
}
