public class Weapon {
    private String name;
    private Bullet bullet;

    public Weapon(String name, Bullet bullet) {
        this.name = name;
        this.bullet = bullet;
    }

    public Bullet fire(double x, double y) {
        Bullet fireBullet = Bullet(bullet.getPower(), bullet.getRadius(), bullet.getVx(), bullet.getVy());
        fireBullet.setX(x);
        fireBullet.setY(y);
        return fireBullet;
    }
}