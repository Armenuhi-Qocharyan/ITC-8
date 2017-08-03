import java.util.ArrayList;
import java.lang.Math;

public class Area {
    private int width;
    private int height;
    private ArrayList<Soldier> soldiers = new ArrayList<>();

    public Area(ArrayList<Soldier> soldiers) {
        this.soldiers = soldiers;
    }
    public double Distance(int first, int second ) {
        return Math.sqrt(Math.pow((this.soldiers.get(first).getX() - this.soldiers.get(second).getX()),2) + Math.pow((this.soldiers.get(first).getY() - this.soldiers.get(second).getY()),2));
    }
    public boolean Shot(int firstSoldier,int secondSoldier,int v,double angle) {
        soldiers.get(firstSoldier).Shoot(v, angle, soldiers.get(secondSoldier), Distance(firstSoldier, secondSoldier));
        return false;
    }
}