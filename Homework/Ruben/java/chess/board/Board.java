package board;
import figurs.*;

public class Board {
    private Piece[][] board;

    public Board(int rows, int cols) {
        board = new Piece[rows][cols];
    }

    public void setPiece(Piece piece, int row, int col) {
        this.board[row][col] = piece;
    }

    public void removePiece(int row, int col) {
        this.board[row][col] = null;
    }

    public Piece getPiece(int row, int col) {
        return this.board[row][col];
    }

    public void printBoard() {
        for (int i = -1; i < 8; ++i) {
	    if(i != -1) {
	        System.out.print("  " + i + "  ");
	    } else {
		System.out.print("     ");
	    }
            for (int j = 0; j < 8; ++j) {
		if(i == -1) {
		    System.out.print(" " + j + " ");
		} else {
            	if (board[i][j] != null) {
            		System.out.print(board[i][j].getType() + " ");
            	} else {
            		System.out.print(" _ ");
            	}
		}
            }
            System.out.println("\n");
        }
    }
}

