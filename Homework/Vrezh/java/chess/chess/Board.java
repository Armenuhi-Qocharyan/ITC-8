package chess;

public class Board {
    private Fild[][] filds;   
    private static Board board;

    private Board() {
        createBoard(); 
    }

    private void createBoard() {
        Color color = Color.WHITE;
        colRow = new Fild[8][8];
        char[] col = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        char[] row = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                filds[i][j]  = new Fild(col[j], row[i], color, null);
            }
        }
    }

    public static Board getBoard() {
        if (board) {
            return board;
        } else {
            return new Board();
        }
    }

    public void goFigure(String fcol, int frow, String goCol, int goRow) {
        Fild fild = Filds[row][(int)fcol - 96]; 
        Fild copy;
        if (fild.getFigure().canGo(goCol, goRow)) {
             if(!fild.getFigure() || (fild.getFigure().getColor() != filds[goRow][goCol].getFigure().getColor())) {
                filds[goRow][goCol].getFigure() = null;
                filds[goRow][goCol].setFigure((Fild)fild.getFigure().clone());
                fild.setFigure(null);
                return ;
            }
       
        } else {
            System.out.println("Invalid step!!!");
        }
    }

    public void setFigure(Figure figure, char col, int row) {
        find[row][(int)col - 96].setFigure(figure); 
    }
}
