import java.awt.Point;

public class Bullets {
    private int x;
    private int y;
    private int dx;
    private int dy;

    public Bullets (int sourceX, int sourceY) {
        x = sourceX;
        y = sourceY;
    }

    public void go (Soldier target, int speed, int interval) {
        int currentX = x;
        int currentY = y;
        dx = target.getX() - x;
        dy = target.getY() - y;
        double angle = Math.atan2(dx, dy);
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);

        for (int i = 0; i < interval; ++i) {
            currentX +=  speed * cos;
            currentY += speed * sin;
            if ( isTarget(target, currentX, currentY) ) {
                target.injured();
                return;
            } 

        } 
        System.out.println("missed..");
    }


    public boolean isTarget (Soldier target, int currentX, int currentY) {
        Point point = new Point (currentX, currentY);
        double distance = point.distance(target.getX(), target.getY());

        if ( distance < target.getWidth() ) {
            return true;
        }
        return false;
    }
}
