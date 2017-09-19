package objs;
import java.util.ArrayList;
import interfaces.Soldier;

public class Meadow {
    static private Meadow _instance = null;
    private static ArrayList<Objs> objects;

    private Meadow() {
        objects = new ArrayList<Objs>();
    }

    /**
     * Get Meadow singleton class object
     */
    public static synchronized Meadow getInstance() {
        if (_instance == null)
            _instance = new Meadow();
        return _instance;
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

    /**
     * Some Soldier fires.
     */
    public boolean shot(Soldier shoter, Objs bullet, Objs shoterBall, int weapon, ArrayList<Soldier> soldier) {
        Soldier targetSoldier = null;
        double newX1 = bullet._x;
        double newY1 = bullet._y;
        int lifeChange = 0;
        for(int i = 0; i < 100; ++i ) { 
            newX1 += bullet._vectorX; 
            newY1 += bullet._vectorY;
            for(Objs target: objects) {
               lifeChange = target.shotListener(newX1, newY1, bullet, shoterBall, weapon);
                if (lifeChange > 0) {
                    System.out.print("The bullet reached its goal: (" + newX1 + ", " + newY1 + ")");
                    for(Soldier sol: soldier) {
                        System.out.println("find ");
                        if(sol.getName().equals(target._name)) {
                            targetSoldier = sol;
                            targetSoldier.setLife(targetSoldier.getLife() - lifeChange);
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

