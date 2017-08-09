package anotationtest;

/**
 *
 * @author student
 */
public class Worker {
    String name;
    String surname;

    /**
     * Creates a worker object
     * @param name worker name
     * @param surname worker surname
     */
    public Worker(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    /**
     * Do everyday tasks
     */
    public void doEverydayTasks() {
        System.out.println("Worker doing tasks");
    }
}
