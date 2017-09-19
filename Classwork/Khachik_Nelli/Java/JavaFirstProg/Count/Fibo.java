package Count;

public class Fibo {
	public int fibonachi(int n) {
		if(n <= 2) {
			return 1;
		} 
		return fibonachi(n - 1) + fibonachi(n - 2);
	}
}
