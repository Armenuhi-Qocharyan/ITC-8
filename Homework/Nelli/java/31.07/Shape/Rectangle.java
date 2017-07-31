package Shape;
import Print.*;
import java.io.*;
public class Rectangle implements Print {
    public void draw(PrintStream out,String content) {
		out.println(content);
    }
    public String shape(char mark,int size) {
        String content = "";
        for (int i = 0; i < size; ++i) {
            content += mark;
        }
        content += "\n";
        for (int i = 2; i < size; ++i) {
            content += mark;
            for (int j = 2; j < size; ++j) {
                content += " ";
            }
            content += mark;
            content += "\n";
        }
      
        for (int i = 0; i < size; ++i) {
            content += mark;
        }
 	    return content;
    }
}
