package shape;
import java.io.*;
import interfaces.Shape;
import java.util.*;

public class Circle implements Shape {
    public void draw(PrintStream printStream, char ch) {
        int radius = 0;        
        printStream.println("Input circle radius. 5 or 10 or 13 or 15 or 17");
        Scanner scan = new Scanner(System.in);
	radius = scan.nextInt();
        char cir[][] = new char[40][40];        
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                if(((i - 20) * (i - 20) + (j - 20) * (j - 20)) == radius * radius) {
                    cir[i][j] = ch;
                } else {
                    cir[i][j] = ' ';
                }
            }
        }
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                printStream.print(cir[i][j] + " ");
            }
            printStream.println("");
        }
    }
}
