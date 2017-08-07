package figures;


public abstract class Figure {
    private char color;
    private char name;
    private int x;
    private int y;
    public Figure(int x, int y, char color, char name) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.name = name;
    }
    
    abstract public boolean step(int x, int y, Figure[][] fig);
    
    public void setdata(int x, int y, char color) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public void setx(int x) {
        this.x = x;
    }

    public void sety(int y) {
        this.y = y;
    }

    public char getname() {
        return this.name;
    }

    public int getx() {
        return this.x;
    }

    public int gety() {
        return this.y; 
    }

    public char getcolor() {
        return this.color; 
    }

    public void print() {
        if (this != null) {
            System.out.print(this.getname() + " ");
        } else {
            System.out.print("  ");
        }
    }
}