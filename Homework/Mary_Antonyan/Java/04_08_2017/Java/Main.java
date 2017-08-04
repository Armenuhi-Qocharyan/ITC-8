package Java;
import java.io.*;
import Java.Additive;

public class Main {
    public static void main(String[] args) {
        String input = args[0];
        String output = args[1];
        helper(input, output);
    }

    public static void helper(String input, String output) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(input));
            BufferedWriter out = new BufferedWriter(new FileWriter(output));

            // Read from input file
            String str;
            int a = 0;
            int b = 0;
            // Read first line, assign to a
            if ((str = in.readLine()) != null) {
                a = Integer.parseInt(str);
            } else {
                out.write("Can't read from file...");
            }

            // Read second line, assign to b
            if ((str = in.readLine()) != null) {
                b = Integer.parseInt(str);
            } else {
                out.write("Can't read from file...");
            }

            // Write result to file
            int result = Additive.add(a, b);
            out.write(Integer.toString(result) + "\n");

            // Close input and output files
            if (in != null) {
                in.close();
            }
            if (out !=  null) {
                out.close();
            }
        } catch (IOException e) {
            System.out.println("IOException thrown...");
        }
    }
}
