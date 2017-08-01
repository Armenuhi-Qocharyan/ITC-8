package shapes;

import java.io.PrintStream;
public class Rectangle  implements Shape {
    int col = 20;
    int row = 15;
    public Rectangle(int col , int row ){
        this.col = col;
        this.row = row;
    }
    public boolean Drow(PrintStream ps, char x) {
            System.setOut(ps);
            System.out.println("Rectangle \n\n");
            for (int i = 1; i <= col; ++i) {
                 for (int j = 1; j <= row ;++j) {
                     if ( i == 1 || i == col || j == 1 || j == row) {
                         System.out.print(x);
                     } else {
                         System.out.print(" ");
                     }
                 }
                    System.out.println(); 
            }
            return true;
    }
}