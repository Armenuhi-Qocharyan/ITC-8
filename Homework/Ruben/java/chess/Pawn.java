
public class Pawn extends Piece {
    private String type;
    public Pawn(String type) {
        this.type = type;
    }

    public Pawn(String type, int row, int col) {
        super.setRow(row);
        super.setCol(col);
        this.type = type;
    }


    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
    
    public Boolean step(Board b, int row, int col) {
	b.setPiece(this, row, col);
	return true;
    }
}
