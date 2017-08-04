import java.util.ArrayList;
import java.awt.Point;

public class Soldier {
    private String name;
    private int x;
    private int y;
    private int brones;
    private Weapon weapon;
    private int width;
    private int flag;

    public Soldier (String soldierName, int posX, int posY, Weapon oneWeapon, int brone, int soldierWidth) {
        name = soldierName;
        x = posX;
        y = posY;
        weapon = oneWeapon;
        brones = brone;
        width = soldierWidth;
    }

    public String getName () {
        return name;
    }


    public int getBrones () {
        return brones;
    }

    public int getX () {
        return x;
    }

    public int getY () {
        return y;
    }

    public int getWidth () {
        return width;
    }

    public int getFlag () {
        return flag;
    }
    public void  killOpponent (ArrayList<Soldier> opponents, Army second, Area area) {

        for (int i = 0; i < opponents.size(); ++i) {
            weapon.fire(this, opponents.get(i));
            area.checkStatus(opponents.get(i), second);
        }

    }

    public void injured () {
        if (0 < brones) {
            brones--;
            System.out.println(name + " on target. Brones left: " + brones);
        }   
    }


}
