public class Controller {
    public static void main(String[] args) {
        Bullet bulletKalash = new Bullet(50, 1, 20);
        Bullet bulletAzer = new Bullet(10, 1, 5);

        Weapon armWeapon = new Weapon("Kalash", bulletKalash);
        Weapon azerWeapon = new Weapon("azerWapon", bulletAzer);
        
        Solger armSolger = new Solger("Vaxinak", "Armenia", armWeapon, 0, 0);
        Solger azerSolger = new Solger("TuftaAzer", "Azer", azerWeapon, 30, 30);

        

    }
}