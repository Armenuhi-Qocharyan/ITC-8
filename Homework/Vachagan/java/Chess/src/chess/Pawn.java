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
public class Pawn extends Figure {
      public Pawn (int row, int col, String color) {
        super(row,col,color);
        if(color == "white") {
            this.path = "./chesspng/pawnw.png";
        } else {
            this.path = "./chesspng/pawnb.png";
        }

    }
    
    public void Info() {
        System.out.println("row= " + this.row + " col= " + this.col + " path=" + this.path );
    }

    @Override
    public boolean Step(int newRow, int newColumn) {
        
        if(this.color == "white" && ((this.row - newRow) <= 1) && (this.col == newColumn) ) {
            return true;
        } 
        
        if(this.color == "black" && ((newRow - this.row) <= 1) && (this.col == newColumn) ) {
            return true;
        } 
        
        return false;
    }
}
