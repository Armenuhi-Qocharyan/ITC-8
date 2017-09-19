package objs;

public class Objs {
    public double _radius;
    public double _x;
    public double _y;
    public double _vectorX;
    public double _vectorY;
    public double _speed;
    public String _name;

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

    /**
     * Listen the other Soldiers shotes.
     */
    public int shotListener(double x, double y, Objs bullet, Objs shoterBall, int weapon) {
        if (Math.abs(x - this._x) < (bullet._radius + this._radius) && 
                Math.abs(y - this._y) < (bullet._radius + this._radius) && this != bullet && this != shoterBall) {
            switch(weapon) {
                case 1: return 3;
                case 2: return 5;
                case 3: return 10; 
                case 4: return 15; 
                case 5: return 20; 
                case 6: return 25; 
                case 7: return 50; 
                default: System.out.print("Wrong weapon");
                         return 0;
            }           
                }
        return -1;
    }
}
