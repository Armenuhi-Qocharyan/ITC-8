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

        char[] black = {'*','r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'};
        char[] white = {'*','R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'};


        for (int i = 1, j = 1, k = 0; j < 9; ++j) {
            board[i][j][k].setName(black[j]);
            board[i][j][k].setColor('B');
        }

        for (int i = 8, j = 1, k = 0; j < 9; ++j) {
            board[i][j][k].setName(white[j]);
            board[i][j][k].setColor('W');
        }

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
