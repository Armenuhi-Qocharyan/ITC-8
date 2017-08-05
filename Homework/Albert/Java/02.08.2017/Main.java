import war.*;
import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BattleField battleField = new BattleField();
        try {
            battleField = createSoldier();
            startGame(battleField);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static BattleField createSoldier() throws IOException{
        BattleField battleField = new BattleField();;
        try{
            ReadFile readFile = new ReadFile();
            battleField = readFile.read();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return battleField;
    }
    
    public static boolean soldierIsDead(Soldier soldier) {
        return (soldier.getLife() <= 0);
            
    }

    public static void printSoldierName(BattleField battleField) {
        int i = 0;
        for (Soldier soldier : battleField.getSoldier()) {
            System.out.print(i + 1 + "-");
            System.out.print(soldier.getName() + "\n");
            ++i;
        }
    }

    public static void printAllSoldier(BattleField battleField) {
        for (Soldier soldier : battleField.getSoldier()) {
            soldier.printSoldierInfo();
        }
    }
    
    public static void startGame(BattleField battleField) {
        while (battleField.getSoldier().size() > 1) {
            Scanner input = new Scanner(System.in);
            System.out.print("\nSelect 1-Soldier info, 2-Fire :");
            int action = input.nextInt();
            if (1 == action) {
                printAllSoldier(battleField);
            } else if (2 == action) {
                printSoldierName(battleField);
                System.out.print("Select soldier who will shoot: ");
                int i = input.nextInt();
                System.out.print("Select soldier who will be the target: ");
                int j = input.nextInt();
                if (i == j || 0 > i || i > battleField.getSoldier().size() || 0 > j || j > battleField.getSoldier().size()) {
                    System.out.println("Incorrect input!!!");
                    return;
                }
                ArrayList<Soldier> allSoldier = battleField.getSoldier();
                allSoldier.get(i-1).fire(allSoldier.get(j-1), 45);
                if(soldierIsDead(allSoldier.get(j-1))) {
                    System.out.println(allSoldier.get(j-1).getName() + " is dead");
                    battleField.getSoldier().remove(j-1);
                }
            } else {
                System.out.println("Incorrect action input!!!");
                return;
            }
        }
        if (battleField.getSoldier().size() <= 1) {
            System.out.println("Remained only one soldier!!! END GAME !!!");
            return;
        }
    }
}
