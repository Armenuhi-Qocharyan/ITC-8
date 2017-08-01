import shape.Line;
import shape.Point;
import shape.Circle;
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        int drawMethod;
        int n = 0;
        char ch;
        String fileName = "draw.txt";
        PrintStream printStream;
        System.out.println("Enter 1 or 2");
        System.out.println("1 - draw in terminal \n2 - draw in file");
        try {
            Scanner scan = new Scanner(System.in);
	    drawMethod = scan.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("Input error: You must enter the integer.");
            return;
        }
        if (drawMethod == 1) {
            printStream = new PrintStream(System.out, true);
        } else if (drawMethod == 2) {
//            OutputStream file = new FileOutputStream("draw.txt"); TODO
//            printStream = new PrintStream(file);  TODO
            printStream = new PrintStream(System.out, true);
        } else {
            System.out.println("Input error: Please enter 1 or 2.");
            return;
        }

        System.out.println("Enter the character for drawing.");
        Scanner sc = new Scanner(System.in);
	ch = sc.next().charAt(0);
        if (Character.isLetter(ch) || Character.isDigit(ch)) {
            System.out.println("Entered symbol is not a character.");
            return;
        }
 
        System.out.println("What you mean to paint.");
        System.out.println("1 - Draw point");
        System.out.println("2 - Draw line");
        System.out.println("3 - Draw circle");
        try {
            Scanner scan = new Scanner(System.in);
	    n = scan.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("Input error: You must enter the integer.");
            return;
        }
        switch (n) {
            case 1: Point point = new Point();
                    point.draw(printStream, ch);
                    break;
            case 2: Line line = new Line();
                    try {
                        line.draw(printStream, ch);
                    } catch (InputMismatchException ex) {
                        System.out.println("Input error: You must enter the integer.");
                        return;
                    }
                    break;
            case 3: Circle circle = new Circle();
                    try {
                        circle.draw(printStream, ch);
                    } catch (InputMismatchException ex) {
                            System.out.println("Input error: You must enter the integer");
                            return;
                    }
                    break;
            default: System.out.println("Wrong input.");

        }
      
    }
}
