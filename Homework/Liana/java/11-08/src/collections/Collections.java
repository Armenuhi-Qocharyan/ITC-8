/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author liana
 */
public class Collections {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        System.out.print("Enter collection elements count: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Incorrect input. Enter integer number: ");
            scanner.next();
        }
        size = scanner.nextInt();
        analyseList(size);
        analyseMap(size);

    }

    private static void analyseList(int size) {
        ArrayList<ArrayList<String>> result = new ArrayList();
        result.add(new ArrayList<String>());
        ArrayList<Integer> arrayList = new ArrayList();
        createList(arrayList, size);
        result.get(0).add(0, "ArrayList");
        result.get(0).add(1, Long.toString(addItem(arrayList)));
        result.get(0).add(2, Long.toString(deleteItem(arrayList)));
        result.get(0).add(3, Long.toString(findItem(arrayList)));
        LinkedList<Integer> linkedList = new LinkedList();
        createList(linkedList, size);
        result.add(new ArrayList<String>());
        result.get(1).add(0, "LinkedList");
        result.get(1).add(1, Long.toString(addItem(linkedList)));
        result.get(1).add(2, Long.toString(deleteItem(linkedList)));
        result.get(1).add(3, Long.toString(findItem(linkedList)));
        print(result);

    }

    private static void analyseMap(int size) {
        ArrayList<ArrayList<String>> result = new ArrayList();
        result.add(new ArrayList<>());
        HashMap<Integer, String> hashMap = new HashMap<>();
        createMap(hashMap, size);
        result.get(0).add(0, "HashMap\t");
        result.get(0).add(1, Long.toString(add(hashMap)));
        result.get(0).add(2, Long.toString(remove(hashMap)));
        result.get(0).add(3, Long.toString(findValue(hashMap)));
        result.add(new ArrayList<>());
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        createMap(treeMap, size);
        result.get(1).add(0, "TreeMap\t");
        result.get(1).add(1, Long.toString(add(treeMap)));
        result.get(1).add(2, Long.toString(remove(treeMap)));
        result.get(1).add(3, Long.toString(findValue(treeMap)));
        result.add(new ArrayList<>());
        HashSet<Integer> hashSet = new HashSet();
        createSet(hashSet, size);
        result.get(2).add(0, "HashSet\t");
        result.get(2).add(1, Long.toString(add(hashSet)));
        result.get(2).add(2, Long.toString(remove(hashSet)));
        result.get(2).add(3, Long.toString(findValue(hashSet)));
        print(result);
    }

    private static void createList(List list, int size) {
        for (int i = 0; i < size; ++i) {
            list.add(i);
        }
    }

    private static long addItem(List list) {
        long startTime = System.nanoTime();
        list.add(5);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        return duration;
    }

    private static long deleteItem(List list) {
        Integer a = 5;
        long startTime = System.nanoTime();
        list.remove(a);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        return duration;
    }

    private static long findItem(List list) {
        long startTime = System.nanoTime();
        list.indexOf(5);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        return duration;
    }

    private static void print(ArrayList<ArrayList<String>> result) {
        System.out.println("\nResults for collections insert, find, remove operations speed (nanoseconds)");
        System.out.println("\nCollection\tinsert\tfind\tremove");
        int length = result.size();
        int rowLen = result.get(0).size();
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < rowLen; ++j) {
                System.out.print(result.get(i).get(j));
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    private static void createMap(Map map, int size) {
        for (int i = 0; i < size; ++i) {
            map.put(i, "a");
        }
    }

    private static long add(Map<Integer, String> hashMap) {

        long startTime = System.nanoTime();
        hashMap.put(5, "b");
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        return duration;

    }

    private static long remove(Map<Integer, String> hashMap) {
        long startTime = System.nanoTime();
        hashMap.remove(5);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        return duration;
    }

    private static long findValue(Map<Integer, String> hashMap) {
        long startTime = System.nanoTime();
        hashMap.get(5);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        return duration;
    }

    private static void createSet(HashSet<Integer> hashSet, int size) {

    }

    private static long add(HashSet<Integer> hashSet) {
        long startTime = System.nanoTime();
        hashSet.add(5);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        return duration;
    }

    private static long remove(HashSet<Integer> hashSet) {
        long startTime = System.nanoTime();
        hashSet.remove(5);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        return duration;

    }

    private static long findValue(HashSet<Integer> hashSet) {
        long startTime = System.nanoTime();
        hashSet.contains(5);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        return duration;
    }

}
