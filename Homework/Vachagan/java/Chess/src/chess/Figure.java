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
abstract public class Figure {

    /**
     * 
     * @param row
     * @param column
     * @param figures
     * @return
     */
    
    protected int row;
    protected int col;
    protected String path;
    protected String color;

    
    public Figure(int row, int col, String color) {
        this.col = col;
        this.row = row;
        this.color = color;
    }
    
    public int getRow() {
        return this.row;
    }
    
    public int getCol() {
        return this.col;
    }
    
    public String getPath() {
        return this.path;
    }
    
    public String getColor() {
        return this.color;
    }
    
    public void setRow(int row) {
        this.row = row;
    }
    
    public void setCol(int col) {
        this.col = col;
    }
    
    abstract public boolean Step(int newRow, int newColumn);

    // public boolean isValidStep (int row, int column, Figure[][] figures);
    // public String getColor();
}
