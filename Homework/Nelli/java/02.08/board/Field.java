package board;
import solder.Solder;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.Integer;

public class Field {
    private Solder[] solders = new Solder[2];
    private int canvasSize;

    public Field(int size) {
        this.canvasSize = size;
    }

    public int getSize() {
        return this.canvasSize;
    }
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
    }
        public boolean isSolder(int x, int y) {
            for (Solder solder : solders) {
                if (solder.getX() == x && solder.getY() == y) {
                    return true;
                }
            }
            return false;
        }
        
       public void printSoldersInfo() {
            for (Solder solder: solders) {
                System.out.print(solder.getName());
                System.out.println(solder.getNation());
            }
        }

        public void war() {
            if (!solders[0].fire(solders[1], "gun", solders[0].getAngle(solders[1]))) {
                System.out.println("Solder didn't kill he has life : ");
                System.out.println(solders[1].getLife());
            }
        }
 
}