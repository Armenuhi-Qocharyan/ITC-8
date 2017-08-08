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
public interface Figure {

    /**
     * 
     * @param row
     * @param column
     * @param figures
     * @return
     */
    public boolean isValidStep (int row, int column, Figure[][] figures);
    public String getColor();
}
