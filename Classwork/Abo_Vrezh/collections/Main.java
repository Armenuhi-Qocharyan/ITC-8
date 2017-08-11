import timeTable.*;


public class Main {
    public static void main(String[] args) {

        TimeTable timeTable = new TimeTable();
        timeTable.setTimeInsert();
        timeTable.setTimeFind();
       timeTable.setTimeDelete();
       timeTable.setTimeIndexSearch();

       timeTable.printTable();
    }
}
