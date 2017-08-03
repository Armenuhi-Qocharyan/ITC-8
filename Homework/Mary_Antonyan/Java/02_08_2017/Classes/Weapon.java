package Classes;
import java.util.ArrayList;

public class Weapon {
    // Members
    private String type;
    private int distance;
    private int lethality;
    private ArrayList<Bullet> bullets;

    // Constructor
    public Weapon(String type, int distance, int lethality, Bullet bullet) {
        this.type = type;
        setDistance(distance);
        setLethality(lethality);
        bullets = new ArrayList<Bullet>();
        setBullets(bullet);
    }

    // Copy constructor
    public Weapon(Weapon other) {
        this.type = other.type;
        this.distance = other.distance;
        this.lethality = other.lethality;
        setBullets(other.bullets[0]);
    }

    // Methods
    public void setType(String type) {
        this.type = type;
    }

    public void setDistance(int distance) {
        this.distance = (distance > 1) ? distance : 1;
    }

    public void setLethality(int lethality) {
        this.lethality = (lethality > 1) ? lethality: 1;
    }

    public void setBullets(Bullet bullet) {
        for (int i = 0; i < countOfBullets; ++i) {
            this.bullets.add(bullet);
        }
    }

    public String getType() {
        return type;
    }

    public int getDistance() {
        return distance;
    }

    public int getLethality() {
        return lethality;
    }

    public Bullet getBullet() {
        return bullets[0];
    }

    public void popBullet() {
        // TODO: add logic for recharging weapon if bullets are over
        this.bullets.remove(0);
    }
}
