import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> lines;
        if (args.length == 0) {
            System.out.println("Please input in argument file name with path");
        } else {
            String fileName = args[0];
            lines = readeFromFile(fileName);
            int sum = Integer.parseInt(lines.get(0)) + Integer.parseInt(lines.get(1));
            System.out.println(sum);
        }
    }

    public static ArrayList<String> readeFromFile(String fileName) {
        String line = null;
        ArrayList <String> lines = new ArrayList<String>();
        try {
            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" + fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '" + fileName + "'");

        }
        return lines;
    }
}
