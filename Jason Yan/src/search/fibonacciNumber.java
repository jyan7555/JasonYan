package search;

public class fibonacciNumber {

	public static void main(String[] args) {
		System.out.println(fibNum(25));

	}
	public static int fibNum(int psn) {
		if (psn == 0 || psn == 1) {
			return 1;
		}
		else {
			return fibNum(psn-1) + fibNum(psn -2);
		}
	}
}
