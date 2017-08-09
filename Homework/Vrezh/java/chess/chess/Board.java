package chess;
import java.util.Scanner;

public class Board {
    private Fild[][] filds;   
    private static Board board;

    private Board() {
        initBoard();
    }

        
    private void initBoard() {
        Style.Color color = Style.Color.WHITE;       
        char[] col = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        int[] row = {1, 2, 3, 4, 5, 6, 7, 8};
        filds = new Fild[8][8];

        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                filds[i][j]  = new Fild(col[j], row[i], color, null);
                color = color == Style.Color.WHITE ? Style.Color.BLACK : Style.Color.WHITE;
            }
            color = color == Style.Color.WHITE ? Style.Color.BLACK : Style.Color.WHITE;
        }
        initFigures();
    }

    private void initFigures() {
        Figure figure;
        char[] col = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        Style.Color color = Style.Color.WHITE;  
        for (int j = 0, row = 1; j < 2; ++j) {     
            for (int i = 0; i < 8; ++i) {
                figure = new Pawn("PW", col[i], row, color);
                filds[row][i].setFigure(figure); 
            }
            color = Style.Color.BLACK;
            row = 6;
        }
        
                

    }

    public void startGame() {
        for (int i = 0; i < 8; ++i) {

            Scanner reader = new Scanner(System.in);
            
            System.out.println("Yntrir xaxaqary");
            char fCol = reader.next().charAt(0);
            int fRow = reader.nextInt(); 
            
            System.out.println("Yntrir qayly");
            char goCol = reader.next().charAt(0);
            int goRow = reader.nextInt(); 
                
            System.out.println((char)((int)fCol - 1));
            System.out.println(8 - fRow);   
             System.out.println((char)((int)goCol - 1));
            System.out.println(8 - goRow);   

            goFigure((char)((int)fCol - 1), 8 - fRow, (char)((int)goCol -1), 8 - goRow);
            showBoard();
        }
    }


    public static Board getBoard() {
        if (null != board) {
            return board;
        } else {
            return new Board();
        }
    }

    public void setFigure(Figure figure) {
        filds[figure.getRow()][(int)figure.getColumn() - 96].setFigure(figure); 
    }

    public void goFigure(char fC, int fRow, char goC, int goRow) {
        int fCol =  (int)fC - 96;
        int goCol = (int)goC - 96; 
        Fild fFild = filds[fRow][fCol];
        Fild goFild = filds[goRow][goCol];
        Fild copy;
        if (fFild.getFigure().canGo(goC, goRow) && fFild.getFigure() != null) {
            if(null == goFild.getFigure() || (goFild.getFigure().getColor() != fFild.getFigure().getColor())) {
                for (int i = fRow; i < goRow - 1; ++i) {
                    for (int j = fCol; j < (int)goCol - 96 - 1; ++j) {
                        if (filds[i][j] != null) {
                            System.out.println("Invalid step!!!");
                            return ;
                        }
                    }
                } 

                goFild.setFigure(null);
                filds[goRow][goCol].setFigure(fFild.getFigure());//(Figure)(fild.getFigure()).clone());
                fFild.setFigure(null);
                return ;
            }
       
        } else {
            System.out.println("Invalid step!!!");
        }
    }

    public void showBoard() {
        System.out.print("\t");
        for (int i = 0; i < 8; ++i) {
            System.out.print("\t" + filds[0][i].getColumn());
        }

        for (int i = 0; i < 8; ++i) {
            System.out.print("\n\n\t" + (9 - filds[i][0].getRow()));
            for (int j = 0; j < 8; ++j) {
                if (null == filds[i][j].figure) {
                    System.out.print((filds[i][j].getColor() == Style.Color.WHITE ? "\t." : "\t*"));
                } else {
                      System.out.print("\t" + (filds[i][j].figure.getColor() == Style.Color.WHITE ? "w" : "b") + filds[i][j].figure.getName().charAt(0));
                }
                
            }
        }
        System.out.println();
    }

}
