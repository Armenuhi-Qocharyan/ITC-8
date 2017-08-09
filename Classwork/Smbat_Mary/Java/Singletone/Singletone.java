package singletone;

/**
 *
 * @author student
 */
public class Singletone {
    private String member;
    private static Singletone object;

    // Constructor
    private Singletone() {
    }
    
    // Methods
    public static Singletone getInstance() {
        if (object == null) {
            object = new Singletone();
        }
        return object;
    }

    public void print() {
        System.out.println(member);
    }
    // Getter
    public String getMember() {
        return member;
    }

    // Setter
    public void setMember(String member) {
        this.member = member;
    }
}
