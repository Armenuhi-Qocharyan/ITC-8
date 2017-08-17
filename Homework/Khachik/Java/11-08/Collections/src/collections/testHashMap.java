/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xacho
 */
public class testHashMap {
    public HashMap<String,String> hash;
    private int membersNumber;

    public testHashMap(int membersNumber) {
        this.membersNumber = membersNumber;
        this.hash = new HashMap<String, String>();
    }
    
    public  void addHashMap() {
        long startTime = System.nanoTime();
        for (int i = 0; i < membersNumber; ++i) {
            String key = "key" + i;
            String value = "value" + i;
            this.hash.put(key, value);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/3600;  //divide by 1000000 to get milliseconds.
        System.out.print(" " + duration );
        for (int i = 0; i < (7 - this.getNumberLength(duration)); i++) {
            System.out.print(" ");
        }
        System.out.print("|");
    }
    
    public String getByValue() {
        long startTime = System.nanoTime();
        String result = null;
        String value = "value";
        
        for (String str : hash.keySet()) {
            if (hash.get(str).equals(value)) {
                result = str;
            }
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/3600;
        System.out.print(" " + duration );
        for (int i = 0; i < (11 - this.getNumberLength(duration)); i++) {
            System.out.print(" ");
        }
        System.out.print("|");
        return result;
    }
    
    public boolean deleteFromHashMap () {
        long startTime = System.nanoTime();
        boolean result = hash.remove("key", "value");
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/3600;
        System.out.print(" " + duration );
        for (int i = 0; i < (7 - this.getNumberLength(duration)); i++) {
            System.out.print(" ");
        }
        System.out.print("|");
        return result;
    }
    
    public String getByKey() {
        long startTime = System.nanoTime();
        String result = null;
        result = hash.get("key");
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/3600;
        System.out.print(" " + duration );
        for (int i = 0; i < (11 - this.getNumberLength(duration)); i++) {
            System.out.print(" ");
        }
        System.out.print("|\n");
        return result;
    }
    
    public Integer getNumberLength(long arg1) {
        int length = 0;
        do {
            arg1 /= 10;
            length++;
        } while(arg1 > 0);
        return length;
    }
}
