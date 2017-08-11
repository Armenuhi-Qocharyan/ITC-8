package timeTable;
import java.util.*;

enum Action {
    INSERT, FIND, DELETE, SEARCHBYINDEX
};

public class TimeTable {
    private long[][] table = new long[4][4];
    private ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();
    private String[] collectionType = {"ArrayList", "LinkedList", "HashMap", "Stack"};
    private HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
    private Stack<Integer> stack = new Stack<Integer>();

    public TimeTable() {
        alloc();
    }

    private void alloc() {
        list.add(new ArrayList<Integer>());
        list.add(new LinkedList<Integer>()); 
    }

    public void insertTimeList(Action action, int value) {
        long start = 0, end = 0;
        int column = 0;
        for (int i = 0; i < 2; ++i) {
            start = System.nanoTime();
            switch (action) {
                case DELETE: 
                    list.get(i).remove(value);
                    column = 2;
                    break;
                case FIND: 
                    list.get(i).contains(value);
                    column = 1;
                    break;
                case SEARCHBYINDEX: 
                    list.get(i).get(value);
                    column = 3;
                    break;
                default:    
                    list.get(i).add(value);
                    column = 0;
                    break;
            }

            end = System.nanoTime();
            table[i][column] = end - start;
        }
    }

    public void insertTimeHashMap(Action action, int value, int key) {
        int column = 0;
        long start = System.nanoTime();
        switch (action) {
            case DELETE: 
                hashMap.remove(key);
                column = 2;
                break;
            case FIND: 
                hashMap.containsValue(value);
                column = 1;
                break;
            default:    
                hashMap.put(key, value);
                column = 0;
                break;
        }

        long end = System.nanoTime();
        table[2][column] = end - start;
    }

    public void insertTimeStack(Action action, int value) {
        int column = 0;
        long start = System.nanoTime();
        switch (action) {
            case DELETE: 
                stack.pop();
                column = 2;
                break;
            case FIND: 
                stack.search(value);
                column = 1;
                break;
            case SEARCHBYINDEX: 
                stack.pop();
                column = 3;
                break;

            default:    
                stack.push(value);
                column = 0;
                break;
        }

        long end = System.nanoTime();
        table[3][column] = end - start;
    }

    public void printTable() {
        insertTimeList(Action.INSERT, 10);
        insertTimeList(Action.FIND, 10);
        insertTimeList(Action.SEARCHBYINDEX, 0);
        insertTimeList(Action.DELETE, 0);

        insertTimeHashMap(Action.INSERT, 10, 0);
        insertTimeHashMap(Action.FIND, 10, 0);
        insertTimeHashMap(Action.DELETE, 10, 0);

        insertTimeStack(Action.INSERT, 2);
        insertTimeStack(Action.INSERT, 3);
        insertTimeStack(Action.FIND, 10);
        insertTimeStack(Action.SEARCHBYINDEX, 0);
        insertTimeStack(Action.DELETE, 0);

        System.out.println("|Collection Type|insert\t|find\t|delete\t|search|");
        System.out.println("___________________________________________________");
        for (int i = 0; i < 4; ++i) {
            System.out.print("|" + collectionType[i] + "    \t|");
            for (int j = 0; j < 4; ++j) {
                System.out.print(table[i][j]+ "\t|");
            }
            System.out.println();
        }
    }
    
    
    
    
}
