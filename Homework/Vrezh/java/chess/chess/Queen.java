package chess;

public class Queen extends Figure {
    public Queen(String n, char column, int row, Color c) {
        super(n, column, row, c);
    }


    public boolean canGo(char col, int r) {
        int column = (int)this.column - 96 - 1;
        if(((8 > (row - r) || -8 < (row - r))) && (8 > (column - col) || -8 < (column - col))) {
            if((0 == (row - r)) || (0 == (column - col)) || (row - r == column - col)) {
                return true;
            }            
        }
        return false;
    }
    
} 

