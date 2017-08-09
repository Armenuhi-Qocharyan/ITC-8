package anotationtest;

/**
 *
 * @author student
 */
public class Main {
    public static void main(String[] args) {
        Manager m = new Manager("ManagerName", "ManagerSurname");
        Worker w = new Worker("WorkerName", "WorkerSurname");
        m.doEverydayTasks();
        w.doEverydayTasks();
    }   
}