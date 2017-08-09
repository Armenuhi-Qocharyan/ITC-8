package testgraphicui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author student
 */
public class ChessFrame extends JFrame implements ActionListener {
    private final JButton[][] chessBoardSquares = new JButton[8][8];
    private static boolean selected = true;
    public enum EPieceTipe {
        EPieceTipe_King,
        EPieceTipe_Queen,
        EPieceTipe_Pawn,
        EPieceTipe_Knight,
        EPieceTipe_Bishop,
        EPieceTipe_Rook
    }
    
    public ChessFrame() {
        JPanel chessBoard = new JPanel(new GridLayout(8, 8));
        for (int i = 0; i < chessBoardSquares.length; ++i) {
            for (int j = 0; j < chessBoardSquares[i].length; ++j) {
                JButton b = new JButton();
                b.addActionListener(this);
                b.putClientProperty("row", i);
                b.putClientProperty("col", j);
                b.setOpaque(true);
                b.setPreferredSize(new Dimension(70, 70));
                if ((j % 2 == 1 && i % 2 == 1) || (j % 2 == 0 && i % 2 == 0)) {
                    b.setBackground(Color.white);
                } else {
                    b.setBackground(Color.black);
                }
                chessBoardSquares[i][j] = b;
                chessBoard.add(chessBoardSquares[i][j]);
            }
        }
        this.add(chessBoard);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton)e.getSource();
        if (selected) {
            selected = false;
        } else {
            this.requestFocus();
            selected = true;
        }
    }   
}