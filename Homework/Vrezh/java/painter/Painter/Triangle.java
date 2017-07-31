package Painter;

import java.io.PrintStream;


public class Triangle implements Shape {
    public void draw(PrintStream stream, char symbol) {
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j <= i; j++) {
                stream.print(symbol);
            }
            stream.println("");
        }       
    }
}
