package collection;
import java.util.*;

public class Collection {
    private Integer count;
    private List <Integer> arrayList = new ArrayList <Integer>();
    private List <Integer> linkedList = new LinkedList <Integer>();
    private Set <Integer> hashSet = new HashSet <Integer>();
    private Set <Integer> treeSet = new TreeSet <Integer>();
    private Map <Integer, Integer> hashMap = new HashMap <Integer, Integer>();
    private Map <Integer, Integer> treeMap = new TreeMap <Integer, Integer>();
    private Object[][] table = new Object[6][5];

    public Collection() {
        this.count = 1000;
        getTimeForListSetMap();
    }

    private void getTimeForListSetMap() { 
        this.table[0][0] = "Array-L";
        getInsertTimeList(arrayList, 0, 1);
        getSearchIndexTimeList(arrayList, 100, 0, 2);
        getFindTimeList(arrayList, 100, 0, 3);
        getDeleteTimeList(arrayList, 100, 0, 4);

        this.table[1][0] = "Link-L";
        getInsertTimeList(linkedList, 1, 1);
        getSearchIndexTimeList(linkedList, 100, 1, 2);
        getFindTimeList(linkedList, 100, 1, 3);
        getDeleteTimeList(linkedList, 100, 1, 4);

        this.table[2][0] = "Hash-S";
        getInsertTimeSet(hashSet, 2, 1);
        getFindTimeSet(hashSet, 100, 2, 3);
        getDeleteTimeSet(hashSet, 100, 2, 4);

        this.table[3][0] = "Tree-S";
        getInsertTimeSet(treeSet, 3, 1);
        getFindTimeSet(treeSet, 100, 3, 3);
        getDeleteTimeSet(treeSet, 100, 3, 4);

        this.table[4][0] = "Hash-M";
        getInsertTimeMap(hashMap, 4, 1);
        getSearchIndexTimeMap(hashMap, 100, 4, 2);
        getFindTimeMap(hashMap, 100, 4, 3);
        getDeleteTimeMap(hashMap, 100, 4, 4);

        this.table[5][0] = "Tree-M";
        getInsertTimeMap(treeMap, 5, 1);
        getSearchIndexTimeMap(treeMap, 100, 5, 2);
        getFindTimeMap(treeMap, 100, 5, 3);
        getDeleteTimeMap(treeMap, 100, 5, 4);
    }

////////////////////////////////////// get Time for  LIST ////////////////////////////////////////

    public void getInsertTimeList(List<Integer> list, int row, int col) {
        long start = System.nanoTime();
        for (int i = 0; i < this.count; ++i) {
            list.add(i);
        }
        long end = System.nanoTime();
        this.table[row][col] = end - start;
    }
    public void getSearchIndexTimeList(List<Integer> list, int index, int row, int col) {
        long start = System.nanoTime();
        list.get(index);
        long end = System.nanoTime();
        this.table[row][col] = end - start;
    }
    public void getFindTimeList(List<Integer> list, int number, int row, int col) {
        long start = System.nanoTime();
        list.contains(number);
        long end = System.nanoTime();
        this.table[row][col] = end - start;

    }
    public void getDeleteTimeList(List<Integer> list, int index, int row, int col) {
        long start = System.nanoTime();
        list.remove(index);
        long end = System.nanoTime();
        this.table[row][col] = end - start;
    }

////////////////////////////////////// get Time for  SET ////////////////////////////////////////

    public void getInsertTimeSet(Set<Integer> set, int row, int col) {
        long start = System.nanoTime();
        for (int i = 0; i < this.count; ++i) {
            set.add(i);
        }
        long end = System.nanoTime();
        this.table[row][col] = end - start;
    }
    public void getFindTimeSet(Set<Integer> set, int number, int row, int col) {
        long start = System.nanoTime();
        set.contains(number);
        long end = System.nanoTime();
        this.table[row][col] = end - start;

    }
    public void getDeleteTimeSet(Set<Integer> set, int index, int row, int col) {
        long start = System.nanoTime();
        set.remove(index);
        long end = System.nanoTime();
        this.table[row][col] = end - start;
    }

////////////////////////////////////// get Time for  MAP ////////////////////////////////////////

    public void getInsertTimeMap(Map<Integer, Integer> map, int row, int col) {
        long start = System.nanoTime();
        for (int i = 0; i < this.count; ++i) {
            map.put(i,100);
        }
        long end = System.nanoTime();
        this.table[row][col] = end - start;
    }
    public void getSearchIndexTimeMap(Map<Integer, Integer> map, int index, int row, int col) {
        long start = System.nanoTime();
        map.get(index);
        long end = System.nanoTime();
        this.table[row][col] = end - start;
    }
    public void getFindTimeMap(Map<Integer, Integer> map, int number, int row, int col) {
        long start = System.nanoTime();
        map.containsValue(number);
        long end = System.nanoTime();
        this.table[row][col] = end - start;

    }
    public void getDeleteTimeMap(Map<Integer, Integer> map, int index, int row, int col) {
        long start = System.nanoTime();
        map.remove(index);
        long end = System.nanoTime();
        this.table[row][col] = end - start;
    }


////////////////////////////////////// PRINT ////////////////////////////////////////

    public void printTable() {
        System.out.println("\n*** Print times for action in nanosecond ***\n");
        String[] types = {"type", "insert", "search", "find", "delete"};
        System.out.println("Type\tinsert\tfind\tdelete\tsearch");
        System.out.println("-----------------------------------------------");
        for(int i = 0; i < 6; ++i) {
            for(int j = 0; j < 5; ++j) {
                System.out.print(this.table[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
