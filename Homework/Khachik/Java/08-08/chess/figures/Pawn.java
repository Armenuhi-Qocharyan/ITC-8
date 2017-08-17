package figures;

public class Pawn extends Figure {
    public Pawn(int x, int y, char color, char name){
        super(x, y, color, name);
    }
    public boolean step(int x, int y, Figure[][] fig) {
        if (0 <= x && 7 >= x && 0 <= y && 7 >= y) {
            if (y == this.gety() && 1 == Math.abs(this.getx() - x)) {
                if (('w' == this.getcolor() && this.getx() < x) || ('b' == this.getcolor() && this.getx() > x)) {
                    if (null == fig[x][y]) {
                        return true;
                    } else if (fig[x][y].getcolor() != this.getcolor()) {
                        System.out.print("Find\n");
                        fig[x][y] = null;
                        return true;
                    }
                }
            }           
        }
        return false; 
    }
}