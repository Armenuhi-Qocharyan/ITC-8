/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author student
 */
public class Collections {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        HashMap<String,String> hash = new HashMap<String, String>();
        
        
        long startTime = System.nanoTime();
        addArrayList(arr);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("ArrayList insert time - " + duration / 3600);
        
        startTime = System.nanoTime();
        int a = sizeOfList(arr);
        endTime = System.nanoTime();
        duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("ArrayList find time - " + duration / 3600);
        
        startTime = System.nanoTime();
        boolean b = deleteFromList(arr);
        endTime = System.nanoTime();
        duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("ArrayList delete time - " + duration / 3600);
        
        startTime = System.nanoTime();
        Integer c = listIndex(arr);
        endTime = System.nanoTime();
        duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("ArrayList get by index time - " + duration / 3600);
        
        addHashMap(hash);
    }
    /*ArrayList*/
    public static void addArrayList(ArrayList<Integer> arr) {
        for (int i = 0; i < 1000; ++i) {
            arr.add(i);
        }
    }
    
    public static int sizeOfList(ArrayList<Integer> arr) {
        Integer a = 500;
        return arr.indexOf(a);
    }
    
    public static boolean deleteFromList(ArrayList<Integer> arr) {
        Integer a = 500;
        return arr.remove(a);
    }
    
    public static Integer listIndex(ArrayList<Integer> arr) {
        Integer a = 500;
        return arr.get(a);
    }
    
    /*HashMap*/
    public static void addHashMap(HashMap<String,String> hash) {
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; ++i) {
            String key = "key" + i;
            String value = "value" + i;
            hash.put(key, value);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("HashMAp insert time - " + duration / 3600);
    }
}
