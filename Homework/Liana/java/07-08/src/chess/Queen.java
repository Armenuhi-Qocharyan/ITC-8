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
public class Queen implements Figure {

    private String color;
    private int row;
    private int column;
    private char symbol;

    public Queen(String color, int row, int column, char symbol) {
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
    public boolean isValidStep(int newRow, int newColumn, Figure[][] figures) {
        if (this.color.equals(figures[newRow][newColumn].getColor()) || (this.row == newRow && this.column == newColumn)) {
            return false;
        }
        if (newRow - this.row == newColumn - this.column) {
            for (int i = this.row; i < newRow; ++i) {
                for (int j = this.column; j < newColumn; ++j) {
                    if (figures[i][j] != null) {
                        return false;
                    }
                }
            }
            return true;
        }

        if (newRow == this.row) {
            
            for (int i = this.column; i < newColumn; ++i) {
                
                if (figures[this.row][i] != null) {
                    return false;
                }
            }
            return true;
        }

        if (newColumn == this.column) {
            for (int i = this.row; i < newRow; ++i) {
                if (figures[i][this.column] != null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
