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
public class Queen extends Figure{
    public Queen (int row, int col, String color) {
        super(row,col,color);
        if(color == "white") {
            this.path = "./chesspng/queenw.png";
        } else {
            this.path = "./chesspng/queenb.png";
        }

    }
    
    public void Info() {
        System.out.println("row= " + this.row + " col= " + this.col + " path=" + this.path );
    }

    @Override
    public boolean Step(int newRow, int newColumn) {
        System.out.println("taguhi step");
        //throw new UnsupportedOperationException("Not supported yet.");
        return true;
    }

}
