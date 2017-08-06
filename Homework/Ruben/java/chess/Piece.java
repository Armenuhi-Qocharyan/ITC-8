
public abstract class Piece {

    private int row;
    private int col;

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public void setRow(int x) {
        this.row = row;
    }

    public void setCol(int y) {
        this.col = col;
    }

    public int[] getPosition() {
        return new int[]{this.row, this.col};
    }

    public void setPosition(int[] pos) {
    }

    public abstract String getType();
    public abstract Boolean step(Board b, int row, int col);
}
