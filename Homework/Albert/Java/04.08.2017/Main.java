import ReadWrite.*;
public class Main {
    public static void main(String[] args) {
        String input = args[0];
        String output = args[1];
        ReadWrite readWrite = new ReadWrite();
        int result = readWrite.readFile(input);
        readWrite.writeFile(output, result);
    }
}
