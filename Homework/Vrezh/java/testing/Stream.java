import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Stream {
    private File input;
    private File output;
    public Stream(String i, String o) {
        input = new File(i);
        output = new File(o);
    }

    public String readOfFile() {
        String str = " ";
        try {
            
            BufferedReader br = new BufferedReader(new FileReader(input));
            while ((str = br.readLine()) != null) {
                writeToFile(addNumbers(str)); 
            } 
            br.close();
        } catch (IOException e) {
            System.out.print(e);  
        }
        return str;
    }

    private int[] addNumbers(String string) {
        String numbersStr = string.replaceAll("[^0-9]+", " ");
        String[] splitStr = numbersStr.trim().split(" ");
        int[] numbers = new int[splitStr.length];
        for (int i = 0; i < splitStr.length; ++i) {
            numbers[i] = Integer.parseInt(splitStr[i]) + 1;
        }
        return numbers;
    }

    public void writeToFile(int[] numbers) {
        try {
            for (int number : numbers) {
                FileWriter fw = new FileWriter(output, true); // true for appending
                PrintWriter pw = new PrintWriter(fw, true); // true for auto-flush
                pw.println(number);
                pw.close();
            }
        } catch (IOException e) {
            System.out.print(e);  
        }
    }

}
