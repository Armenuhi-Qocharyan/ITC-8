/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.ArrayList;

/**
 *
 * @author xacho
 */
public class testArrayList {
    private final ArrayList<Integer> arr;
    private int membersNumber;
    
    public testArrayList(int membersNumber) {
        this.membersNumber = membersNumber;
        this.arr = new ArrayList<Integer>();
    }
    
    
    public void addArrayList() {
        long startTime = System.nanoTime();
        for (int i = 0; i < membersNumber; ++i) {
            this.arr.add(i);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/3600;
        System.out.print(" " + duration );
        for (int i = 0; i < (7 - this.getNumberLength(duration)); i++) {
            System.out.print(" ");
        }
        System.out.print("|");
    }
    
    public int getByValue() {
        long startTime = System.nanoTime();
        Integer a = this.membersNumber / 2;
        int result = this.arr.indexOf(a);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/3600;
        System.out.print(" " + duration );
        for (int i = 0; i < (11 - this.getNumberLength(duration)); i++) {
            System.out.print(" ");
        }
        System.out.print("|");
        return result;
    }
    
    public boolean deleteFromList() {
        long startTime = System.nanoTime();
        Integer a = this.membersNumber / 2;
        boolean result = this.arr.remove(a);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/3600;
        System.out.print(" " + duration );
        for (int i = 0; i < (7 - this.getNumberLength(duration)); i++) {
            System.out.print(" ");
        }
        System.out.print("|");
        return result;
    }
    
    public Integer getByIndex() {
        long startTime = System.nanoTime();
        Integer a = this.membersNumber / 2;
        int result = this.arr.get(a);
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
