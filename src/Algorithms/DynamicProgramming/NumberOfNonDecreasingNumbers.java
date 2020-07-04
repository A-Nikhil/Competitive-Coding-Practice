package Algorithms.DynamicProgramming;

public class NumberOfNonDecreasingNumbers {
	public static void main(String[] args) {
		System.out.println(getNumber(1));
		System.out.println(getNumber(2));
		System.out.println(getNumber(3));
	}

	private static long getNumber(int n) {
		if (n == 1) {
			return 10L;
		}

		long count = 1L, N = 10;
		for (int i = 1; i <= n; i++) {
			count *= (N + i - 1);
			count /= i;
		}
		return count;
	}
}
