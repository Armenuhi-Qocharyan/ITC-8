import java.util.ArrayList;
import java.lang.Math;
public class Main {
 
    public static void main(String[] args) {

        ReadFromFile read = new ReadFromFile();
        ArrayList <Soldier> soldiers = read.Solders();
        Area area = new Area(soldiers);
        area.Shot(0, 3, 100, 90);
        area.Shot(2, 1, 150, 0);
        area.Shot(3, 4, 40, 180);
    }
}