package chess;

public class Queen extends Style implements Figure {
    private String name;
    Queen(String n, String column, int row, Color c) {
        super(column, row, color);
        name = n;
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    private boolean canGo(String col, int r) {
        int column = (int)this.column - 96;
        if(((8 > (row - r) || -8 < (row - r))) && (8 > (column - col) || -8 < (column - col))) {
            if((0 == (row - r)) || (0 == (column - col)) || (row - r == column - col)) {
                return true;
            }            
        }
        return false;
    }
    
} 

