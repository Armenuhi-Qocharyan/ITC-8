package Shape;
import Print.*;
import java.io.*;
public class Line implements Print {
    public void draw(PrintStream out,String content) {
		out.println(content);
    }
    public String shape(char mark,int size) {
        String content = "";
        for (int i = 0; i < size; ++i) {
            content += mark;
        }
 	    return content;
    }
}
