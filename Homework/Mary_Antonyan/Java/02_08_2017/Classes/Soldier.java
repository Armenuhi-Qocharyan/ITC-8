package Classes;

public class Soldier {
    // Members
    private String name;
    private String nationality;
    private int radius;
    private int health;
    private int x;
    private int y;
    private Weapon weapon;

    // Constructor
    public Soldier(String name, String nationality, int radius, int health, int x, int y, Weapon weapon) {
        setName(name);
        setNationality(nationality);
        setRadius(radius);
        setHealth(health);
        setX(x);
        setY(y);
        setWeapon(weapon);
    }

    // Methods
    public void setName(String name) {
        // TODO: add validation for name
        this.name = name;
    }

    public void setNationality(String nationality) {
        // TODO: add validation for nationality
        this.nationality = nationality;
    }

    public void setRadius(int radius) {
        this.radius = (radius > 1) ? radius : 1;
    }

    public void setHealth(int health) {
        this.health = (health > 0) ? health : 100;
    }

    public void setX(int x) {
        this.x = (x > 0) ? x : 0;
    }

    public void setX(int y) {
        this.y = (y > 0) ? y : 0;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = new Weapon(weapon);
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public int getRadius() {
        return radius;
    }

    public int getHealth() {
        return health;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void shoot() {
        // TODO: Add statements to this function to implement shoot action
         
    }
}
