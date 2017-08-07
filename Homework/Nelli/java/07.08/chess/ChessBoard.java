/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.awt.Point;

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
        switch (type) { 
            case "rook":
                board[i][j] = new Rook(position, color);
                break;
            case "poun":
                board[i][j] = new Poun(position, color);
                break;
            case "hourse":
                board[i][j] = new Hourse(position, color);
                break;
            case "king":
                board[i][j] = new King(position, color);
                break;
            case "queen":
                board[i][j] = new Queen(position, color);
                break;
            case "soldier":
                board[i][j] = new Soldier(position, color);
                break;
            default:
                System.out.println("Undefined figure type " + type);
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
    
    
}
