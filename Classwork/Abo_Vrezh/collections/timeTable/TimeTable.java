package timeTable;
import java.util.*;

public class TimeTable {
    private long[][] table = new long[4][4];
    private ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();

    public TimeTable() {
        alloc();
    }

    private void alloc() {
        /*
        for (int i = 1; i < 4; ++i) {
            for (int j = 1; j < 4; ++j) {
                table[i][j] = new int(0);
            }
        }
        */
        list.add(new ArrayList<Integer>());
        list.add(new LinkedList<Integer>()); 
    }

    public void setTimeInsert() {
        for ( int i = 0; i < 2; ++i) {
            long start = System.nanoTime();
            for (int j = 0; j < 100; ++j) {
                list.get(i).add(j);
            }
            long end = System.nanoTime();
            table[i][0] = end - start;
        }
    } 

    public void setTimeFind() {
        long start = 0;
        long end = 0;
        for ( int i = 0; i < 2; ++i) {
            start = System.nanoTime();
            list.get(i).contains(1);
            end = System.nanoTime();
            table[i][1] = end - start;
        }
    }

    public void setTimeDelete() {
        long start = 0;
        long end = 0;
        for ( int i = 0; i < 2; ++i) {
            start = System.nanoTime();
            //for (int j = 0; j < 100; ++j) {
                list.get(i).remove(1);
            //}
            end = System.nanoTime();
            table[i][2] = end - start;
        }
    }

    public void setTimeIndexSearch() {
        long start = 0;
        long end = 0;
        for ( int i = 0; i < 2; ++i) {
            start = System.nanoTime();
            for (int j = 0; j < 100; ++j) {
                list.get(i).get(i);
            }
            end = System.nanoTime();
            table[i][3] = end - start;
        }
    }

    public void printTable() {
        System.out.println("Type\tinsert\tfind\tdelete\tsearch");
        for (int i = 0; i < 4; ++i) {
            System.out.print("*\t");
            for (int j = 0; j < 4; ++j) {
                System.out.print(table[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    
    
    
}
