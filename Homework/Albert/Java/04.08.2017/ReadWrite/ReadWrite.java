package ReadWrite;
import java.io.BufferedReader;
import java.io.FileReader;

import java.io.FileWriter;
import java.io.PrintWriter;

import java.io.IOException;

public class ReadWrite {
    public static int readFile(String inputFile) {
        String readLine = "";
        int result = 0;
        try {
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferReader = new BufferedReader(fileReader);
            while ((readLine = bufferReader.readLine()) != null) {
                String[] line = readLine.split(",");
                for (int i = 0; i < line.length; ++i) {
                    result += Integer.parseInt(line[i]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error read to file '"+ inputFile + "'");
        }
        return result;
    }

    public static void writeFile(String outputFile, int number) {
        try {

            FileWriter fileWriter = new FileWriter(outputFile);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(number);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error writing to file '"+ outputFile + "'");
        }
    }
}
