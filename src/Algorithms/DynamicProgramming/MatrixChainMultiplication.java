package Algorithms.DynamicProgramming;

public class MatrixChainMultiplication {
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 30};
		System.out.println(matrixChain(arr, arr.length));
	}

	private static int matrixChain(int[] p, int n) {
		int[][] dp = new int[n][n];
		int i, l;
		for (i = 0; i < n; i++)
			dp[i][i] = 0;
		for (l = 1; l < n - 1; l++)
			for (i = 1; i < n - l; i++)
				dp[i][i + l] = Math.min(
						dp[i + 1][i + l] + p[i - 1] * p[i] * p[i + l],
						dp[i][i + l - 1] + p[i - 1] * p[i + l - 1] * p[i + l]
				);

		return dp[1][n - 1];
	}
}
