package war;

public class Bullet {
    private int count;
    private int size;

    public Bullet(int count, int size) {
        this.count = count;
        this.size = size;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public int getCount() {
        return this.count;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    public int getSize() {
        return this.size;
    }

}
