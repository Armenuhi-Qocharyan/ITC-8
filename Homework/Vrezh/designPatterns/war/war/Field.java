package war;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;
import java.util.concurrent.TimeUnit;
import java.lang.InterruptedException;


public class Field {
    public final int width;
    public final int height;
    private final ArrayList<Moving> objects;
    
    public Field(int w, int h) {
        width = w;
        height = h;
        objects = new ArrayList<Moving>();
    }

    public void setObject(Moving obj) {
        objects.add(obj);
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }   
    
    public void startGame(int time) {
        System.out.println("------------------Start Game---------------------------");
        for (int i = 0; i < time; ++i) {
            controllObjects();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException err) {
                System.out.print(err);
            }
        }
    }

    public void controllObjects() {
        for (int i = 0; i < objects.size(); ++i) {
            if (objects.get(i).getScoreVX() != 0 && objects.get(i).getScoreVY() != 0) {
                objects.get(i).move(); 
                boolean isCll = isCollide(objects.get(i));
            }
        }
    }

    public boolean isCollide(Moving obj) {
        for (Moving object : objects) {
            if (object != obj) {
                if (object.getCoordX() - obj.getCoordX() < Math.abs(obj.getWidth()) && object.getCoordX() - obj.getCoordX() < Math.abs(obj.getWidth())) {
                    obj.accept((Visitor)object);
                    return true;
                }
            }
        }

        return false;
    }

}

