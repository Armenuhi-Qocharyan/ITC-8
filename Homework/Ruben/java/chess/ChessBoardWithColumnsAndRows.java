import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.awt.image.BufferedImage;
 
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import figurs.*;
 
public class ChessBoardWithColumnsAndRows implements ActionListener{
 
    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JButton[][] chessBoardSquares = new JButton[8][8];
    private JPanel chessBoard;
    private final JLabel message = new JLabel(
            "Chess Champ is ready to play!");
    private static final String COLS = "ABCDEFGH";
 
    ChessBoardWithColumnsAndRows() {
        initializeGui();
    }
 
    public final void initializeGui() {
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
 
        chessBoard = new JPanel(new GridLayout(0, 9));
        chessBoard.setBorder(new LineBorder(Color.BLACK));
        gui.add(chessBoard);
 
        // create the chess board squares
        Insets buttonMargin = new Insets(0,0,0,0);
        for (int ii = 0; ii < chessBoardSquares.length; ii++) {
            for (int jj = 0; jj < chessBoardSquares[ii].length; jj++) {
                JButton b = new JButton();
                b.addActionListener(this);
                b.putClientProperty("row", ii);
                b.putClientProperty("col", jj);
		Piece f = new Pawn("p");
		b.putClientProperty("figure",f);
                if ((jj % 2 == 1 && ii % 2 == 1)
                        || (jj % 2 == 0 && ii % 2 == 0)) {
                    b.setBackground(Color.WHITE);
                } else {
                    b.setBackground(Color.BLACK);
                }
                chessBoardSquares[jj][ii] = b;
            }
        }
 
        //fill the chess board
        chessBoard.add(new JLabel(""));
        // fill the top row
        for (int ii = 0; ii < 8; ii++) {
            chessBoard.add(
                    new JLabel(COLS.substring(ii, ii + 1),
                    SwingConstants.CENTER));
        }
        // fill the black non-pawn piece row
        for (int ii = 0; ii < 8; ii++) {
            for (int jj = 0; jj < 8; jj++) {
                switch (jj) {
                    case 0:
                        chessBoard.add(new JLabel("" + (ii + 1),
                                SwingConstants.CENTER));
                    default:
                        chessBoard.add(chessBoardSquares[jj][ii]);
                }
            }
        }
    }
 
	boolean first = true;
	int row=0,col=0,newRow, newCol;
	Piece f = null;
    @Override
    public void actionPerformed(ActionEvent e){
	JButton b = (JButton)e.getSource();
	if(first) {
	row = (int)(b.getClientProperty("row"));
	col = (int)(b.getClientProperty("col"));
	first = false;
    	} else {
	    newRow = (int)(b.getClientProperty("row"));
	    newCol = (int)(b.getClientProperty("col"));
	    f = (Piece)(b.getClientProperty("figure"));
	System.out.println(row);
	System.out.println(col);
	f.step(row,col,newRow,newCol);
	first = true;
	}
    }
    public final JComponent getChessBoard() {
        return chessBoard;
    }
 
    public final JComponent getGui() {
        return gui;
    }
}
