import java.util.*;
import Count.*;
import Print.*;

public class Main {
	public static void main(String[] args) {
		int n;
		System.out.println("Input number");
		Scanner S=new Scanner(System.in);
		n=S.nextInt();
		Fibo fibo = new Fibo();
		Num num = new Num();
		Roman rom = new Roman();
		Fact fact = new Fact();
		num.printNumeric(fibo.fibonachi(n));
		num.printNumeric(fact.factorial(n));			
		rom.integerToRoman(fibo.fibonachi(n));
		rom.integerToRoman(n);			
	}

}
