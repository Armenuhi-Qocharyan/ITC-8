
public class Lights extends TrainObserver {

    public Lights(){}

    @Override
    public void notifyTrainArriving() {
        System.out.println("Lights change with color Red !!!");
    }
}
