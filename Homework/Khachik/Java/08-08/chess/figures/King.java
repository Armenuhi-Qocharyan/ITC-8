package figures;

public class King extends Figure {
    public King(int x, int y, char color, char name){
        super(x, y, color, name);
    }
    public boolean step(int x, int y, Figure[][] fig) {
        if (0 <= x && 7 >= x && 0 <= y && 7 >= y) {
            if (1 >= Math.abs(x - this.getx()) && 1 >= Math.abs(y - this.gety()))  {
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