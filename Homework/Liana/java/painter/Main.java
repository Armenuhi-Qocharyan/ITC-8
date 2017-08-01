import shapes.*;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Shape shape = selectShape();
        PrintStream print = selectMethod();

        char symbol;

        do {

            System.out.println("Enter symbol you want to draw with (only one character, no space): ");
            symbol = reader.next().charAt(0);

        } while (' ' == symbol);

        shape.draw(print, symbol);

    }

    public static PrintStream selectMethod() {
        int place;
        Scanner reader = new Scanner(System.in);
        
        do {
            System.out.println("Where you want to print result?");
            System.out.println("In console: 1");
            System.out.println("In File: 2");
            
            while (!reader.hasNextInt()) {
                System.out.println("Incorrect input");
                reader.next();
            }
            place = reader.nextInt();
            
        } while (1 != place && 2 != place);

        if (1 == place) {
            return new PrintStream(System.out);
        }
        
        try {
            PrintStream print = new PrintStream(new FileOutputStream("result.txt", true));
            return print;
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        
        return new PrintStream(System.out);
    }

    public static Shape selectShape() {
        int type;
        Scanner reader = new Scanner(System.in);
        
        do {

            System.out.println("Please select shape: ");
            System.out.println("Point: 1");
            System.out.println("Line: 2");
            System.out.println("Triangle: 3");
            
            while (!reader.hasNextInt()) {
                System.out.println("Incorrect input");
                reader.next();
            }
            type = reader.nextInt();

        } while (1 != type && 2 != type && 3 != type);

        if (1 == type) {
            return new Point();
        } else if (2 == type) {
            return new Line();
        }
        return new Triangle();

    }

}
