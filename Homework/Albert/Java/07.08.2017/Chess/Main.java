import java.util.*;

public class Main {
    public static void main(String[] args) {
        Board boards = new Board();
        boards.printBoard();
        chooseFigure(boards);
    }
    public static void inputIJ(int[] ij) {
        System.out.println("Matrici i, j hamarakalum@ sksenq 1,1 ketic-ic\n");
        System.out.println("\nMutq Figure-i skzbnakan dirq@\n");
        do {
            System.out.print("i1: ");
            Scanner input = new Scanner(System.in);
            ij[0] = input.nextInt();

        } while (0 >= ij[0] || 9 <= ij[0]);
        do {
            System.out.print("j1 : ");
            Scanner input = new Scanner(System.in);
            ij[1] = input.nextInt();
        } while (0 >= ij[1] || 9 <= ij[1]);
        System.out.println("Mutq texapoxvox dirq@\n");
        do {
            System.out.print("i2: ");
            Scanner input = new Scanner(System.in);
            ij[2] = input.nextInt();
        } while (0 >= ij[2] || 9 <= ij[2]);
        do {
            System.out.print("j2: ");
            Scanner input = new Scanner(System.in);
            ij[3] = input.nextInt();
        } while (0 >= ij[3] || 9 <= ij[3]);
    } 

    public static void checkMove(Figure figure, Board boards) {
        int[] ij = new int[4];
        inputIJ(ij);
        int i1 = ij[0], j1=ij[1], i2 = ij[2], j2 = ij[3];
        figure.setName(boards.getName(i1,j1));
        Figure tmp = new Figure();
        tmp.setName(boards.getName(i2,j2));
        if ((figure.getName() >= 65 && figure.getName() <= 90) && ((tmp.getName() >= 65 && tmp.getName() <= 90))) {
            System.out.println("\n***NO*** 2 FIGURES HAVE THE SAME COLOR ***\n");
            boards.printBoard();
        } else if ((figure.getName() >= 97 && figure.getName() <= 122) && ((tmp.getName() >= 97 && tmp.getName() <= 122))) {
            System.out.println("\n***NO*** 2 FIGURES HAVE THE SAME COLOR ***\n");
            boards.printBoard();
        } else if (figure.getName() == 46 && tmp.getName() == 46) {
            System.out.println("\n***NO*** CHOOSE FIGURE ***\n");
            boards.printBoard();
        } else {
            figure.setColor(boards.getColor(i1,j1));
            System.out.println("choosed figure = " + boards.getName(i1,j1));

            if (figure.step(i1, j1, i2, j2)) {
                System.out.println("\n***YES*** FIGURE CAN BE MOVED ***\n");
                boards.figureMoved(i1, j1, i2, j2);
                boards.printBoard();
            } else {
                System.out.println("\n***NO*** FIGURE CAN NOT BE MOVED ***\n");
                boards.printBoard();
            }
        }
    }

    public static void chooseFigure(Board boards) {
        Figure figure;
        int choose = 0;
        do {
            switch(choose) {
                case 1:
                    figure = new Pawns();
                    checkMove(figure,boards);
                    break;
                case 2:
                    figure = new Knight();
                    checkMove(figure,boards);
                    break;
                case 3:
                    figure = new Rooks();
                    checkMove(figure,boards);
                    break;
                case 4:
                    figure = new Bishop();
                    checkMove(figure,boards);
                    break;
                case 5:
                    figure = new King();
                    checkMove(figure,boards);
                    break;
                case 6:
                    figure = new Queen();
                    checkMove(figure,boards);
                    break;
            }
            System.out.print("Press 1-Pawn(Zinvor), 2-Knight(Dzi) 3-Rook(Navak), 4-Bishop(Pix), 5-King, 6-Queen, 7-EXIT : ");
            Scanner input = new Scanner(System.in);
            choose = input.nextInt();
        } while(7 != choose);
    }
}
