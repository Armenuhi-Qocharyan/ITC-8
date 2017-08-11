import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Collection {

    public static void main(String[] args) {
        List <Integer> arrayList = createList(new ArrayList <Integer>(), 100000);
        List <Integer> linkedList = createList(new LinkedList <Integer>(), 100000);
        Map <Integer, Integer> hashMap = createMap(new HashMap <Integer, Integer>(), 100000);
        Map <Integer, Integer> treeMap = createMap(new TreeMap <Integer, Integer>(), 100000);
        Set <Integer> hashSet = createSet(new HashSet <Integer>(),100000);
        Set <Integer> treeSet = createSet(new TreeSet <Integer>(),100000);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Object columnNames[] = {"Collections", "Index", "Find", "Delete", "Insert"};
        Object rowData[][] = {
            {"LinkedList", getElementByIndex(linkedList, 500), getElementByValue(linkedList, 500), deleteElement(linkedList, 500), insertElement(linkedList, 500)},
            {"ArrayList", getElementByIndex(arrayList, 500), getElementByValue(arrayList, 500), deleteElement(arrayList, 500), insertElement(arrayList, 500)},
            {"HashMap", getElementByIndex(hashMap, 500), getElementByValue(hashMap, 500), deleteElement(hashMap, 500), insertElement(hashMap, 500)},
            {"TreeMap", getElementByIndex(treeMap, 500), getElementByValue(treeMap, 500), deleteElement(treeMap, 500), insertElement(treeMap, 500)},
            {"HashSet", getElementByIndex(hashSet, 500), getElementByValue(hashSet, 500), deleteElement(hashSet, 500), insertElement(hashSet, 500)},
            {"TreeSet", getElementByIndex(treeSet, 500), getElementByValue(treeSet, 500), deleteElement(treeSet, 500), insertElement(treeSet, 500)}

        };
        JTable table = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(500, 200);
        frame.setVisible(true);

    }

    public static List <Integer> createList(List<Integer> list, int size) {
        for (int i = 0; i < size; ++i) {
            list.add(i);
        }
        return list;
    }

    public static Map <Integer, Integer> createMap(Map<Integer, Integer> map, int size) {
        for (int i = 0; i < size; ++i) {
            map.put(i, i);
        }
        return map;
    }
    
    public static Set <Integer> createSet(Set <Integer> set, int size) {
        for (int i = 0; i < size; ++i) {
            set.add(i);
        }
        return set;
    }

    public static long getElementByIndex(List<Integer> list, int index) {
        long startTime = System.nanoTime();
        list.get(index);
        long endTime = System.nanoTime();

        return (endTime - startTime);
    }

    public static long getElementByValue(List<Integer> list, int value) {
        long startTime = System.nanoTime();
        list.contains(value);
        long endTime = System.nanoTime();
        return (endTime - startTime);

    }

    public static long deleteElement(List<Integer> list, int index) {
        long startTime = System.nanoTime();
        list.remove(index);
        long endTime = System.nanoTime();
        return (endTime - startTime);
    }

    public static long insertElement(List<Integer> list, int value) {
        long startTime = System.nanoTime();
        list.add(value, value);
        long endTime = System.nanoTime();
        return (endTime - startTime);
    }

    public static long getElementByIndex(Map <Integer, Integer> map, int index) {
        long startTime = System.nanoTime();
        map.get(index);
        long endTime = System.nanoTime();
        return (endTime - startTime);
    }

    public static long getElementByValue(Map <Integer, Integer> map, int value) {
        long startTime = System.nanoTime();
        map.containsValue(value);
        long endTime = System.nanoTime();
        return (endTime - startTime);

    }

    public static long deleteElement(Map <Integer, Integer> map, int index) {
        long startTime = System.nanoTime();
        map.remove(index);
        long endTime = System.nanoTime();
        return (endTime - startTime);
    }

    public static long insertElement(Map <Integer, Integer> map, int value) {
        long startTime = System.nanoTime();
        map.put(value, value);
        long endTime = System.nanoTime();
        return (endTime - startTime);
    }

        public static long getElementByIndex(Set <Integer> set, int index) {
        long startTime = System.nanoTime();
        // set.
        long endTime = System.nanoTime();

        return (endTime - startTime);
    }

    public static long getElementByValue(Set <Integer> set, int value) {
        long startTime = System.nanoTime();
        set.contains(value);
        long endTime = System.nanoTime();
        return (endTime - startTime);

    }

    public static long deleteElement(Set <Integer> set, int index) {
        long startTime = System.nanoTime();
        set.remove(index);
        long endTime = System.nanoTime();
        return (endTime - startTime);
    }

    public static long insertElement(Set <Integer> set, int value) {
        long startTime = System.nanoTime();
        set.add(value);
        long endTime = System.nanoTime();
        return (endTime - startTime);
    }

}

