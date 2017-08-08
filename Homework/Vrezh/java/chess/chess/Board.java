package chess;

public class Board {
    private Fild[][] filds;   
    private static Board board;

    private Board() {
        createBoard(); 
    }

    private void createBoard() {
        Style.Color color = Style.Color.WHITE;
        char[] col = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        char[] row = {1, 2, 3, 4, 5, 6, 7, 8};
        filds = new Fild[8][8];
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                filds[i][j]  = new Fild(col[j], row[i], color, null);
            }
        }
    }

    public static Board getBoard() {
        if (null != board) {
            return board;
        } else {
            return new Board();
        }
    }

    public void goFigure(char fCol, int fRow, char goCol, int goRow) {
        Fild fild = filds[fRow][(int)fCol - 96]; 
        Fild copy;
        if (fild.getFigure().canGo(goCol, goRow)) {
             if(null == fild.getFigure() || (fild.getFigure().getColor() != filds[goRow][goCol].getFigure().getColor())) {
                filds[goRow][goCol].setFigure(null);
                try {
                    filds[goRow][goCol].setFigure((Figure)(fild.getFigure()).clone());
                } catch (CloneNotSupportedException err) {
                    System.out.println(err);
                }
                fild.setFigure(null);
                return ;
            }
       
        } else {
            System.out.println("Invalid step!!!");
        }
    }

    public void setFigure(Figure figure, char col, int row) {
        filds[row - 1][(int)col - 96].setFigure(figure); 
    }
}
