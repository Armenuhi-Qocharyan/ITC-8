public class Controller {
    public static void main(String[] args) {
        Weapon armWeapon = new Weapon("Kalash", 50, 1, 20);
        Weapon azerWeapon = new Weapon("TuftaZenq", 10, 1, 5);
        
        Solger armSolger = new Solger("Vaxinak", "Armenia", armWeapon, 0, 0);
        Solger azerSolger = new Solger("TuftaAzer", "Azer", azerWeapon, 30, 30);

        

    }
}
