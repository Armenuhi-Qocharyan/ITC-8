package chess;

public interface Figure {
    String name = "";
    
    boolean canGo(String col, int row);   
}
