package chess;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.IOException;

public class ChessFrame extends JFrame implements ActionListener {
    private final JButton[][] boardField = new JButton[8][8];
    private static boolean selected = false;

    public enum EPieceTipe {
        EPieceTipe_King,
        EPieceTipe_Queen,
        EPieceTipe_Pawn,   // Zinvor
        EPieceTipe_Rook,   // Nav
        EPieceTipe_Knigth, // Dzi
        EPieceTipe_Bishop, // Pix
    }

    public ChessFrame() {
        JPanel board = new JPanel(new GridLayout(8,8));
        for (int i = 0; i < boardField.length; ++i) {
            for (int j = 0; j < boardField[i].length; ++j) {
                JButton b = new JButton();
                b.addActionListener(this);
                b.putClientProperty("row", i);
                b.putClientProperty("col", j);
                b.setOpaque(true);
                b.setPreferredSize(new Dimension(100,100));
                if ((j % 2 == 1 && i % 2 == 1) || (j % 2 == 0 && i % 2 == 0)) {
                    b.setBackground(Color.WHITE);
                } else {
                    b.setBackground(Color.BLACK);
                }
                boardField[i][j] = b;
                board.add(boardField[i][j]);
            }
        }
        this.add(board);
        initFigure();

    }

    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton)e.getSource();
        System.out.println("row: " + b.getClientProperty("row") + "\ncolumn: " +  b.getClientProperty("col"));
        if (selected) {
            selected = false;
        } else {
            //b.setBackground(Color.GREEN);
            //this.requestFocuse();
            selected = true;
        }
    }

    public void initFigure() {
        try { 
            String[] black = {"image/rookB.png", "image/knight1B.jpg", "image/bishopB.png", "image/queenB.jpg", "image/kingB.png", "image/bishopB.png", "image/knight1B.jpg", "image/rookB.png"};
            String[] white = {"image/rookW.png", "image/knightW.png", "image/bishop1W.png", "image/queenW.jpg", "image/king1W.png", "image/bishop1W.png", "image/knightW.png", "image/rookW.png"};

            for (int i = 0, j = 0; j < 8; ++j) {
                Image img = ImageIO.read(getClass().getResource(black[j]));
                img = img.getScaledInstance( 50, 50,  java.awt.Image.SCALE_SMOOTH );
                boardField[i][j].setIcon(new ImageIcon(img));
                //boardField[i][j].setText(black[j]);
            }
       
   
            for (int i = 7, j = 0, k = 0; j < 8; ++j) {
                Image img = ImageIO.read(getClass().getResource(white[j]));
                img = img.getScaledInstance( 50, 50,  java.awt.Image.SCALE_SMOOTH );
                boardField[i][j].setIcon(new ImageIcon(img));
                //boardField[i][j].setText(white[j]);
            }

            for (int i = 0; 8 > i; i++) {
                Image img = ImageIO.read(getClass().getResource("image/pawnB.png"));
                img = img.getScaledInstance( 50, 50,  java.awt.Image.SCALE_SMOOTH );
                boardField[1][i].setIcon(new ImageIcon(img));
                //boardField[1][i].setText("pawn");
            }

            for (int i = 0; 8 > i; i++) {
                Image img = ImageIO.read(getClass().getResource("image/pawn1W.jpg"));
                img = img.getScaledInstance( 50, 50,  java.awt.Image.SCALE_SMOOTH );
                boardField[6][i].setIcon(new ImageIcon(img));
                //boardField[6][i].setText("pawn");
            }
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}
