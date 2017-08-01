package Print;
import java.io.*;
public interface Print {
    public void draw(PrintStream out,String content);
 // public void drawOnFile(byte[] content,String fileName);
    public String shape(char mark, int size);
}