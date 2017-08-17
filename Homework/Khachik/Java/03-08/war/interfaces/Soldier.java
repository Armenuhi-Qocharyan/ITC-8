package interfaces;
import java.util.*;
import objs.*;

public interface Soldier {
    public Objs initialize ();     
    public void move ();
    public String getName();
    public void fire(Meadow meadow, ArrayList<Soldier> soldier);
    public int getLife();
    public void setLife(int life);
}
