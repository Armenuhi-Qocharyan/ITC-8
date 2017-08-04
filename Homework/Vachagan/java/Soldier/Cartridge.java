
import java.lang.Math;
import java.lang.Thread.*;

public class Cartridge {

    private double x;
    private double y;
    private double angle;
    private int v;
    private int damage = 10;
    
    public void changeDamage(int damage) {
        this.damage = damage;
    }
    public Cartridge(double x,double y ) {
        this.x = x;
        this.y = y;
    }
    public boolean  Move(int v,double angle,double secondX, double secondY, double distance) {
        this.v = v;
        this.angle = angle;
        double time = distance / v;
        /*
        try {
            Thread.sleep((int) (time)); 
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }*/
        double radian = Math.toRadians(this.angle);
        this.x = this.x + this.v * time * Math.cos(radian);
        this.y = this.y + this.v * time * Math.sin(radian);
        if(Distance(secondX,secondY) < 1) { 
            return true;
        } 
        return false;
    }

    private double Distance(double firstx, double firsty) {
        return Math.sqrt(Math.pow((this.x - firstx),2) + Math.pow((this.y - firsty),2));
    }
    
    public int getDamage() {
        return this.damage;
    }
}
