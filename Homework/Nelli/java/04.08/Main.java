import java.io.*;
import java.lang.Integer;

public class Main {
    public static void main(String[] args) {
	String inputFile = args[0];
        String outputFile = args[1];
	int[] inputs = getInputArguments(inputFile);
        int result = sum(inputs[0],inputs[1]);
 	writeResultInFile(outputFile, result);
    }
    
    public static int[] getInputArguments(String filename) {
        int[] inputs = new int[2];
        try {
	    File file = new File(filename);
	    FileReader fileReader = new FileReader(file);
	    BufferedReader br = new BufferedReader(fileReader);
	    String line = null;
            int index = 0;
	    while ((line = br.readLine()) != null) {
	        String[] arguments = (line.toString()).split(",");
	        inputs[0] = Integer.parseInt(arguments[0]);
	        inputs[1] = Integer.parseInt(arguments[1]);
	        ++index;
	    }
            return inputs;
	} catch (IOException e) {
	    System.out.println("IO exception");
        }
	return inputs;
    }

    public static void writeResultInFile(String filename,int result) {
       try { 
	    File file = new File(filename);
            FileWriter writer = new FileWriter(file); 
            writer.write(Integer.toString(result)); 
            writer.flush();
      	    writer.close();
	} catch (IOException e) {
	    System.out.println("IO exception");
        } 

    }
   
    public static int sum(int first, int second) {
  	return first + second;
    }
}
