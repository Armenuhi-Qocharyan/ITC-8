/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Integer;

/**
 *
 * @author nelli
 */
public class ChessBoard {
    private final Figure[][] board;

    public ChessBoard() {
        this.board = new Figure[8][8];
    }
     /**
      * 
      * @param position
      * @param color
      * @param type 
      * 
      * Insert on board figure by type
      */
    public void insertBoard(Point position, String color, String type) {
        int i = position.x;
        int j = position.y;
        if (i < 8 && i >= 0 && j < 8 && j >= 0) {
            if (color == "white" || color == "black") {
                switch (type) { 
                    case "rook":
                        board[i][j] = new Rook(position, color);
                        System.out.println("Inserted figure rook");
                        break;
                    case "poun":
                        board[i][j] = new Poun(position, color);
                        System.out.println("Inserted figure poun");
                        break;
                    case "hourse":
                        board[i][j] = new Hourse(position, color);
                        System.out.println("Inserted figure hourse");
                        break;
                    case "king":
                        board[i][j] = new King(position, color);
                        System.out.println("Inserted figure king");
                        break;
                    case "queen":
                        board[i][j] = new Queen(position, color);
                        System.out.println("Inserted figure queen");
                        break;
                    case "soldier":
                        board[i][j] = new Soldier(position, color);
                        System.out.println("Inserted figure soldier");
                        break;
                    default:
                        System.out.println("Undefined figure type " + type);
                }
                
            } else {
                System.out.println("Invalid color !!! " + color + " color must be  black or white");
            }
        } else {
            System.out.println("Invalid coordinates !!! " + i + " " + j);
        }
        
    }
    
    /**
     * 
     * @param position
     * @return if there is figure on board in position return true  
     */
    public boolean isFigure(Point position) {
        int i = position.x;
        int j = position.y;
        
        if (board[i][j] != null) {
            return true;
        }
        return false;
    }
    
    /**
     * 
     * @param filename
     * Init chess board from file. In file each line must be in this format [x],[y],[color],[type],
     */
    
    public void initFiguresFromFile(String filename) {
         try {
	    File file = new File(filename);
	    FileReader fileReader = new FileReader(file);
	    BufferedReader br = new BufferedReader(fileReader);
	    String line;
            int index = 0;
            Point position;
            String color;
            String type;
            int x;
            int y;
	    while ((line = br.readLine()) != null) {
	        String[] arguments = (line.toString()).split(",");
	        x = Integer.parseInt(arguments[0]);
                y = Integer.parseInt(arguments[1]);
                position = new Point(x, y);
                color = arguments[2];
                type = arguments[3];
                insertBoard(position, color, type);
	        ++index;
	    }
            
	} catch (IOException e) {
	    System.out.println("IO exception");
        }
    }
    /**
     * 
     * @param first
     * @param second
     * @return if first can move to second field
     */
    private boolean isValidStep(Figure first, Figure second) {
        if (first.getColor() == second.getColor()) {
            return false;
        }
        if (first == null && second == null) {
            return false;
        }
        return true;
    }
    /**
      * 
      * @param first
      * @param second 
      */
    public void move(Figure first, Figure second) {
        if (isValidStep(first,second)) {
            second = first;
            first = null;
        } else {
            System.out.println("Can not move figure ");
        }
    }
    
    
    public Figure getFigure(Point position) {
        return board[position.x][position.y];
    }
    
}
