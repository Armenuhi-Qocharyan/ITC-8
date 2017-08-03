package bullet;
import board.Field;
import java.lang.Math;
public class Bullet {
    private int x;
    private int y;
    private int speed;

    public Ballet(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    private void move(int angle, Field board) {
        int size = board.getSize();
        while (this.x <= size && this.y <= size) {
            if (board.isSolder(this.x, this.y)) {
                System.out.println("Solder killed");
                this.speed = 0;
                return;
            }
            this.x += this.speed * Math.sin(angle); // * interval ;
            this.y += this.speed * Math.cos(angle); 
        }
        System.out.println("You didn't kill any solder");
    }
}