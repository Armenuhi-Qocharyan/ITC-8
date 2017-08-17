package objs;
import java.util.ArrayList;
import interfaces.Soldier;

public class Meadow {
    private static ArrayList<Objs> objects;

    public Meadow() {
        objects = new ArrayList<Objs>();
    }

    public static void setObjs (Objs obj) {
        objects.add(obj);
    }

    public ArrayList<Objs> getObjs () {
        return objects;
    }
    
    public Objs getObjectByName (String name) {
        for(Objs obj: objects) {
            if(obj._name == name) {
                return obj;
            }    
        }
        return null;
    }

    public boolean shot(Soldier shoter, Objs bullet, Objs shoterBall, int weapon, ArrayList<Soldier> soldier) {
        Soldier targetSoldier = null;
        double newX1 = bullet._x;
        double newY1 = bullet._y;
        for(int i = 0; i < 100; ++i ) { 
            newX1 += bullet._vectorX; 
            newY1 += bullet._vectorY;
            for(Objs target: objects) {
                if (Math.abs(newX1 - target._x) < (bullet._radius + target._radius) && 
                       Math.abs(newY1 - target._y) < (bullet._radius + target._radius) && target != bullet && target != shoterBall) {
                    System.out.print("The bullet reached its goal: (" + newX1 + ", " + newY1 + ")");
                    switch(weapon) {
                        case 1: shoter.setLife(shoter.getLife() - 3); break;
                        case 2: shoter.setLife(shoter.getLife() - 5); break;
                        case 3: shoter.setLife(shoter.getLife() - 10); break;
                        case 4: shoter.setLife(shoter.getLife() - 15); break;
                        case 5: shoter.setLife(shoter.getLife() - 20); break;
                        case 6: shoter.setLife(shoter.getLife() - 25); break;
                        case 7: shoter.setLife(shoter.getLife() - 50); break;
                        default: System.out.print("Wrong weapon");
                    }

                    for(Soldier sol: soldier) {
                        if(sol.getName().equals(target._name)) {
                            targetSoldier = sol;
                        }
                    }

                    if(targetSoldier.getLife() <= 0) {
                        System.out.println("\nSoldier " + targetSoldier.getName() + " died." );
                    } else {
                        System.out.println("\nSoldier " + targetSoldier.getName() + " have " + targetSoldier.getLife() + " life.");
                    }
                    return true;
                }
            }
        }
        return false;
    }
}

