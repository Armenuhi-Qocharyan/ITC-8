import java.lang.Math.*;

public class Rooks extends Figure {

    public Rooks() { }

    //i1, j1 dirq@ vortexic texapoxvelu e i2, j2 dirq@ vortex texapoxvelu e
    public boolean step(int i1, int j1, int i2, int j2) {
        if (this.getName() == 'R' || this.getName() == 'r') {
            if ((1 <= Math.abs(i1 - i2)) && j1 == j2) {
                return true;
            } else if (i1 == i2 && (1 <= Math.abs(j1 - j2))) {
                return true;
            }
        } 
        return false;
    }
}
