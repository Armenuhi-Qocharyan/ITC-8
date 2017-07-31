import Shape.Point;
import Shape.Line;
import Shape.Rectangle;
import java.io.*;
public class Main {
	public static void main(String[] args) throws FileNotFoundException{
	
		Point point = new Point();
		Line line = new Line();
		Rectangle rectangle = new Rectangle();
		try {
			String fileName = "print.txt";
			File file = new File(fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
	    	OutputStream output = new FileOutputStream(fileName);
			PrintStream printStream = new PrintStream(output);
			
			String content = point.shape('*', 1);
			point.draw(printStream, content);
			point.draw(System.out, content);

			content = line.shape('*', 10);
			line.draw(printStream, content);
			line.draw(System.out, content);

			content = rectangle.shape('*', 10);
			rectangle.draw(printStream, content);
			rectangle.draw(System.out, content);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
