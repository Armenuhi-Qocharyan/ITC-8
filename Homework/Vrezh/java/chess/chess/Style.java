package chess;



public abstract class Style {
    public static enum Color { 
        WHITE, BLACK 
    };

    protected char column;
    protected int row;
    Color color;
    
    Style(char col, int r, Color c) {
        column = col;
        row = r;
        color = c;
    }

    public void setColumn(char col) {
        column = col;
    }

    public char getColumn() {
        return column;
    }

    public void setRow(int r) {
        row = r;
    }

    public int getRow() {
        return row;
    }

    public void setColor(Color c) {
        color = c;
    }

    public Color getColor() {
        return color;        
    }

}
