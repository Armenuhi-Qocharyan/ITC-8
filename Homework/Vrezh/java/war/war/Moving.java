package war;
import java.util.concurrent.TimeUnit;
import java.lang.InterruptedException;

class Moving {
    private float scoreVX;
    private float scoreVY;
    private float coordX;
    private float coordY;
    private boolean moving;

    public Moving() {
        scoreVX = 0;
        scoreVY = 0;
        coordX = 0;
        coordY = 0;
        moving = false;
    }

    public void setCoords(float x, float y) {
        coordX = x;
        coordY = y;
    }

    public float getCoordX() {
        return coordX;
    }

    public float getCoordY() {
        return coordY;
    }
    
    public void setScoreV(float x, float y) {
        scoreVX = x;
        scoreVY = y;
    }

    public float getScoreVX() {
        return scoreVX;
    }

    public float getScoreVY() {
        return scoreVY;
    }

    public void setMoving(boolean m) {
        moving = m;
    }

    public boolean isMoving() {
        return moving;
    }
 
    public void move() {
        moving = true;
        setCoords(coordX + scoreVX*1, coordY + scoreVY*1);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException err) {
            System.out.print(err);
        }
    }

}
