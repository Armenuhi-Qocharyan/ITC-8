import Print.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
public class Point implements Print {
    public void drawOnTerminal(byte[] content) {
        System.out.println(content);
    }
    public void drawOnFile(byte[] content,String fileName) {
        FileOutputStream fop = null;
		File file;

		try {

			file = new File("print.txt");
			fop = new FileOutputStream(file);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			
			fop.write(content);
			fop.flush();
			fop.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fop != null) {
					fop.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
    public byte[] shape(char mark,int size) {
		String arr = "";
		arr += mark;
 	    return arr.getBytes();
    }
}
