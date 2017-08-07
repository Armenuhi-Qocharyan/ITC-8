public class Figure {

    protected char name;
    protected char color;
    protected int i;
    protected int j;

    public Figure() { }

    public void setName(char name) {
        this.name = name;
    }
    public char getName() {
        return this.name;
    }
    public void setColor(char color) {
        this.color = color;
    }
    public char getColor() {
        return this.color;
    } 

    //i1, j1 dirq@ vortexic texapoxvelu e i2, j2 dirq@ vortex texapoxvelu e
    public boolean step(int i1, int j1, int i2, int j2) {  
        return true;
    }

}
