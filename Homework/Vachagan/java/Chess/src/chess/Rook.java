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
public class Rook extends Figure {
        public Rook (int row, int col, String color) {
        super(row,col,color);
        if(color == "white") {
            this.path = "./chesspng/rookw.png";
        } else {
            this.path = "./chesspng/rookb.png";
        }

    }
    
    public void Info() {
        System.out.println("row= " + this.row + " col= " + this.col + " path=" + this.path );
    }

    @Override
    public boolean Step(int newRow, int newColumn) {
        System.out.println("navak step");
        if((Math.abs(newRow - this.row) >= 0) && (newColumn == this.col)) {
            return true;
        }
        if((Math.abs(newColumn - this.col) >= 0) && (newRow == this.row)) {
            return true;
        }
        //throw new UnsupportedOperationException("Not supported yet.");
        return false;
    }
}
