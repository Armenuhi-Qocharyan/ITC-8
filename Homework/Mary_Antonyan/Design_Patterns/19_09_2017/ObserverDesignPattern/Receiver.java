package observerdesignpattern;

public class Receiver {
    private String name;

    public Receiver(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void notify(String message) {
        System.out.println(this.name + " received a message:\t" + message);
    }
}
