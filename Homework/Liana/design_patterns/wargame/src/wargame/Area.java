
package wargame;

import java.util.ArrayList;
import java.util.Random;

public class Area {
    private int width;
    private int height;
    private static Area instance;

    
    private Area(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    /**
     * returns instance of Singleton Area
     * 
     * @param width
     * @param height
     * @return instance of Area
     */
    public static synchronized Area getInstance(int width, int height){
        if(instance == null){
            instance = new Area(width, height);
        }
        return instance;
    }
    
    private ArrayList<GameObject> objects = new ArrayList<>();
    
    /**
     * Initializes objects with random GameObjects
     * 
     * @param count GameObjects count in Area
     */
    public void initialize (int count) {
        Random random = new Random();
        for (int i = 0; i < count; ++i ) {
            objects.add(GameObjectFactory.getInstance(random.nextInt(this.width), random.nextInt(this.height)));
        }
    }
    
    /**
     *Start to move all objects
     * @param time minimum time to move objects
     * @param duration war duration
     */
    public void start (int time, int duration) {
        while(0 < duration) {
            for (int i = 0; i < objects.size(); ++i) {
                GameObject object = objects.get(i);
                object.move(time);
                if (object.getPosition().x >= width) {
                    object.getPosition().x = -object.getPosition().x;
                }
                if (object.getPosition().y >= height) {
                    object.getPosition().y = -object.getPosition().y;
                }
                object.checkCollision(objects, time);
            }
            duration--;
        }
    }
}
