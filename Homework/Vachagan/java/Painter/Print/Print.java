package myprint;

import java.io.*;

public class Print {

     private static File CreateFile() {
          File f = new File("file/shape.txt");
          if(!f.exists())
          {
            try {
                f.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
          }
        return f;
    }
    public static PrintStream PrintInFile(boolean yes) {
        if(yes){
            File newFile = CreateFile();
            try {
                    FileOutputStream fos = new FileOutputStream(newFile);
                    PrintStream ps = new PrintStream(fos);
                    return ps;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return System.out;
    }
}