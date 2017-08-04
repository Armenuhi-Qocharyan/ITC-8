import java.util.ArrayList;

public class Area {

    public void start (Army first, Army second) {
        ArrayList<Soldier> firstSoldiers =  first.getSoldiers();
        ArrayList<Soldier> secondSoldiers = second.getSoldiers();
        for (Soldier soldier: firstSoldiers) {
            soldier.killOpponent(secondSoldiers, second, this);
        }
    }

    public boolean checkStatus (Soldier soldier, Army army) {
        if (0 >= soldier.getBrones()) {
            army.lostSoldier(soldier);
            if ( 0 >= army.getSoldiersCount() ) {
                System.out.println(army.getNationality() + " lose");
                return false;
            }
        }
        return true;
    }
}
