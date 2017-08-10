import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ChessBoard extends JFrame {
    public static final int squareCount = 64;
    public int x = - 1;
    public int y = - 1;
    
    public ChessBoard(String title) {
        SwingUtilities.updateComponentTreeUI(this);
        Color blackColor = Color.GRAY;
        Color whiteColor = Color.WHITE;
        JButton[][] chessButtons = new JButton[8][8];
            try {
            Image horse = ImageIO.read(this.getClass().getResource("images/horse.png"));
            Image pown = ImageIO.read(this.getClass().getResource("images/pown.png"));
            Image queen = ImageIO.read(this.getClass().getResource("images/queen.png"));
            Image bishop = ImageIO.read(this.getClass().getResource("images/bishop.png"));
            Image rook = ImageIO.read(this.getClass().getResource("images/rook.png"));
            Image king = ImageIO.read(this.getClass().getResource("images/king.png"));
            horse = horse.getScaledInstance(50 , 50, java.awt.Image.SCALE_SMOOTH);
            pown = pown.getScaledInstance(50 , 50, java.awt.Image.SCALE_SMOOTH);
            queen = queen.getScaledInstance(50 , 50, java.awt.Image.SCALE_SMOOTH);
            bishop = bishop.getScaledInstance(50 , 50, java.awt.Image.SCALE_SMOOTH);
            rook = rook.getScaledInstance(50 , 50, java.awt.Image.SCALE_SMOOTH);
            king = king.getScaledInstance(50 , 50, java.awt.Image.SCALE_SMOOTH);
            for (int i = 0; i < 8; i++) {
                for(int j = 0; j < 8; ++j) {
                    if ( (i == 0 && j == 1) || (i == 0 && j == 6) || (i == 7 && j ==1) || (i == 7 &&  j == 6)) {
                        chessButtons[i][j] = new JButton(new ImageIcon(horse));
                    } else if ((i == 0 && j == 2) || (i == 0 && j == 5) || (i == 7 && j ==2) || (i == 7 &&  j == 5)) {
                        chessButtons[i][j] = new JButton( new ImageIcon(bishop));
                    } else if ((i == 0 && j == 0) || (i == 0 && j == 7) || (i == 7 && j ==0) || (i == 7 &&  j == 7)) {
                        chessButtons[i][j] = new JButton(new ImageIcon(rook));
                    } else if ((i == 0 && j == 4) || (i == 7 &&  j == 4)) {
                        chessButtons[i][j] = new JButton(new ImageIcon(queen));
                    } else if ((i == 0 && j == 3) || (i == 7 &&  j == 3)) {
                        chessButtons[i][j] = new JButton(new ImageIcon(king));
                    } else if (i == 1 || i == 6){
                        chessButtons[i][j] = new JButton(new ImageIcon(pown));
                    } else {
                        chessButtons[i][j] = new JButton("");
                    }

                    if ( (i + j) % 2 == 0) { 
                        chessButtons[i][j].setBackground(blackColor);
                    } else {
                        chessButtons[i][j].setBackground(whiteColor);
                    }
                    add(chessButtons[i][j]); 
                    chessButtons[i][j].addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            setVisible(false);
                            if (x == -1 && y == -1 ) {
                                x = ((JButton)e.getSource()).getX();
                                y = ((JButton)e.getSource()).getY();
                                System.out.println(((JButton)e.getSource()).getX() / 100);
                                System.out.println(((JButton)e.getSource()).getY() / 89);
                                setVisible(true);
                            } else {
                                //chessButtons[((JButton)e.getSource()).getX() / 100][((JButton)e.getSource()).getY() / 89].setIcon(new ImageIcon(pown));
                                System.out.println(((JButton)e.getSource()).getX() / 100);
                                System.out.println(((JButton)e.getSource()).getY() / 89);

                                x = -1;
                                y = -1;
                                getContentPane().repaint();
                                setVisible(true);
                            }
                        }
                    });
                }
            }
        } catch (IOException ex) {
            System.out.println("IO exception.");
        }
        this.setTitle(title); 
        this.setLayout(new GridLayout(8, 8)); // GridLayout will arrange elements in Grid Manager 8 X 8
        this.setSize(800, 800); // Size of the chess board
        this.setVisible(true);
    }

    public static void main(String[] args) {
        String title = "My Chess Board";
        ChessBoard chessBoard = new ChessBoard(title); // Creating the instance of chess board
    }
}
