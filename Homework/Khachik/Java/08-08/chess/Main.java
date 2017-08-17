import figures.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        System.out.println("Main called.");
        int n = 8;
        Figure board[][] =  new Figure[8][8];
        board[0][0] = new Rook(0,0,'w','r');
        board[0][1] = new Knight(0,1,'w','h');
        board[0][2] = new Bishop(0,2,'w','b');
        board[0][4] = new Queen(0,4,'w','q');
        board[0][3] = new King(0,3,'w','k');
        board[0][5] = new Bishop(0,5,'w','b');
        board[0][6] = new Knight(0,6,'w','h');
        board[0][7] = new Rook(0,7,'w','r');
        for(int i = 0; i < n; ++i) {
            board[1][i] = new Pawn(1,i,'w','p');
        }
        for(int i = 2; i < 6; ++i) {
            for(int j = 0; j < n; ++j) {
                board[i][j] = null;
            }
        }
        for(int i = 0; i < n; ++i) {
            board[6][i] = new Pawn(6,i,'b','P');
        }
        board[7][0] = new Rook(7,0,'b','R');
        board[7][1] = new Knight(7,1,'b','H');
        board[7][2] = new Bishop(7,2,'b','B');
        board[7][4] = new Queen(7,4,'b','Q');
        board[7][3] = new King(7,3,'b','K');
        board[7][5] = new Bishop(7,5,'b','B');
        board[7][6] = new Knight(7,6,'b','H');
        board[7][7] = new Rook(7,7,'b','R');
        try {
            game(board, n);
        } catch (InputMismatchException ex) {
            System.out.println("\nWrong input\n");
        }
    }
    
    private static void game(Figure [][] board, int n) {
        do {
            System.out.print("   ");
            for(int i = 0; i < n; ++i) {
                System.out.print(i + " ");
            }
            System.out.print("\n__________________\n");
            for (int i = 0; i < n; ++i) {
                System.out.print(i + " |");
                for (int j = 0; j < n; ++j) {
                    if(board[i][j] != null) {
                        board[i][j].print();
                    } else {
                        System.out.print("  ");
                    }
                }
                System.out.print("\n");
            }
            Scanner scan = new Scanner(System.in);
            int figx = 0, figy = 0, figx1 = 0, figy1 = 0;
            System.out.print("\nEnter the figure coordinates\nx1 = ");
            
            figx = scan.nextInt();
            System.out.print("y1 = ");
            figy = scan.nextInt(); 
            System.out.print("x2 = ");
            figx1 = scan.nextInt();
            System.out.print("y2 = ");
            figy1 = scan.nextInt();
            if (!(0 <= figx && 7 >= figx && 0 <= figy && 7 >= figy &&  0 <= figx1 && 7 >= figx1 && 0 <= figy1 && 7 >= figy1) || 
                    (figx == figx1 && figy == figy1) || (null == board[figx][figy])) {
                continue;
            }
            if (board[figx][figy].step(figx1, figy1, board)) {
                
                board[figx1][figy1] = board[figx][figy];
                board[figx][figy] = null;
                board[figx1][figy1].setx(figx1);
                board[figx1][figy1].sety(figy1);
            }
            System.out.print("\nEnter 1 - to continue the game\nEnter another number to exit\n");
            int exit = scan.nextInt();
            if(exit != 1) {
                return;
            }
        } while (true);
    }
}