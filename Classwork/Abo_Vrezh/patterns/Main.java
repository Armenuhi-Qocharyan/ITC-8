import java.lang.NullPointerException;

public class Main {

    public static void main(String[] args) throws NullPointerException{
        
        TrainButton button = new TrainButton();
        Lights lights = new Lights();
        Stop stop = new Stop();


        button.addObserver(lights);
        button.addObserver(stop);

        button.click();
    }
}
