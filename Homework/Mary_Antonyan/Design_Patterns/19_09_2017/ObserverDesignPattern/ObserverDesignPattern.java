package observerdesignpattern;

public class ObserverDesignPattern {

    public static void main(String[] args) {
        Sender sender = new Sender("Jhonny");
        
        Receiver helen = new Receiver("Helen");
        Receiver dean = new Receiver("Dean");
        
        sender.addReceiver(dean);
        sender.addReceiver(helen);
        
        sender.notifyAll("Hi everyone!");
    }
}
