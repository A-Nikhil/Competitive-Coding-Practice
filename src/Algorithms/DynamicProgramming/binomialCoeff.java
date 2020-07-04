package Algorithms.DynamicProgramming;

public class binomialCoeff {
	public static void main(String[] args) {
		System.out.println(returnCoeff(4, 2));
	}

	private static int returnCoeff(int n, int k) {
		int[][] c = new int[n + 1][k + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= Math.min(i, k); j++) {
				if (i == 0 || j == 0) {
					c[i][j] = 1;
				} else {
					c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
				}
			}
		}
		return c[n][k];
	}
}
