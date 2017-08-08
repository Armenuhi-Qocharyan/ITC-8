package chess;

public abstract class Figure extends Style implements Step {
    private String name;

    public Figure(String n, char col, int r, Style.Color c) {
        super(col, r, c);
        name = n;   
    }
    
    public void setNaem(String n) {
        name = n;
    }
 
    public String getName() {
        return name;
    }
    
    public abstract boolean canGo(char col, int r);
    
    public Object clone()throws CloneNotSupportedException{  
        return super.clone();  
    }      
}
