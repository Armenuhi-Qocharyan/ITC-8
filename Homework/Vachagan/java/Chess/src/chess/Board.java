/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author student
 */
public class Board extends JFrame implements ActionListener {

    private JButton[][] chessBoard = new JButton[8][8];
    private boolean WhiteOrBlack = true;
    private boolean selected = true;
    private ArrayList < Figure > figure = new ArrayList< Figure >();
    private Figure myFigure;

    public Board() {
        JPanel panel = new JPanel(new GridLayout(8, 8));
        panel.setSize(800, 800);
        for (int i = 0; i < chessBoard.length; ++i) {
            for (int j = 0; j < chessBoard[i].length; ++j) {
                JButton btn = new JButton();
                btn.addActionListener(this);
                btn.putClientProperty("row", i);
                btn.putClientProperty("col", j);
                btn.setOpaque(true);
                btn.setPreferredSize(new Dimension(70, 70));

                if (WhiteOrBlack) {
                    btn.setBackground(Color.BLACK);
                    WhiteOrBlack = false;
                    System.out.print("Black");
                } else {
                    btn.setBackground(Color.WHITE);
                    WhiteOrBlack = true;
                    System.out.print("white");
                }
                chessBoard[i][j] = btn;
                panel.add(chessBoard[i][j]);
            }
            System.out.println();
            WhiteOrBlack = !WhiteOrBlack;
        }
        this.add(panel);
    }

    
    public void Game() throws IOException {
        
        this.figure.add(new King(7,3,"white"));
        this.figure.add(new Queen(7,4,"white"));
        this.figure.add(new Bishop(7,2,"white"));       
        this.figure.add(new Bishop(7,5,"white"));
        this.figure.add(new Knight(7,1,"white"));     
        this.figure.add(new Knight(7,6,"white"));
        this.figure.add(new Rook(7,0,"white")); 
        this.figure.add(new Rook(7,7,"white"));

        for (int i = 0; i < 8; ++i ) {
            this.figure.add(new Pawn(6,i,"white"));   
        }
        
        this.figure.add(new King(0,3,"black"));
        this.figure.add(new Queen(0,4,"black"));
        this.figure.add(new Bishop(0,2,"black"));       
        this.figure.add(new Bishop(0,5,"black"));
        this.figure.add(new Knight(0,1,"black"));     
        this.figure.add(new Knight(0,6,"black"));
        this.figure.add(new Rook(0,0,"black")); 
        this.figure.add(new Rook(0,7,"black"));
        for (int i = 0; i < 8; ++i ) {
            this.figure.add(new Pawn(1,i,"black"));   
        }

       for(int i = 0; i < this.figure.size();++i) {
           Drow(this.figure.get(i));
       }
    }
    
    private Figure getFigure(int row, int col) {
        for (int i = 0; i < this.figure.size(); ++i) {
            if((this.figure.get(i).getRow() == row) && (this.figure.get(i).getCol() == col)) {
                return this.figure.get(i);
            }
        }  
        return null;
    }
    
    private void RemoveFigure(int row, int col) {
        if(this.figure.size() < 8) {
            System.out.println("xax@ verjacav");
        }
        for (int i = 0; i < this.figure.size(); ++i) {
            if((this.figure.get(i).getRow() == row) && (this.figure.get(i).getCol() == col)) {
                //this.figure.get(i);
                this.figure.remove(i);
            }
        }  
    }
    
    public void Drow(Figure figure) throws IOException {
        String path = figure.getPath();
        Image img = ImageIO.read(getClass().getResource(path));
        chessBoard[figure.getRow()][figure.getCol()].setIcon(new ImageIcon(img.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)));
        chessBoard[figure.getRow()][figure.getCol()].putClientProperty("figure", figure);
    }
    
    private void Delete(int row, int col) throws IOException {
        chessBoard[row][col].setIcon(null);
        chessBoard[row][col].putClientProperty("figure", null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        
        Figure newFigure = (Figure) btn.getClientProperty("figure");
        int row = Integer.parseInt(btn.getClientProperty("row").toString());
        int col = Integer.parseInt(btn.getClientProperty("col").toString());          

     //   System.out.println(btn.getText());
        if (selected) {
            if(btn.getIcon() != null){
               // myFigure = getFigure(row,col);
                myFigure = (Figure) btn.getClientProperty("figure");
                try {
                    Delete(myFigure.getRow(), myFigure.getCol());
                } catch (IOException ex) {
                    Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                }
                selected = false;
            } else {
                selected = true;
            }
        } else {
            try {
               // figure = btn.getClientProperty("figure");
               if(myFigure.Step(row, col)) {
                   if(btn.getIcon() != null && newFigure.getColor() == myFigure.getColor() ) {
                       Drow(myFigure);
                       selected = true;
                       return;
                   }
                   if(btn.getIcon() != null && (newFigure.getColor() != myFigure.getColor()) ) {
                       RemoveFigure(row,col);
                       myFigure.setCol(col);               
                       myFigure.setRow(row);
                       Drow(myFigure);
                       selected = true;
                       return;
                   }
                   
                    myFigure.setCol(col);               
                    myFigure.setRow(row);
                    Drow(myFigure);
               } else {
                    Drow(myFigure);
               }
              
            } catch (IOException ex) {
                Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.requestFocus();
            selected = true;
        }
    }
}
