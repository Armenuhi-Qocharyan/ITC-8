package figures;

public class Bishop extends Figure {
    public Bishop(int x, int y, char color, char name){
        super(x, y, color, name);
    }
    public boolean step(int x, int y, Figure[][] fig) {
        if(0 <= x && 7 >= x && 0 <= y && 7 >= y) {
        if (Math.abs(this.getx() - x) == Math.abs(this.gety() - y)) {
            if (this.getx() < x && this.gety() < y) {
                for (int i = this.getx() + 1,  j = this.gety() + 1; i < x && j < y; ++i, ++j) {
                    if(null != fig[i][j]) {
                        return false;
                    }
                }
            }
            if (this.getx() < x && this.gety() > y) {
                for (int i = this.getx() + 1, j = this.gety() - 1; i < x && j > y; ++i, --j) {
                    if(null != fig[i][j]) {
                        return false;
                    }
                }
            }
            if (this.getx() > x && this.gety() > y) {
                for (int i = this.getx() - 1, j = this.gety() - 1; i > x && j > y; --i, --j) {
                    if(null != fig[i][j]) {
                        return false;
                    }
                }
            }
            if (this.getx() > x && this.gety() > y) {
                for (int i = this.getx() - 1, j = this.gety() + 1; i > x && j < y; --i, ++j) {
                    if(null != fig[i][j]) {
                        return false;
                    }
                }
            }
            if (null == fig[x][y]) {
                return true;
            } else if (fig[x][y].getcolor() != this.getcolor()){
                fig[x][y] = null;
                return true;
            }
        }       
    }
    return false;   
    }
} 