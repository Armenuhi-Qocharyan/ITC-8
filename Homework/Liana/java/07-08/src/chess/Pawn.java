/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.util.ArrayList;

/**
 *
 * @author liana
 */
public class Pawn implements Figure {
    private String color;
    private int row;
    private int column;
    private char symbol;
    
    public Pawn (String color, int row, int column, char symbol) {
        this.color = color;
        this.column = column;
        this.row = row;
        this.symbol = symbol;
    }

    public String getColor() {
        return color;
    }

    public double getRow() {
        return row;
    }

    public double getColumn() {
        return column;
    }
    
     public char getSymbol() {
        return symbol;
    }
    
    @Override
    public boolean isValidStep(int newRow, int newColumn, Figure[][] figures) {
        if (figures[newRow][newColumn] != null) {
            if (this.color.equals(figures[newRow][newColumn].getColor()) || (this.row == newRow && this.column == newColumn)) {
                return false;
            } 
        }
       if (newRow > this.row + 2 || newRow < this.row - 2 || newRow == this.row || Math.abs(newColumn - this.column) > 1) {
           return false;
       } 
       if ((newRow == this.row + 2 && newColumn == this.column) || (newRow == this.row + 1 && newColumn == this.column)) {
           return figures[this.row + 1][this.column] == null;
       } 
       if ((newColumn == this.column + 1) && (newRow == this.row + 1)) {
            if (null != figures[newRow][newColumn]) {
                return true;
            } 
        }
       return false;
    }

   

    
}
