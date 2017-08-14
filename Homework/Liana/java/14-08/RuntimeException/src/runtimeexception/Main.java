import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int data;
        System.out.print("Enter Number (< 50): ");
        while (!scanner.hasNextInt()) {
            System.out.print("Incorrect input. Enter integer number: ");
            scanner.next();
        }
        data = scanner.nextInt();
        if (data > 50) {
            throw new MyException("Too big number!");
        }
    }
}
