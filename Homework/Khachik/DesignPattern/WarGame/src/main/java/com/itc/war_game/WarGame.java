package com.itc.war_game;

import java.util.Scanner;


public class WarGame {
    public static void main(String[] args) {
        Field  field = Field.getInstance();
        createSoldier(field);
        do {
            System.out.print("\nCreate new soldier - 1\n");
            System.out.print("Shot - 2\nExit - 3 \n");
            Scanner scan = new Scanner(System.in);
            int selection = scan.nextInt(); 
            switch(selection) {
                case 1: createSoldier(field); break;
                case 2: System.out.print("Input shoter name\nname = ");
                        Scanner scanLine = new Scanner(System.in);
                        String name = scanLine.nextLine();
                        for (GameObjects object: field.getObjs()) {
                            if(object instanceof Soldiery){
                                if(((Soldiery)object).getName().equals(name)) {
                                    System.out.println("Soldier fined.");
                                    Weapon bullet  = ((Soldiery)object).takeWeapon();
                                    field.fire(bullet, ((Soldiery)object));
                                }
                            }
                        }
                        break;
                case 3: System.out.println("Game over");
                        return;
                default: System.out.println("Wrong input");
                         break;
            }
        } while(true);
    }
    
    
    /**
     * Creates new soldier
     *
     * @param field singleton Field class object
     * @return Soldiery object
     */
    public static Soldiery createSoldier (Field field) {
        Soldiery soldier = null;
        Scanner scan = new Scanner(System.in);
        int selection;
        System.out.println("Create new soldier");
        System.out.print("Ordinery - 1\n");
        System.out.print("Major - 2\n");
        System.out.print("General - 3\n");
        selection = scan.nextInt();
        switch(selection) {
            case 1: soldier = new Ordinary();
                    soldier.initialize(10);
                    System.out.println("Created Ordinary soldier"); 
                    break;
            case 2: soldier = new Major();
                    soldier.initialize(15);
                    System.out.println("Created Major"); 
                    break;
            case 3: soldier = new General();
                    soldier.initialize(20);
                    System.out.println("Created General");
                    break;
            default: System.out.println("Wrong input");
                     break;
        }
        field.setObjects(soldier);
        return soldier;
    }
}
