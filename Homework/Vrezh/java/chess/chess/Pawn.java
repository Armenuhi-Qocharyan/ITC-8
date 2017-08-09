package chess;

public class Pawn extends Figure {
    private static int stepCount;

    public Pawn(String n, char column, int row, Color c) {
        super(n, column, row, c);
        stepCount = 0;
    }


    public boolean canGo(char c, int r) {
        int column = (int)this.column - 96;
        int col = (int)c - 96;
        System.out.println(col);
        
        System.out.println(r);

        System.out.println(column);
        System.out.println(row);
        if ((8 > r && color == Style.Color.BLACK) || (0 <= r && color == Style.Color.WHITE) && (column - col == 0)) {
            if (0 == stepCount && ((color == Style.Color.WHITE && ((r - row) == 2 || (r - row) == 1)) || (color == Style.Color.BLACK && ((row - r) == 2 || (row - r) == 1)))) { 
                ++stepCount;
                return true;
            } else if (1 == stepCount && ((color == Style.Color.WHITE && (col - column) <= 1) || (color == Style.Color.BLACK && (column - col) <= 1))) {
            return true;
            }
        }
        return false;
    }
    
} 

