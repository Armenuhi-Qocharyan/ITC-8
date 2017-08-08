import chess.Board;
import chess.Figure;
import chess.Queen;
import chess.Style;

public class Main {

    public static void main(String[] args) {
        Board board = Board.getBoard();
        Figure figure = new Queen("QN", 'd', 8, Style.Color.BLACK);
        board.setFigure(figure, 'd', 8);
    }

}

