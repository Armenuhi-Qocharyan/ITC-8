import java.lang.Math.*;

public class Bishop extends Figure {

    public Bishop() { }

    //i1, j1 dirq@ vortexic texapoxvelu e i2, j2 dirq@ vortex texapoxvelu e
    @Override
    public boolean step(int i1, int j1, int i2, int j2) {
        if (this.getName() == 'B' || this.getName() == 'b') {
            if (Math.abs(i1 - i2) == Math.abs(j1 - j2)) {
                return true;
            }
        } 
        return false;
    }

};
