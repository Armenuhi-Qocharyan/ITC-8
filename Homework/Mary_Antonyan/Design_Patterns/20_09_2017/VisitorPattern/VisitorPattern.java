package visitorpattern;

public class VisitorPattern {

    public static void main(String[] args) {
        Field field = Field.getInstance();
        
        field.addObservable(new Soldier("Soldier", 10, 10, 0.5, 0, 50));
        field.addObservable(new Tank("Tank", 10, 10, 0.5, 0, 200));
        field.addObservable(new Bullet("Bullet", 90, 10, -0.5, 0, 60));
        field.addObservable(new Grenade("Grenade", 90, 10, -0.5, 0, 100));
        
/*
        while (!field.isEmpty()) {
            field.moveObjects();
            System.out.println("\n====================\n");
        }
*/

        for (int i = 0; i < 41; ++i) {
            field.moveObjects();
            System.out.println("\n====================\n");
        }
    }
}
