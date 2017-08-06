
public class Knight extends Piece {
    private String type;
    public Knight(String type) {
        this.type = type;
    }

    public Knight(String type, int row, int col) {
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
    
    public Boolean step(int row, int col) {
	return true;
    }
}
