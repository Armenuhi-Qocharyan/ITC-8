package observerdesignpattern;

import java.util.ArrayList;

public class Sender {
    private final String name;
    private final ArrayList<Receiver> receivers;

    public Sender(String name) {
        this.name = name;
        this.receivers = new ArrayList<>();
    }
    
    public void addReceiver(Receiver rcvr) {
        receivers.add(rcvr);
    }
    
    public void removeReceiver(Receiver rcvr) {
        receivers.remove(rcvr);
    }
    
    public void notifyAll(String message) {
        System.out.println(this.name + " sent a message:\t\t" + message);
        receivers.forEach((object) -> object.notify(message));
    }
}
