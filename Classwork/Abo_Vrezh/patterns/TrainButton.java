
import java.util.*;

public class TrainButton {
    private ArrayList<TrainObserver> observerObjects;
    public TrainButton() {
        observerObjects = new ArrayList<TrainObserver>();
    }

    public void addObserver(TrainObserver object) {
        observerObjects.add(object);
    }

    public void removeObserver(TrainObserver object) {
        observerObjects.remove(object);
    }

    public void click() {
        System.out.println("Train button clicked !!!");
        for (TrainObserver observer: observerObjects) {
            observer.notifyTrainArriving();
        }
    }
}
