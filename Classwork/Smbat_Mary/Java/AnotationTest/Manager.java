package anotationtest;

/**
 *
 * @author student
 */
public class Manager extends Worker {
    /**
     * Creates a manager object
     * @param name manager name
     * @param surname manager surname
     */
    public Manager(String name, String surname) {
        super(name, surname);
    }
    
    /**
     * Do everyday tasks 
     */
    @Override
    public void doEverydayTasks() {
        System.out.println("Manager doing tasks");
    }
}
