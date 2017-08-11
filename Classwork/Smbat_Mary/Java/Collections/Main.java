import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    private static long[][] result;
    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        Integer item = 7;
        int row = 0;
        result = new long[5][4];
        
        
        // Estimate array list
        ArrayList<Integer> arrayList = new ArrayList<>();
        estimateList(arrayList, size, item, row); 
        ++row;
        
        // Estimate linked list
        LinkedList<Integer> linkedList = new LinkedList<>();
        estimateList(linkedList, size, item, row); 
        ++row;
        
        // Estimate hash map
        HashMap<Integer, Integer> hashmap = new HashMap<>(); 
        estimateMap(hashmap, size, item, row);
        ++row;
        
        // Estimate set
        HashSet<Integer> hashSet = new HashSet<>(); 
        estimateSet(hashSet, size, row);
        ++row;
        
        // Estimate sorted set
        TreeSet<Integer> treeSet = new TreeSet<>();
        estimateSet(treeSet, size, row);
        
        report(size);
    }
    
    private static void report(int size) {
 	String[] collections = {"ArrayList", "LinkedList", "HashMap", "HashSet", "TreeSet"};
	String[] criteries = {"insert", "find", "delete", "index"};

	// Get max length of collections name
	int colLength = collections[0].length();
	for (int i = 1; i < collections.length; ++i) {
	    if (collections[i].length() > colLength) {
        	colLength = collections[i].length();
    	    }
	}
	
	// Get max length of criteries
	int critLength = criteries[0].length();
	for (int i = 1; i < criteries.length; ++i) {
	    if (criteries[i].length() > critLength) {
		critLength = criteries[i].length();
	    }
	}

	// Print first line
	for (int i = 0; i < colLength; ++i) {
	    System.out.print(" ");
	}
	for (int i = 0; i < criteries.length; ++i) {
	    System.out.print(" | " + criteries[i]);
	    for (int j = 0; j < critLength - criteries[i].length(); ++j) {
	    	System.out.print(" ");
	    }
	}
	System.out.println();
	for (int j = 0; j < colLength; ++j) {
	    System.out.print("-");
	}
	for (int i = 0; i < 4; ++i) {
	    System.out.print("-+-");
	    for (int j = 0; j < critLength; ++j) {
	    	System.out.print("-");
	    }
	}
        System.out.println();


        for (int i = 0; i < 5; ++i) {
	    // Print first column
	    System.out.print(collections[i]);
	    for (int j = 0; j < colLength - collections[i].length(); ++j) {
		System.out.print(" ");
	    }
	     
	    // Print estimated time
            for (int j = 0; j < 4; ++j) {
		if (result[i][j] != -1) {
                    System.out.print(" | " + result[i][j]);
		} else {
                    System.out.print(" |   ");
		}
	    	for (int k = 0; k < critLength - String.valueOf(result[i][j]).length(); ++k) {
	    	    System.out.print(" ");
	    	}
            }
            System.out.println();
	    for (int j = 0; j < colLength; ++j) {
		System.out.print("-");
	    }
	    for (int j = 0; j < 4; ++j) {
	    	System.out.print("-+-");
	    	for (int k = 0; k < critLength; ++k) {
	    	    System.out.print("-");
	    	}
	    }
            System.out.println();
        }
    }
    
    private static void estimateList(List<Integer> list, int size, int item, int row) {
        long startTime;
        long finishTime;
                
        // Add items to array list
        startTime = System.nanoTime();
        for (int i = 0; i < size; ++i) {
            list.add(item);
        }
        finishTime = System.nanoTime();
        result[row][0] = (finishTime - startTime);
        
        // Get element by index and replace
        startTime = System.nanoTime();
        list.set(size * 3 / 4, 9);
        finishTime = System.nanoTime();
        result[row][3] = finishTime - startTime;
        
        // Find item in array list
        startTime = System.nanoTime();
        int index = list.indexOf(9);
        finishTime = System.nanoTime();
        result[row][1] = finishTime - startTime;
        
        // Remove element from
        startTime = System.nanoTime();
        list.remove(size / 2);
        finishTime = System.nanoTime();
        result[row][2] = finishTime - startTime;
    }
    
    private static void estimateMap(Map<Integer, Integer> map, int size, int item, int row) {
        long startTime;
        long finishTime;
                
        // Add items to map
        startTime = System.nanoTime();
        for (int i = 0; i < size; ++i) {
            map.put(i, item);
        }
        finishTime = System.nanoTime();
        result[row][0] = finishTime - startTime;
        
        // Get element by key and replace
        startTime = System.nanoTime();
        map.put(size * 3 / 4, 9);
        finishTime = System.nanoTime();
        result[row][3] = finishTime - startTime;
        
        // Find item in map
        startTime = System.nanoTime();
        map.containsValue(9);
        finishTime = System.nanoTime();
        result[row][1] = finishTime - startTime;
        
        // Remove element from map
        startTime = System.nanoTime();
        map.remove(size / 2);
        finishTime = System.nanoTime();
        result[row][2] = finishTime - startTime;
    }
    
    private static void estimateSet(Set<Integer> set ,int size, int row) {
        long startTime;
        long finishTime;
                
        // Add items to set
        startTime = System.nanoTime();
        for (int i = size; i > 0 ; --i) {
            set.add(i);
        }
        finishTime = System.nanoTime();
        result[row][0] = finishTime - startTime;
        
        // Get element by index
        result[row][3] = -1;
        
        // Find item in set
        startTime = System.nanoTime();
        set.contains(size * 3 / 4);
        finishTime = System.nanoTime();
        result[row][1] = finishTime - startTime;
        
        // Remove element from set
        startTime = System.nanoTime();
        set.remove(size / 2);
        finishTime = System.nanoTime();
        result[row][2] = finishTime - startTime;
    }
}
