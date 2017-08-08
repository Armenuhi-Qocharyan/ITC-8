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
public class Board {

    private int size;
    private Figure[][] figures;

    public Board(int size) {
        this.size = size;
        this.figures = new Figure[size][size];
    }

    public void init() {
        for (int i = 1; i < size; ++i) {
            for (int j = 1; j < size; ++j) {
                this.figures[i][j] = null;
            }
        }
        figures[0][0] = new Rook("white", 0, 0, 'R');
        figures[0][1] = new Knight("white", 0, 1, 'H');
        figures[0][2] = new Bishop("white", 0, 2, 'B');
        figures[0][3] = new Queen("white", 0, 3, 'Q');
        figures[0][4] = new King("white", 0, 4, 'K');
        figures[0][5] = new Bishop("white", 0, 5, 'B');
        figures[0][6] = new Knight("white", 0, 6, 'H');
        figures[0][7] = new Rook("white", 0, 7, 'R');
        figures[1][0] = new Pawn("white", 1, 0, 'P');
        figures[1][1] = new Pawn("white", 1, 1, 'P');
        figures[1][2] = new Pawn("white", 1, 2, 'P');
        figures[1][3] = new Pawn("white", 1, 3, 'P');
        figures[1][4] = new Pawn("white", 1, 4, 'P');
        figures[1][5] = new Pawn("white", 1, 5, 'P');
        figures[1][6] = new Pawn("white", 1, 6, 'P');
        figures[1][7] = new Pawn("white", 1, 7, 'P');

        figures[7][0] = new Rook("black", 7, 0, 'R');
        figures[7][1] = new Knight("black", 7, 1, 'H');
        figures[7][2] = new Bishop("black", 7, 2, 'B');
        figures[7][3] = new Queen("black", 7, 3, 'Q');
        figures[7][4] = new King("black", 7, 4, 'K');
        figures[7][5] = new Bishop("black", 7, 5, 'B');
        figures[7][6] = new Knight("black", 7, 6, 'H');
        figures[7][7] = new Rook("black", 7, 7, 'R');
        figures[6][0] = new Pawn("black", 6, 0, 'P');
        figures[6][1] = new Pawn("black", 6, 1, 'P');
        figures[6][2] = new Pawn("black", 6, 2, 'P');
        figures[6][3] = new Pawn("black", 6, 3, 'P');
        figures[6][4] = new Pawn("black", 6, 4, 'P');
        figures[6][5] = new Pawn("black", 6, 5, 'P');
        figures[6][6] = new Pawn("black", 6, 6, 'P');
        figures[6][7] = new Pawn("black", 6, 7, 'P');

    }
    
    public Figure[][] getFigures () {
        return figures;
    }

}
