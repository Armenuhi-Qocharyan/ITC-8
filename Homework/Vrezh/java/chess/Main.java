import java.util.Scanner;
import chess.Board;
import chess.Figure;
import chess.Queen;
import chess.Style;
import chess.Pawn;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
 
        Board board = Board.getBoard();
        board.showBoard();
        Figure figure = new Queen("QN", 'c', 1 , Style.Color.BLACK);
        board.setFigure(figure);
        Figure figure1 = new Queen("QN", 'c', 2, Style.Color.BLACK);
        board.setFigure(figure1);
        //board.showBoard();
        //board.goFigure('c', 1, 'e', 7);
        
        board.startGame();
    }

}

