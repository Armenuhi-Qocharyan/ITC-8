package visitorpattern;

import java.util.ArrayList;

public class Field {
    ArrayList<GameObject> objects;
    private static Field instance = null;
    private double height;
    private double width;

    private Field(double height, double width) {
        this.height = height;
        this.width = width;
        this.objects = new ArrayList<>();
    }
    
    public static Field getInstance() {
        if (instance == null) {
            instance = new Field(100, 100);
        }
        return instance;
    }
    
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    
    public void addObservable(GameObject object) {
        this.objects.add(object);
    }
    
    public void removeObservable(GameObject object) {
        int index = this.objects.indexOf(object);
        if (index > -1) {
            this.objects.set(index, null);
        }
    }
    
    public void moveObjects() {
        objects.stream().filter((object) -> (object != null)).map((object) -> {
            object.move();
            return object;
        }).forEachOrdered((object) -> {
            objects.stream().filter((other) -> (other != null && 
                    other != object && object.getX() == other.getX() 
                    && object.getY() == other.getY())).map((other) -> {
                object.notifyCollision(other);
                return other;
            }).forEachOrdered((other) -> {
                other.notifyCollision(object);
            });
        });
    }

    public boolean isEmpty() {
        return objects.stream().noneMatch((object) -> (object != null));
    }
}
