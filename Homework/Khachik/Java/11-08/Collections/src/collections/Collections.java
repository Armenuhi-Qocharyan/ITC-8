/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.Scanner;


/**
 *
 * @author student
 */
public class Collections {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = 0;
        do {
            System.out.print("Input Collections members number - ");
            try {
                num = in.nextInt();
            } catch (java.util.InputMismatchException ex) {
                System.out.println("Wrong input");
                return;
            }
        } while (num < 10);
        testArrayList testArr = new testArrayList(num);
        testHashMap testMap = new testHashMap(num);
        testHashSet testSet = new testHashSet(num);
        testTreeSet treeSet = new testTreeSet(num);
        //addHashMap(hash);
        System.out.println(" ________________________________________________________");
        System.out.println("| Collection | Insert | getByValue | Delete | getByIndex |");
        System.out.println("|--------------------------------------------------------|");
        System.out.print("| ArrayList  |");
        /*ArrayLis*/
        testArr.addArrayList();
        testArr.getByValue();
        testArr.deleteFromList();
        testArr.getByIndex();
        System.out.println("|--------------------------------------------------------|");
        /*HashMap*/
        System.out.print("|  HashMap   |");
        testMap.addHashMap();
        testMap.getByValue();
        testMap.deleteFromHashMap();
        testMap.getByKey();
        System.out.println("|--------------------------------------------------------|");
        /*HashSet*/
        System.out.print("|  HashSet   |");
        testSet.addHashSet();
        testSet.getByValue();
        testSet.deleteFromHashSet();
        testSet.getByIndex();
        System.out.println("|--------------------------------------------------------|");
        /*TreeSet*/
        System.out.print("|  TreeSet   |");
        treeSet.addTreeSet();
        treeSet.getByValue();
        treeSet.deleteFromTreeSet();
        treeSet.getByIndex();
        System.out.println("|--------------------------------------------------------|");
    }

}
