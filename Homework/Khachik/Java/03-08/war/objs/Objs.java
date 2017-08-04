package objs;
import java.util.*;
import java.lang.*;

public class Objs {
    public String _name;
    public double _radius;
    public double _x;
    public double _y;
    public double _vectorX;
    public double _vectorY;
    public double _speed;

    public Objs(double x, double y, double angle, double speed, double radius, String name) {
        this._speed = speed;
        this._name = name;
        this._radius = radius;
        this._x = x;
        this._y = y;
        double x1 = x +  Math.cos(Math.toRadians(angle));
        double y1 = y +  Math.sin(Math.toRadians(angle));
        this._vectorX = x1 - x;
        this._vectorY = y1 - y;
        System.out.print(_vectorX + "  " + _vectorY);
    }

}
