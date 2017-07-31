package Shapes;
import java.io.PrintStream;

public class Circle implements Shape {
    // Constructor
    public Circle(int x, int y, int r) {
        mR = (r >= 0) ? r : 0;
        mX = (x >= 0 && x >= mR) ? x : mR;
        mY = (y >= 0 && y >= mR) ? y : mR;
    }

    // Method
    public boolean draw(PrintStream stream, char symbol) {
        if (symbol == ' ') {
            stream.println("Space is not valid symbol");
            return false;
        }

        int width = mX + mR;
        int height = mY + mR;
        char[][] matrix = new char[height + 1][width + 1];
        for (int i = 0; i <= height; ++i) {
            for (int j = 0; j <= width; ++j) {
                if (belongsToTheCircle(j, i)) {
                    matrix[i][j] = symbol;
                } else {
                    matrix[i][j] = ' ';
                }
            }
        }

        for (int i = 0; i <= height; ++i) {
            stream.println(matrix[i]);
        }

        return !stream.checkError();
    }

    private boolean belongsToTheCircle(int x, int y) {
        return ((x - mX) * (x - mX) + (y - mY) * (y - mY) <= mR * mR);
    }

    // Fields
    private int mX;
    private int mY;
    private int mR;
}
