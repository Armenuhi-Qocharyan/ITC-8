import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter size of the first array: ");
        int size = reader.nextInt();
        Array arr1 = new Array(size);
        arr1.setArray();

        System.out.print("\nEnter size of the second array: ");
        size = reader.nextInt();
        Array arr2 = new Array(size);
        arr2.setArray();

        System.out.println();
        arr1.print();
        arr2.print();

        Array sum = arr1.add(arr2);
        System.out.print("\nSum of two arrays: ");
        sum.print();

        Array diff = arr1.diff(arr2);
        System.out.print("\nDiff of two arrays: ");
        diff.print();

        Array mult = arr1.mult(arr2);
        System.out.print("\nProduct of two arrays: ");
        mult.print();
    }       
}
