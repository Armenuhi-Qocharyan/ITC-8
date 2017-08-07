package com.itc.chess;
import java.awt.Point;

/**
 * This class represents the game board(8x8)
 * 
 * @author mary
 */
public class Board {
    public static Figure[][] board;

    /**
     * Initialized board content
     */
    public static void initBoard() {
        board = new Figure[8][8];
        for (int j = 0; j < 8; ++j) {
            board[1][j] = new Pawn(Figure.Chessman.pawn, Figure.Color.black, new Point(1, j));
            board[6][j] = new Pawn(Figure.Chessman.pawn, Figure.Color.white, new Point(6, j));
        }

        Figure.Color color = Figure.Color.black;
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (0 == i || 7 == i) {
                    switch (j) {
                        case 0 : case 7 : { 
                            board[i][j] = new Rook(Figure.Chessman.rook, color, new Point(i, j));
                            break;
                        } 
                        case 1 : case 6 : { 
                            board[i][j] = new Knight(Figure.Chessman.knight, color, new Point(i, j));
                            break;
                        }
                        case 2 : case 5 : { 
                            board[i][j] = new Bishop(Figure.Chessman.bishop, color, new Point(i, j));
                            break;
                        }
                        case 3 : { 
                            board[i][j] = new Queen(Figure.Chessman.queen, color, new Point(i, j));
                            break;
                        }
                        case 4 : { 
                            board[i][j] = new King(Figure.Chessman.king, color, new Point(i, j));
                            break;
                        }
                    }
                } else if (1 != i && 6 != i) {
                    board[i][j] = null;
                }
            }
            color = Figure.Color.white;
        }
    }
    
    /**
     * Prints board content
     */
    public static void printBoard() {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                System.out.print("+----");
            }
            System.out.println("+"); 
            System.out.print("|");

            for (int j = 0; j < 8; ++j) {
                if (board[i][j] == null) {
                    System.out.print("    |");
                } else {
                    switch (board[i][j].getFigure()) {
                        case king : {
                            if (board[i][j].getColor() == Figure.Color.white) {
                                System.out.print(" WK |");
                            } else if (board[i][j].getColor() == Figure.Color.black) {
                                System.out.print(" BK |");
                            }
                            break;
                        }
                        case queen : {
                            if (board[i][j].getColor() == Figure.Color.white) {
                                System.out.print(" WQ |");
                            } else if (board[i][j].getColor() == Figure.Color.black) {
                                System.out.print(" BQ |");
                            }
                            break;
                        }
                        case knight : {
                            if (board[i][j].getColor() == Figure.Color.white) {
                                System.out.print(" Wk |");
                            } else if (board[i][j].getColor() == Figure.Color.black) {
                                System.out.print(" Bk |");
                            }
                            break;
                        }
                        case rook : {
                            if (board[i][j].getColor() == Figure.Color.white) {
                                System.out.print(" WR |");
                            } else if (board[i][j].getColor() == Figure.Color.black) {
                                System.out.print(" BR |");
                            }
                            break;
                        }
                        case bishop : {
                            if (board[i][j].getColor() == Figure.Color.white) {
                                System.out.print(" WB |");
                            } else if (board[i][j].getColor() == Figure.Color.black) {
                                System.out.print(" BB |");
                            }
                            break;
                        }
                        case pawn : {
                            if (board[i][j].getColor() == Figure.Color.white) {
                                System.out.print(" WP |");
                            } else if (board[i][j].getColor() == Figure.Color.black) {
                                System.out.print(" BP |");
                            }
                            break;
                        }
                    }
                }
            }
            System.out.println();

            for (int j = 0; j < 8; ++j) {
                System.out.print("+----"); 
            }
            System.out.println("+");
        }
    }

    /**
     * Executes the game
     * 
     * @param from object initial position
     * @param to object new position
     */
    public static void execute(Point from, Point to) {
        if (board[from.x][from.y] != null) {
            board[from.x][from.y].step(to);
            printBoard();
        } else {
            System.out.println("Node is empty");
        }
    }   
}