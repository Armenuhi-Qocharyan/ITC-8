/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author xacho
 */
public class testTreeSet {
    private final TreeSet<Integer> tree;
    private int membersNumber;

    public testTreeSet(int membersNumber) {
        this.membersNumber = membersNumber;
        this.tree = new TreeSet<>();
    }
    
    public void addTreeSet() {
        long startTime = System.nanoTime();
        for(int i = 0; i < membersNumber; ++i) {
            tree.add(i);
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
        boolean result = tree.contains(a);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/3600;
        System.out.print(" " + duration );
        for (int i = 0; i < (11 - this.getNumberLength(duration)); i++) {
            System.out.print(" ");
        }
        System.out.print("|");
        return result;
    }
    
    public boolean deleteFromTreeSet() {
        long startTime = System.nanoTime();
        Integer a = membersNumber / 2;
        boolean result = tree.remove(a);
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
