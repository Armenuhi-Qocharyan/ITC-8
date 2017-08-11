import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Main {
    private static String[] collections = {"ArrayList", "LinkedList", "HashMap", "HashSet", "TreeSet"};
    private static String[] criteries = {"insert", "find", "delete", "index"};

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Error: Invalid number of command line arguments.");
            return;
        }

        int size = Integer.parseInt(args[0]);
        Integer item = 7;
        int row = 0;
        int height = collections.length;
        int width = criteries.length;
        Estimate.setResult(height, width);
        
        // Estimate array list
        ArrayList<Integer> arrayList = new ArrayList<>();
        Estimate.estimateList(arrayList, size, item, row); 
        ++row;
        
        // Estimate linked list
        LinkedList<Integer> linkedList = new LinkedList<>();
        Estimate.estimateList(linkedList, size, item, row); 
        ++row;
        
        // Estimate hash map
        HashMap<Integer, Integer> hashmap = new HashMap<>(); 
        Estimate.estimateMap(hashmap, size, item, row);
        ++row;
        
        // Estimate set
        HashSet<Integer> hashSet = new HashSet<>(); 
        Estimate.estimateSet(hashSet, size, row);
        ++row;
        
        // Estimate sorted set
        TreeSet<Integer> treeSet = new TreeSet<>();
        Estimate.estimateSet(treeSet, size, row);
        
        report(size, height, width);
    }
    
    private static void report(int size, int height, int width) {
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
        critLength += 3;
        
        long[][] result = Estimate.getResult();
	System.out.println("\nGiven estimation for  " + size + "  elements in collections in nanoseconds:\n");
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
	for (int i = 0; i < width; ++i) {
	    System.out.print("-+-");
	    for (int j = 0; j < critLength; ++j) {
	    	System.out.print("-");
	    }
	}
        System.out.println();


        for (int i = 0; i < height; ++i) {
	    // Print first column
	    System.out.print(collections[i]);
	    for (int j = 0; j < colLength - collections[i].length(); ++j) {
		System.out.print(" ");
	    }
	     
	    // Print estimated time
            for (int j = 0; j < width; ++j) {
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
	    for (int j = 0; j < width; ++j) {
	    	System.out.print("-+-");
	    	for (int k = 0; k < critLength; ++k) {
	    	    System.out.print("-");
	    	}
	    }
            System.out.println();
        }
    }
}
