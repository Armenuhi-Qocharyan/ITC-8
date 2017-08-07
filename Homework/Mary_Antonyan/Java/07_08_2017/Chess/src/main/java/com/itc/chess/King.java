package com.itc.chess;
import java.awt.Point;

/**
 * This class represents the king(թագավոր) chess figure
 *
 * @author mary
 */
public class King extends Figure {
    /**
     * Creates a king object
     * 
     * @param figure figure name
     * @param color figure color
     * @param position figure current position
     */
    public King(Chessman figure, Color color, Point position) {
        super(figure, color, position);
    }
    
    /**
     * 
     * @param position new position
     * @return can the object step to new position or not
     */
    @Override
    public boolean step(Point position) {
        if (0 <= position.x && 8 > position.x && 0 <= position.y && 8 > position.y) { 
            if (((position.x == this.position.x - 1 || position.x == this.position.x + 1 || position.x == this.position.x) && 
            (position.y == this.position.x - 1 || position.y == this.position.x + 1 || position.y == this.position.y) && 
            Board.board[position.x][position.y] == null || Board.board[position.x][position.y].getColor() != color)) {
                System.out.println("Move to [" + position.x + " , " + position.y + "]");
                int tmpX = this.position.x;
                int tmpY = this.position.y;
                Board.board[position.x][position.y] = new King(figure, color, position);
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