package singletone;

/**
 *
 * @author student
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Singletone obj = Singletone.getInstance();
        obj.setMember("Hovhannes");
        obj.print();
        Singletone newObj = Singletone.getInstance();
        newObj.print();
    }  
}
