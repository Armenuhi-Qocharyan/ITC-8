import java.io.BufferedReader;
import java.io.IOException;
import java.lang.Integer;
import java.io.FileReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        String input = args[0];
        String output = args[1];
        if (null == input || null == output ) {
            System.err.println("Arguments not found");
            return;
        } 
        int number;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(input));
            number = Integer.parseInt(reader.readLine());
            PrintWriter writer = new PrintWriter(output, "UTF-8");
            writer.println(++number);
            writer.close();

        } catch (IOException ex) {
            System.err.println("An IOException was caught!");
        }
    }

}
