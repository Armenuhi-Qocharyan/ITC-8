/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Point;
import chess.ChessBoard;
import chess.Figure;
/**
 *
 * @author nelli
 */
public class Chess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ChessBoard area = new ChessBoard();
        Point position = new Point(0, 0);
        String color = "black";
        String type = "rook";
        area.insertBoard(position, color, type);
        Point newPosition = new Point(2, 2);
        Figure first = area.getFigure(position);
        Figure second = area.getFigure(newPosition);
    }
    
}
