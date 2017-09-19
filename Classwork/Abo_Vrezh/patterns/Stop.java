
public class Stop extends TrainObserver {

    public Stop() {}

    @Override
    public void notifyTrainArriving() {
        System.out.println("Stop up !!!");
    }
}
