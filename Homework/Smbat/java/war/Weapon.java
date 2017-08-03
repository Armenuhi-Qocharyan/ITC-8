public class Weapon {
    private String name;
    private Bullet bullet;

    public Weapon(String name) {
        this.name = name;
        this.bullet = new Bullet();
    }
} 
