/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;


/**
 *
 * @author student
 */
public class Collections {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        testArrayList testArr = new testArrayList();
        testHashMap testMap = new testHashMap();
        //addHashMap(hash);
        System.out.println(" ___________________________________________________");
        System.out.println("| Collection | Insert | Index | Delete | getElement |");
        System.out.println("|---------------------------------------------------|");
        System.out.print("| ArrayList  |");
        /*ArrayLis*/
        testArr.addArrayList();
        testArr.getByValue();
        testArr.deleteFromList();
        testArr.getByIndex();
        System.out.println("|---------------------------------------------------|");
        /*HashMap*/
        System.out.print("|  HashMap   |");
        testMap.addHashMap();
        testMap.getByValue();
        testMap.deleteFromHashMap();
        testMap.getByKey();
        System.out.println("|---------------------------------------------------|");
    }

}
