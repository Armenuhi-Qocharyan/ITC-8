package figurs;
import board.*;

public class Knight extends Piece {
    private String type;
    private String color;
    public Knight(String type) {
        this.type = type;
	if(this.type == "kn"){
            this.color = "white";
        } else {
            this.color = "black";
        }
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
    public String getColor() {
        return this.color;
    }
    
    public void step(Board b, int row, int col, int newRow, int newCol) {
	if (newCol < 8 && newRow < 8 && newCol >= 0 && newRow >= 0) {
            if(b.getPiece(newRow, newCol) == null || b.getPiece(newRow, newCol).getColor() != b.getPiece(row, col).getColor()){
		int deltaRow = newRow - row;
		int deltaCol = newCol - col;
		if(deltaRow*deltaRow + deltaCol*deltaCol == 5) {
                    b.setPiece(this, newRow, newCol);
                    b.removePiece(row, col);
		} else {
		    System.out.println("Dont move\n");
		}
            } else {
                System.out.println("My piece\n");
            }
        } else {
            System.out.println("Wrong location\n");
        }

    }
}
