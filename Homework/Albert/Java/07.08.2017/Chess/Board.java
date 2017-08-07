class Board {

    private Figure[][][] board;
    public Board() {
        initBoard();
    }

    private void initBoard() {
        this.board = new Figure[9][9][1];
        for(int i = 0; 9 > i; i++) {
            for (int j = 0; 9 > j; j++) {
                for (int k = 0; k < 1; ++k) {
                    this.board[i][j][k] = new Figure();
                }
            }
        }
        board[0][0][0].setName(' ');
        for (int i = 1, j = 49; 9 > i; i++, j++) {      
            board[0][i][0].setName((char)j);
        }

        for (int i = 1, j = 49; 9 > i; i++, j++) {
            board[i][0][0].setName((char)j);
        }

        board[1][1][0].setName('r');
        board[1][1][0].setColor('B');
        board[1][8][0].setName('r');
        board[1][8][0].setColor('B');
        board[8][1][0].setName('R');
        board[8][1][0].setColor('W');
        board[8][8][0].setName('R');
        board[8][8][0].setColor('W');

        board[1][2][0].setName('n');
        board[1][2][0].setColor('B');
        board[1][7][0].setName('n');
        board[1][7][0].setColor('B');
        board[8][2][0].setName('N');
        board[8][2][0].setColor('W');
        board[8][7][0].setName('N');
        board[8][7][0].setColor('W');

        board[1][3][0].setName('b');
        board[1][3][0].setColor('B');
        board[1][6][0].setName('b');
        board[1][6][0].setColor('B');
        board[8][3][0].setName('B');
        board[8][3][0].setColor('W');
        board[8][6][0].setName('B');
        board[8][6][0].setColor('W');

        board[1][4][0].setName('q');
        board[1][4][0].setColor('B');
        board[8][4][0].setName('Q');
        board[8][4][0].setColor('W');

        board[1][5][0].setName('k');
        board[1][5][0].setColor('B');

        board[8][5][0].setName('K');
        board[8][5][0].setColor('W');

        for (int i = 1; 9 > i; i++) {
            board[2][i][0].setName('p');
        }

        for (int i = 1; 9 > i; i++) {
            board[7][i][0].setName('P');
        }

        for (int i = 3; 7 > i; i++) {
            for (int j = 1; 9 > j; j++) {
                board[i][j][0].setName('.');
            }
        }
    }

    public void figureMoved(int i1, int j1, int i2, int j2) {
        this.board[i2][j2][0].setName(board[i1][j1][0].getName());
        this.board[i1][j1][0].setName('.');
    }

    // Set Get name
    public void setName(int i, int j, char name) {
        board[i][j][0].setName(name);
    }
    public char getName(int i, int j) {
        return board[i][j][0].getName();
    }

    // Set Get Color
    public void setColor(int i, int j, char color) {
        board[i][j][0].setColor(color);
    }
    public char getColor(int i, int j) {
        return board[i][j][0].getColor();
    }

    //Print
    public void printBoard() {
        System.out.println("\n");
        for (int i = 0; 9 > i; i++) {
            for (int j = 0; 9 > j; j++) {
                for (int k = 0; 1 > k; k++) {
                    System.out.print(board[i][j][k].getName() + "   ");
                }
            }
            System.out.println("\n");
        }
        System.out.println("\n");
    }
}
