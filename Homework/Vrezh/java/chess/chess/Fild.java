package chess;

public class Fild extends Style {
    Figure figure;    
    Fild(char col, int r, Color c, Figure f) {
        super(col, r, c);    
        figure = f;  
    }

    public void setFigure(Figure f) {
        figure = f;
    }

    public Figire getFigure() {
        return figure;
    }

}
