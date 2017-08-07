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
abstract public class Figure {
    protected Point position; // Figure position on board
    protected String color; // Figure color must be "black" or "white"
    /**
     *
     * @return Figure position
     */
    public Point getPosition() {
        return this.position;
    }
    /**
     *
     * @return Figure color
     */
    public String getColor() {
        return this.color;
    }
    
    /**
     *
     * @param newPosition
     * @return Check if new position is valid
     */
    abstract public boolean checkStep(Point newPosition);

    /**
     *
     * @param newPosition 
     * Move Figure to new position;
     */
    public void move(Point newPosition) {
        this.position = newPosition;
    }
}
