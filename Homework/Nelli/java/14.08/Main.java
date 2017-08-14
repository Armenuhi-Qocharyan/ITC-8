import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int data;
        System.out.print("Enter not 0 number : ");
        data = scanner.nextInt();
        if (data == 0) {
            throw new MyException("number can't be 0!");
        }
    }
}
