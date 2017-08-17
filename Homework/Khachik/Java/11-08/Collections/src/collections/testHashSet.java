/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.HashSet;

/**
 *
 * @author xacho
 */
public class testHashSet {
    private final HashSet<Integer> hash;
    private int membersNumber;
    
    public testHashSet(int membersNumber) {
        this.membersNumber= membersNumber;
        this.hash = new HashSet<Integer>();
    }
    
    public void addHashSet() {
        long startTime = System.nanoTime();
        for(int i = 0; i < membersNumber; ++i) {
            hash.add(i);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/3600;
        System.out.print(" " + duration );
        for (int i = 0; i < (7 - this.getNumberLength(duration)); i++) {
            System.out.print(" ");
        }
        System.out.print("|");
    }
    
    public boolean getByValue() {
        long startTime = System.nanoTime();
        Integer a = membersNumber / 2;
        boolean result = hash.contains(a);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/3600;
        System.out.print(" " + duration );
        for (int i = 0; i < (11 - this.getNumberLength(duration)); i++) {
            System.out.print(" ");
        }
        System.out.print("|");
        return result;
    }
    
    public boolean deleteFromHashSet() {
        long startTime = System.nanoTime();
        Integer a = membersNumber / 2;
        boolean result = hash.remove(a);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/3600;
        System.out.print(" " + duration );
        for (int i = 0; i < (7 - this.getNumberLength(duration)); i++) {
            System.out.print(" ");
        }
        System.out.print("|");
        return result;
    }
    
    public void getByIndex() {
        System.out.print("    NULL    |\n");
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
