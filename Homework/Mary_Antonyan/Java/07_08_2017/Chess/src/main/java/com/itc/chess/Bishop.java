package com.itc.chess;
import java.awt.Point;

/**
 * This class represents the bishop(փիղ) chess figure
 * 
 * @author mary
 */
public class Bishop extends Figure {
    /**
     * Creates a bishop object
     * 
     * @param figure figure name
     * @param color figure color
     * @param position figure current position
     */
    public Bishop(Chessman figure, Color color, Point position) {
        super(figure, color, position);
    }
    
    /**
     * 
     * @param position new position
     * @return can the object step to new position or not
     */
    @Override
    public boolean step(Point position) {
        if (0 <= position.x && 8 > position.x && 0 <= position.y && 8 > position.x) { 
            if (Math.abs(position.x - position.y) == Math.abs(this.position.x - this.position.y) && 
            (Board.board[position.x][position.y] == null || 
            Board.board[position.x][position.y].getColor() != color)) {
                System.out.println("Move to [" + position.x + " , " + position.y + "]");
                int tmpX = this.position.x;
                int tmpY = this.position.y;
                Board.board[position.x][position.y] = new Bishop(figure, color, position);
                Board.board[tmpX][tmpY] = null;
                return true;
            } else {
                System.out.println("Can't move to [" + position.x + " , " + position.y + "]");
            }
        } else {
            System.out.println("Out of board");
        }        
        return false;
    }
}