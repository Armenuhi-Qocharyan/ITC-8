import java.util.*;
import interfaces.Soldier;
import soldiery.*; 
import objs.*;

public class Main {
    
    public static void main(String[] args) {
        ArrayList<Soldier> sol = new ArrayList<Soldier>();
        Meadow  meadow = new Meadow();
        sol.add(createSoldier(meadow));
        do {
            System.out.print("\nCreate new soldier - 1\n");
            System.out.print("Shot - 2\nMove - 3\nExit -4 \n");
            Scanner scan = new Scanner(System.in);
            int selection = scan.nextInt(); 
            switch(selection) {
                case 1: sol.add(createSoldier(meadow)); break;
                case 2: System.out.print("Input shoter name\nname = ");
                        Scanner scanLine = new Scanner(System.in);
                        String name = scanLine.nextLine();
                        for(Soldier s : sol ) {
                            String shoterName = s.getName();
                            if(s.getName().equals(name)) {
                                System.out.println("Soldier fined");
                                s.fire(meadow, sol);
                                break;
                            }
                        }
                        break;
                case 3: System.out.print("Input soldier name\nname = ");
                        Scanner scanLineMove = new Scanner(System.in);
                        String nameMove = scanLineMove.nextLine();
                        for(Soldier s : sol ) {
                            String shoterName = s.getName();
                            if(s.getName().equals(nameMove)) {
                                System.out.println("Soldier fined");
                                s.move();
                                break;
                            }
                        }
                        break;

                case 4: System.out.println("Game over");
                        return;
                default: System.out.println("Wrong input");
                         break;
            }
        } while(true);
    }

    public static Soldier createSoldier (Meadow meadow) {
        Soldier soldier = null;
        Objs ball = null;
        Scanner scan = new Scanner(System.in);
        int selection;
        System.out.println("Create new soldier");
        System.out.print("Ordinery - 1\n");
        System.out.print("Major - 2\n");
        System.out.print("General - 3\n");
        selection = scan.nextInt();
        switch(selection) {
            case 1: soldier = new Ordinary();
                    ball = soldier.initialize();
                    System.out.println("Created Ordinary soldier"); 
                    break;
            case 2: soldier = new Major();
                    ball = soldier.initialize();
                    System.out.println("Created Major"); 
                    break;
            case 3: soldier = new General();
                    ball = soldier.initialize();
                    System.out.println("Created General");
                    break;
            default: System.out.println("Wrong input");
                     break;
        }
        Meadow.setObjs(ball);
        return soldier;
    }
}
