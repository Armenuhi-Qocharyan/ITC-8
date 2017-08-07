package com.itc.chess;
import java.awt.Point;
import java.util.Scanner;

/**
 * Project entry point
 *  
 * @author mary
 */
public class Main {
    public static void main(String[] args) {
        Board.initBoard();
        Board.printBoard();

        int fromX;
        int fromY;
        int toX;
        int toY;
        String flag;
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("Enter coordinates for figure which you want to move");
            System.out.print("Row: ");
            fromX = in.nextInt();
            System.out.print("Coloumn: ");
            fromY = in.nextInt();
        
            System.out.println("Enter coordinate to move figure");
            System.out.print("Row: ");
            toX = in.nextInt(); 
            System.out.print("Coloumn: ");
            toY = in.nextInt();
        
            Board.execute(new Point(fromX, fromY), new Point(toX, toY));
            System.out.print("Press Q to quit");
            flag = in.next();
        } while (!flag.equals("q") && !flag.equals("Q"));
    } 
}
