/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author vachagan
 */
public class King extends Figure {
    public King (int row, int col, String color) {
        super(row,col,color);
        if(color == "white") {
            this.path = "./chesspng/kingw.png";
        } else {
            this.path = "./chesspng/kingb.png";
        }

    }
    
    public void Info() {
        System.out.println("row= " + this.row + " col= " + this.col + " path=" + this.path );
    }

    @Override
    public boolean Step(int newRow, int newColumn) {
        // System.out.println("tagavor step");
        if((Math.abs(newRow - this.row) <= 1) && (Math.abs(newColumn - this.col) <= 1)) {
            return true;
        }
        //throw new UnsupportedOperationException("Not supported yet.");
        return false;
    }
}
