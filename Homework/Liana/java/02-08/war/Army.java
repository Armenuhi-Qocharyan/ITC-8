import java.nio.file.Files;
import java.nio.charset.Charset;
import java.lang.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 
import java.util.Random; 

public class Army {

    private String nationality;
    private ArrayList<Soldier> soldiers;
    private int soldiersCount;

    public Army (String nation) {
        nationality = nation;
    }

    public boolean initSoldiers (String data) {
        soldiers = new ArrayList<Soldier>();
        String name;
        int x;
        int y;
        int brone;
        int width;
        List<String> list = new ArrayList<String>();
        File file = new File(data);
        if (file.exists()){
            try {
                list = Files.readAllLines(file.toPath(),Charset.defaultCharset());
            } catch (IOException ex) {
                System.out.println("Can't read file..");
            }
            if (list.isEmpty()) {
                return false;
            }
        }
        int bulletCount;
        int speed;
        String weaponMark;
        int interval;
        for (String line : list) {
            String [] res = line.split(";");
            name = res[0];
            x = Integer.parseInt(res[1]);
            y = Integer.parseInt(res[2]);
            brone = Integer.parseInt(res[3]);
            width = Integer.parseInt(res[4]);
            weaponMark = res[5];
            bulletCount = Integer.parseInt(res[6]);
            speed = Integer.parseInt(res[7]);
            interval = Integer.parseInt(res[8]);

            Weapon weapon = new Weapon(weaponMark, speed, x, y, bulletCount, interval ) ;
            Soldier soldier = new Soldier(name, x, y, weapon, brone, width);

            soldiers.add(soldier);
        }
        soldiersCount = soldiers.size();

        return true;

    }

    public void lostSoldier (Soldier soldier) {
        System.out.println(soldier.getName() + " died..");
        soldiers.remove(soldier);
        soldiersCount--;
    }

    public int getSoldiersCount () {
        return soldiersCount;
    }

    public ArrayList<Soldier> getSoldiers() {
        return soldiers;
    }

    public String getNationality () {
        return nationality;
    }
}

