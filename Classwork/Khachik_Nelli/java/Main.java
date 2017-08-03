import actions.Operations;
import java.util.*;


public class Main {
	public static void main(String[] args) {
		int length1;
		int length2;
		Scanner scan = new Scanner(System.in);
		System.out.println("Input first array length");
		length1 = scan.nextInt();
		System.out.println("Input second array length");
		length2 = scan.nextInt();
		int[] arr1 = new int[length1];
		int[] arr2 = new int[length2];
		for(int i = 0; i < length1; ++i) {
			arr1[i] = scan.nextInt();
		}	
		for(int i = 0; i < length2; ++i) {
			arr2[i] = scan.nextInt();
		}
		Operations obj1 = new Operations();
		int[] res = obj1.sum(arr1, arr2);
		System.out.println("\n");

		for(int i = 0; i < res.length; ++i) {
			System.out.println(res[i]);
		}
	}
}
