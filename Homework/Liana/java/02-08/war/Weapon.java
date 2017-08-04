public class Weapon {
    private String type;
    private int speed;
    private int x;
    private int y;
    private Bullets bullet;
    private int bulletsCount;
    private int interval;

    public Weapon (String mark, int v, int parentX, int parentY, int count, int  moveInterval) {
        type = mark;
        speed = v;
        x = parentX;
        y = parentY;
        bulletsCount = count;
        bullet = new Bullets(x, y);
        interval = moveInterval;
    }

    public void fire (Soldier soldier, Soldier target) {
        if (0 < bulletsCount) {
            bullet.go(target, speed, interval);
            bulletsCount--;
        } else {
            System.out.println(soldier.getName() + "haven't bullets");

        }
    }
}
