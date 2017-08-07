package figures;

public class Knight extends Figure {
    public Knight(int x, int y, char color, char name){
        super(x, y, color, name);
    }
    public boolean step(int x, int y, Figure[][] fig) {
        if(0 <= x && 7 >= x && 0 <= y && 7 >= y) {
            if(((1 == Math.abs(this.getx() - x)) && (2 == Math.abs(this.gety() - y))) ||
                    ((2 == Math.abs(this.getx() - x)) && (1 == Math.abs(this.gety() - y))) ) {
                if (null == fig[x][y]) {
                    return true;
                } else if (fig[x][y].getcolor() != this.getcolor()) {
                    fig[x][y] = null;
                    return true;
                }             
            }           
        }
        return false;  
    }
}