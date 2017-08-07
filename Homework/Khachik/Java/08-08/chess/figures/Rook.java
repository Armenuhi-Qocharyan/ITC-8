package figures;

public class Rook extends Figure {
    public Rook(int x, int y, char color, char name){
        super(x, y, color, name);
    }
    public boolean step(int x, int y, Figure[][] fig) {
        boolean ch = false;
        if (0 <= x && 7 >= x && 0 <= y && 7 >= y) {
            if (this.getx() == x) {
                if (this.gety() < y) { 
                    for (int i = this.gety() + 1; i < y; ++i) {
                        if (null == fig[x][i]) {
                            ch = true;
                        } else  {
                            return false;
                        }
                    }
                } else if (this.gety() > y) {
                    for (int i = y; i < this.gety(); ++i) {
                        if (null == fig[x][i]) {
                            ch = true;
                        } else  {
                            return false;
                        }
                    }
                }
                if (1 == Math.abs(this.gety() - y)) {
                    ch = true;
                }
            }           
            if (this.gety() == y) {
                if (this.getx() < x) { 
                    for (int i = this.getx() + 1; i < x; ++i) {
                        if (null == fig[i][y]) {
                            ch = true;
                        } else  {
                            return false;
                        }
                    }
                } else if (this.getx() > x) {
                    for (int i = x; i < this.getx(); ++i) {
                        if (null == fig[i][y]) {
                            ch = true;
                        } else  {
                            return false;
                        }
                    }
                }
                if (1 == Math.abs(this.getx() - x)) {
                    ch = true;
                }
            }
        }
        if (ch) {
            if (null == fig[x][y]) {
                return true;
            } else if (fig[x][y].getcolor() != this.getcolor()) {
                fig[x][y] = null;
                return true;
            }      
        }
        return false;     
    }
}