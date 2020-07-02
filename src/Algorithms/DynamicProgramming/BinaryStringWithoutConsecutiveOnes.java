/*
Approach =>
The approach here is to find Fibonacci on n
 */

package Algorithms.DynamicProgramming;

public class BinaryStringWithoutConsecutiveOnes {
	public static void main(String[] args) {
		int n = 5;
		System.out.println(getAnswer(n));
	}

	private static int getAnswer(int n) {
		int[] fibonacci = new int[n + 3];
		fibonacci[0] = 0;
		fibonacci[1] = 1;
		for (int i = 2; i <= n + 2; i++) {
			fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
		}
		return fibonacci[n + 2];
	}
}
