package shapes;
import shapes.Shape;
import java.io.*;

public class Triangle implements Shape {

    @Override
    public void draw(PrintStream print, char symbol) {
        int size = 10;
        for (int i = 0; i < size; ++i) {

            for (int j = 0; j <= size - i; ++j) {

                print.print(" ");
            }

            for (int k = 0; k <= 2 * i; ++k) {
                print.print(symbol);
            }

            print.println("\n");

        }
    }
}
