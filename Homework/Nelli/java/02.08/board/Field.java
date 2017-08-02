package board;
import solder.Solder;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.Integer;
public class Field {
    private Solder[] solders = new Solder[3];
    public void AddSoldersFromFile(String filename) {
	    try {
			File file = new File(filename);
			FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            String line = null;
            String name = "";
            String nation = "";
            int x = 0;
            int y = 0;
            int life = 0;
            int index = 0;
            while ((line = br.readLine()) != null) {
                String[] solderInfo = (line.toString()).split(",");
                name = solderInfo[0];
                nation = solderInfo[1];
                x = Integer.parseInt(solderInfo[2]);
                y = Integer.parseInt(solderInfo[3]);
                life = Integer.parseInt(solderInfo[4]);
                solders[index] = new Solder(name, nation, x, y, life);
                ++index;
            }
		} catch (IOException e) {
			e.printStackTrace();
        } 
        
       /* public void printSoldersInfo() {
            for (solder: solders) {
                System.out.println()
            }
        }*/
    }
}