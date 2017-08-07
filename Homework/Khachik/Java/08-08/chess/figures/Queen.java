package figures;

public class Queen extends Figure {
    
    public Queen(int x, int y, char color, char name){
        super(x, y, color, name);
    }

    public boolean step(int x, int y, Figure[][] fig) {
        
        if (0 <= x && 7 >= x && 0 <= y && 7 >= y) {
            boolean ch = false;
            if (Math.abs(this.getx() - x) == Math.abs(this.gety() - y)) {
                if (this.getx() < x && this.gety() < y) {
                    for (int i = this.getx() + 1, j = this.gety() + 1; i < x && j < y; ++i, ++j) {
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
                } else if (fig[x][y].getcolor() != this.getcolor()) {
                    fig[x][y] = null;
                    return true;
                }      
            }       
            
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
            }    
            if (!ch) {
                return false;
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
        return false;
    }
}

