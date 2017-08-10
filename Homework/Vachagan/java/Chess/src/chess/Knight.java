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
public class Knight extends Figure  {
   
    public Knight (int row, int col, String color) {
        super(row,col,color);
        if(color == "white") {
            this.path = "./chesspng/knightw.png";
        } else {
            this.path = "./chesspng/knightb.png";
        }

    }
    
    public void Info() {
        System.out.println("row= " + this.row + " col= " + this.col + " path=" + this.path );
    }

    @Override
    public boolean Step(int newRow, int newColumn) {
        if (newRow != this.row - 1 && newRow != this.row + 1 && newRow != this.row + 2 && newRow != this.row - 2) {
            return false;
        }
        return !(newColumn != this.col - 2 && newColumn != this.col + 2 && newColumn != this.col - 1 && newColumn != this.col + 1);
    }

}
