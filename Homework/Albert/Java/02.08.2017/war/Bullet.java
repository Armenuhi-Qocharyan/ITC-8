package war;

public class Bullet {
    private int x;
    private int y;
    private int moveX;
    private int moveY;
    private int count;
    private int size;

    public Bullet(int x, int y, int count, int size) {
        this.x = x;
        this.y = y;
        this.moveX = x;
        this.moveY = y;
        this.count = count;
        this.size = size;
    }

    public void setX(int x) {
        this.x = x;
    }
    public int getX() {
        return this.x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getY() {
        return this.y;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public int getCount() {
        return this.count;
    }
    
    public void setMoveX(int x) {
        this.moveX = x;
    }
    public int getMoveX() {
        return this.moveX;
    }

    public void setMoveY(int y) {
        this.moveY = y;
    }
    public int getMoveY() {
        return this.moveY;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public int getSize() {
        return this.size;
    }

}
