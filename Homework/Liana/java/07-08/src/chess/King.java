/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author liana
 */
public class King implements Figure {
    private String color;
    private int row;
    private int column;
    private char symbol;

    
    public King (String color, int row, int column, char symbol) {
        this.color = color;
        this.column = column;
        this.row = row;
        this.symbol = symbol;
    }

    @Override
    public String getColor() {
        return color;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public boolean isValidStep(int newRow, int newColumn,  Figure[][] figures) {
       if (figures[newRow][newColumn] != null) {
            if (this.color.equals(figures[newRow][newColumn].getColor()) || (this.row == newRow && this.column == newColumn)) {
                return false;
            } 
        }
        int dist = (int) (Math.pow((newRow - this.row), 2) + Math.pow((newColumn - this.column), 2));
        return (dist == 1 || dist == 2);
    }

    
}
