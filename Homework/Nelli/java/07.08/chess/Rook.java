/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.awt.Point;

/**
 *
 * @author nelli
 */
public class Rook extends Figure{

    public Rook(Point position, String color) {
        this.color = color;
        this.position = position;
    }


    @Override
    public boolean checkStep(Point newPosition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
