
public class Board {
    private Piece[][] board;

    public Board(int rows, int cols) {
        board = new Piece[rows][cols];
    }

    public boolean setPiece(Piece piece, int row, int col) {
        if (this.board[row][col] == null) {
            this.board[row][col] = piece;
            return true;
        } else {
            return false;
        }
    }

    public void removePiece(int row, int col) {
        this.board[row][col] = null;
    }

    public Piece getPiece(int row, int col) {
        return this.board[row][col];
    }

    public void printBoard() {
        for (Piece[] row : board) {
            for (Piece piece : row) {
            	if (piece != null) {
            		System.out.print(piece.getType() + " ");
            	} else {
            		System.out.print(" _ ");
            	}
            }
            System.out.println("\n");
        }
    }
}

