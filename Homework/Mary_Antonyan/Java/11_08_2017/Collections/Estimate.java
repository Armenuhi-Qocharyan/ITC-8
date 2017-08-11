import java.util.List;
import java.util.Map;
import java.util.Set;

public class Estimate {
    private static long[][] result;

    public static void setResult(int height, int width) {
        result = new long[height][width];
    }

    public static long[][] getResult() {
        return result;
    }

    public static void estimateList(List<Integer> list, int size, int item, int row) {
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

    public static void estimateMap(Map<Integer, Integer> map, int size, int item, int row) {
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

    public static void estimateSet(Set<Integer> set ,int size, int row) {
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
