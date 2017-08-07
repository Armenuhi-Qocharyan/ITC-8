import java.util.ArrayList;

public class BattleField {
    private ArrayList<Soldier> soldiers;

    public BattleField() { 
        soldiers = new ArrayList<Soldier>();

    }

    public void setSoldier(Soldier soldier) {
        this.soldiers.add(soldier);
    }
    public ArrayList<Soldier> getSoldier() {
        return this.soldiers;
    }
}
