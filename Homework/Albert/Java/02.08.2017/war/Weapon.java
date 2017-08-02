package war;

public class Weapon {
    private String type;
    private int damage;
    private int diapason;
    private int speed;
    private Bullet bullet;

    public Weapon(String type, int damage, int diapason, int speed, Bullet bullet) {
        this.type = type;
        this.damage = damage;
        this.diapason = diapason;
        this.speed = speed;
        this.bullet = bullet;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return this.type;
    }

    public void setdamage(int damage) {
        this.damage = damage;
    }
    public int getDamage() {
        return this.damage;
    }

    public void setDiapason(int diapason) {
        this.diapason = diapason;
    }
    public int getDiapason() {
        return this.diapason;
    }
    
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getSpeed() {
        return this.speed;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }
    public Bullet getBullet() {
        return this.bullet;
    }
}
