import java.util.InputMismatchException;
import java.util.Scanner;
import figurs.*;
import board.*;

public class Chess {

    public static void main(String[] args) {
		
        Board b = new Board(8,8);
        for(int i = 0; i < 8; ++i) {
            b.setPiece(new Pawn(" p"), 1, i);
            b.setPiece(new Pawn(" P"), 6, i);
        }
        for(int i = 0; i < 8; i += 7) {
	    b.setPiece(new Rook(" r"), 0, i);
	    b.setPiece(new Rook(" R"), 7, i);
	}
        for(int i = 1; i < 8; i += 5) {
	    b.setPiece(new Knight("kn"), 0, i);
	    b.setPiece(new Knight("KN"), 7, i);
	}
        for(int i = 2; i < 8; i += 3) {
	    b.setPiece(new Bishop(" b"), 0, i);
	    b.setPiece(new Bishop(" B"), 7, i);
	}
	b.setPiece(new King(" k"), 0, 3);
	b.setPiece(new Queen(" Q"), 7, 3);
	b.setPiece(new Queen(" q"), 0, 4);
	b.setPiece(new King(" K"), 7, 4);
        b.printBoard();

        while(true) {
            Scanner scan = new Scanner(System.in);
            int row = 0, col = 0, newRow = 0, newCol = 0;
            System.out.print("\n\nrow = ");
            row = scan.nextInt();
            System.out.print("col = ");
            col = scan.nextInt(); 
            System.out.print("newRow = ");
            newRow = scan.nextInt();
            System.out.print("newCol = ");
            newCol = scan.nextInt();
	    if(row < 8 && row >= 0 && col < 8 && col >= 0) {
		if(b.getPiece(row, col) != null) {
	    	    b.getPiece(row, col).step(b,row,col,newRow,newCol);
            	    b.printBoard();
		} else {
		    System.out.println("Not piece \n");
		}
	    } else {
		System.out.println("Wrong location \n");
	    }
        }
    }
}
