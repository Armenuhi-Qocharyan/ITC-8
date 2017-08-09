package board;
import figurs.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.*;

public class Board extends JFrame implements ActionListener{
    private final JButton[][] chessBox = new JButton[8][8]; 
    private Piece[][] board;

    public Board(int rows, int cols) {
        //board = new Piece[rows][cols];
	JPanel chessBox = new JPanel(new GridLayout(8, 8));
	for (int i = 0; i < chessBox.length; ++i){
	    for(int j = 0; j < chessBox.length; ++j) {
		JButton b = new JButton();
		b.addActionListener(this);
		b.putClientProperty("row", i);
		b.putClientProperty("col", j);
		b.setOpaque(true);
		b.setPreferreqSize(new 58, 58);
		if((j%2 == 1 && i%2 == 1) || (j%2 == 0 && i%2 == 0)){
		    b.setBackground(color.WHITE)
		    System.out.println("white");
		} else [
		    b.setBackground(color.BLACK)
		    System.out.println("black");
		}
		chessBox[i][j] == b;
		Board.add(chessBox[i][j]);
		
	    }
	}
	this.add()
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

