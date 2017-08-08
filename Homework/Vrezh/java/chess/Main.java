import chess.Board;
import chess.Figure;
import chess.Queen;
import chess.Style;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        Figure figure = new Queen('d', 8, Color.BLACK, "QN");
        board.setFigure(figure);
    }
}

