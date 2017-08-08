import java.lang.Math.*;

public class Knight extends Figure {

    public Knight(){ }

    //i1, j1 dirq@ vortexic texapoxvelu e i2, j2 dirq@ vortex texapoxvelu e
    @Override
    public boolean step(int i1, int j1, int i2, int j2) {
        if (this.getName() == 'N' || this.getName() == 'n') {
            if ((2 == Math.abs(i1 - i2)) && (1 == Math.abs(j1 - j2))) {
                return true;
            } else if (1 == Math.abs(i1 - i2) && (2 == Math.abs(j1 - j2))) {
                return true;
            }
        }
        return false;
    }
}
