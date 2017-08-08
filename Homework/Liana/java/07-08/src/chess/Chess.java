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
public class Chess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board board = new Board (8);
        board.init();
        System.out.println(board.getFigures()[7][6].isValidStep(1, 7, board.getFigures()));
    }
    
}
