import Calculate.*;
import Print.*;


public class Main {
    public static void main(String[] args) {
	int fib = Fibonachi.fib(5);
	int fact = Factorial.fact(5);
	System.out.println("Fibonachi's 5th member: " + fib);
	Roman.print(fib);
	System.out.println("Factorial for 5: " + fact);
	Numeric.print(fact);
    }
}
