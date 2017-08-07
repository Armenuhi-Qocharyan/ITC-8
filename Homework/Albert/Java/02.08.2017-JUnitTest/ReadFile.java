import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class ReadFile {
    
    public BattleField read() throws IOException, FileNotFoundException  {
        BattleField battleField = new BattleField();
        String path = "data.txt";
        String readLine = "";
        FileReader fileR = null;
        BufferedReader buffR = null;
        try {
            fileR = new FileReader(path);
            buffR = new BufferedReader(fileR);
            while ((readLine = buffR.readLine()) != null) {
                String[] line = readLine.split(",");

                int count = Integer.parseInt(line[0]);
                int sizeBull = Integer.parseInt(line[1]);
                Bullet bullet = new Bullet(count, sizeBull);

                String type = line[2];
                int damage = Integer.parseInt(line[3]);
                int diapason = Integer.parseInt(line[4]);
                int speed = Integer.parseInt(line[5]);
                Weapon weapon = new Weapon(type, damage, diapason, speed, bullet);

                String name = line[6];
                String nation = line[7];
                int life = Integer.parseInt(line[8]);
                int x = Integer.parseInt(line[9]);
                int y = Integer.parseInt(line[10]);
                int size = Integer.parseInt(line[11]);
                Soldier soldier = new Soldier(name, nation, life, weapon, x, y, size);

                battleField.setSoldier(soldier);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            buffR.close();
        }
        return battleField;

    }

}
