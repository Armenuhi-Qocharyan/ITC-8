package chess;
import java.lang.Math;

public class Queen extends Figure {
    public Queen(String n, char column, int row, Color c) {
        super(n, column, row, c);
    }


    public boolean canGo(char c, int r) {
        int column = (int)this.column - 96;
        int col = (int)c - 96;
        if (((8 > (row - r) || -8 < (row - r))) && (8 > (column - col) || -8 < (column - col))) {
            if ((0 == (row - r)) || (0 == column - col) || (Math.abs(row - r) == Math.abs(column - col))) {
                return true;
            }            
        }
        return false;
    }
    
} 

