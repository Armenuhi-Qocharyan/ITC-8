package com.itc.chess;
import java.awt.Point;

/**
 * This class represents the chess figure.
 * 
 * All objects of this type have the following properties:
 * - figure
 * - color
 * - position
 * @author mary
 */
abstract public class Figure {
    public enum Chessman {
        king, queen, knight, rook, bishop, pawn
    };

    public enum Color {
        white, black
    };
    
    protected Chessman figure;
    protected Color color;
    protected Point position;
    
    /**
     * Creates a chess figure object
     * 
     * @param figure figure name
     * @param color figure color
     * @param position figure current position
     */
    public Figure(Chessman figure, Color color, Point position) {
        this.figure = figure;
        this.color = color;
        this.position = position;
    }

    /**
     * 
     * @return figure name
     */
    public Chessman getFigure() {
        return figure;
    }

    /**
     * 
     * @param figure figure name
     */
    public void setFigure(Chessman figure) {
        this.figure = figure;
    }

    /**
     * 
     * @return figure color
     */
    public Color getColor() {
        return color;
    }

    /**
     * 
     * @param color figure color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * 
     * @return figure current position
     */
    public Point getPosition() {
        return position;
    }

    /**
     * 
     * @param position figure position
     */
    public void setPosition(Point position) {
        this.position = position;
    }

    /**
     * 
     * @param position figure new position
     * @return can figure step to new position or not
     */
    abstract public boolean step(Point position);
}