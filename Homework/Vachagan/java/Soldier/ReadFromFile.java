import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
public class ReadFromFile {

	private static final String FILENAME = "./solders.txt";
	private BufferedReader br = null;
    private FileReader fr = null;
    private ArrayList <Soldier> soldiers = new ArrayList<Soldier> ();
    public ArrayList <Soldier> Solders() {
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
            String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
                String[] parts = sCurrentLine.split(";");
                double v = Double.parseDouble(parts[0]);
                double angle = Double.parseDouble(parts[1]);
                int magazin = Integer.parseInt(parts[4]);
                int damage = Integer.parseInt(parts[5]);
                soldiers.add(new Soldier(v,angle,parts[2],parts[3],new Weapon(magazin, damage, parts[6])));
                soldiers.get(0).Info();
            }
            return soldiers;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
            }
            return soldiers;
        }
        
    }
}
	
