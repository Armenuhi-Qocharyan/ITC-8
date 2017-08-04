import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
            FileInputStream fis = new FileInputStream(args[0]);
            FileOutputStream fos = new FileOutputStream(args[1]);

            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(Integer.parseInt(line)*10);
                writer.write((Integer.toString(Integer.parseInt(line)*10)));
                writer.newLine();
            }
            writer.close();
            br.close();
    }
}
