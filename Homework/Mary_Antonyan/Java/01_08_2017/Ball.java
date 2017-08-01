import java.lang.Math;

public class Ball {
    // Members
    private int x;
    private int y;
    private int r;
    private int m;
    private int vx;
    private int vy;

    // Constructor
    public Ball(int xx, int yy, int rr, int mm, int vvx, int vvy) {
        x = (xx > 0) ? xx : 0;
        y = (yy > 0) ? yy : 0;
        r = (rr > 1) ? rr : 1;
        m = (mm > 1) ? mm : 1;
        vx = vvx;
        vy = vvy;
        System.out.println("Initial state: ");
        printStatus();
    }

    // Methods
    public void getStatus(Ball other, int time) {
        for (int i = 1; i <= time; ++i) {
            x += vx;
            y += vy;
            other.x += other.vx;
            other.y += other.vy;
            if (checkBallCollision(other)) {
                System.out.println("Collision to ball in " + i + " second\n");
                changeStatus(other);
            }
            checkWallCollision(i);
            other.checkWallCollision(i);
        }

        System.out.println("First ball: ");
        printStatus();
        
        System.out.println("Second ball: ");
        other.printStatus();
    }

    private void printStatus() {
        System.out.println("Coordinates:    x: " + x + "    y: " + y); 
        System.out.println("Speed:    vx: " + vx + "    vy: " + vy);
        System.out.println("Mass:    m: " + m);
        System.out.println("Radius:    r: " + r);

        System.out.println("\n");
    }

    private boolean checkBallCollision(Ball other) {
        return (Math.sqrt((x - other.x) * (x - other.x) + (y - other.y) * (y - other.y)) <= r + other.r);
    }

    private void checkWallCollision(int i) {
        if (x - r == 0 || x + r == 100) {
            System.out.println("Collision to wall in " + i + " second\n");
            inverseX();
        }
        if (y - r == 0 || y + r == 100) {
            System.out.println("Collision to wall in " + i + " second\n");
            inverseY();
        }
    }
    
    private void changeStatus(Ball other) {
        // m1 * v1 + m2 * v2 = m1 * v1' + m2 * v2'
        // m1 * v1^2 + m2 * v2^2 = m1 * v1'^2 + m2 * v2'^2
        // We need to found final speeds and accept it as ball's new speed
        inverseX();
        inverseY();
    }

    private void inverseX() {
        vx = -vx;
    }

    private void inverseY() {
        vy = -vy;
    } 
}
