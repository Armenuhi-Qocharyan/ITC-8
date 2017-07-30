package Shapes;
import java.io.PrintStream;

public class Line implements Shape {
    // Constructor
    // y = k * x + b 
    public Line(int k, int b) {
        mK = k;
        mB = b;    
    }

    // Method
    public boolean draw(PrintStream stream, char symbol) {
        if (symbol == ' ') {
            stream.println("Space is not valid symbol");
            return false;
        }

        char[][] matrix = new char[mB + 1][mB + 1];
        for (int i = 0; i <= mB; ++i) {
            for (int j = 0; j <= mB; ++j) {
            if (i == mK * j + mB) {
                    matrix[i][j] = symbol;
                } else {
                    matrix[i][j] = ' ';
                }
            }
        }

        for (int i = 0; i <= mB; ++i) {
            stream.println(matrix[i]);
        }

        return !stream.checkError();
    }

    // Fields
    private int mK;
    private int mB;
}
