import Shapes.*;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{

        Scanner scanInt = new Scanner(System.in);
        System.out.println("Select shape:  1-Point, 2-Line, 3-Rectangle : ");
        int indexShape = scanInt.nextInt();

        Scanner scanChar = new Scanner(System.in);
        System.out.println("Enter symbol: ");
        char symbol = scanChar.next().charAt(0);

        Scanner fileTerm = new Scanner(System.in);
        System.out.println("Select 1-File, 2-Terminal: ");
        int indexFileTerm = fileTerm.nextInt();

        checkShape(indexShape, symbol, indexFileTerm);

    }
    public static void checkShape(int indexShape, char symbol, int indexFileTerm) throws FileNotFoundException {
        Shape shape = null;
        switch(indexShape) {
            case 1:
                shape = new Point();
                drawShape(shape, symbol, indexFileTerm);
                break;
            case 2:
                shape = new Line();
                drawShape(shape, symbol, indexFileTerm);
                break;
            case 3:
                shape = new Rectangle();
                drawShape(shape, symbol, indexFileTerm);
                break;
            default:
                System.out.println("Incorrect input!");
                break;  
        }
    }
    
    public static void drawShape(Shape shape, char symbol, int indexFileTerm) throws FileNotFoundException {
        if (indexFileTerm == 1) {
	        OutputStream os = new FileOutputStream("test.txt");
	        PrintStream printStream = new PrintStream(os);
	        shape.draw(printStream, symbol);
        } else if (indexFileTerm == 2) {
	        shape.draw(System.out, symbol);
        } else {
            System.out.println("Incorrect Input.");
            return;
        }
    }
}
