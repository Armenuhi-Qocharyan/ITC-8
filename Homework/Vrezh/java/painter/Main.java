import Painter.Triangle;
import Painter.Shape;
import Painter.Line;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
   
    public static void main(String[] args) {
        Shape shape = new Triangle();      
        try {
            //draw tinagle on console
            PrintStream printStream = new PrintStream(System.out);
            shape.draw(printStream, '*');
            
            //draw triangle on file
            FileOutputStream fileStream = new FileOutputStream("a.txt");
            printStream = new PrintStream(fileStream);
            shape.draw(printStream, '*');
            
            //draw line
            shape = new Line();
            printStream = new PrintStream(System.out);
            shape.draw(printStream, '_');
            
        } catch(IOException error) {
            System.out.println(error);
        }

    }
}
