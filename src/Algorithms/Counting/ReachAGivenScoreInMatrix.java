package Algorithms.Counting;

import java.util.Arrays;

public class ReachAGivenScoreInMatrix {
	private static int[][][] dp;

	private static int numberOfPaths(int[][] mat, int i, int j, int m) {
		if (i == 0 && j == 0) {
			if (m == mat[0][0]) {
				return 1;
			} else {
				return 0;
			}
		}

		// Sum becomes negative
		if (m < 0) {
			return 0;
		}

		if (i < 0 || j < 0) {
			return 0;
		}

		if (dp[i][j][m] != -1) {
			return dp[i][j][m];
		}

		dp[i][j][m] = numberOfPaths(mat, i - 1, j, m - mat[i][j])
				+ numberOfPaths(mat, i, j - 1, m - mat[i][j]);

		return dp[i][j][m];
	}

	public static void main(String[] args) {
		int[][] mat = {{1, 1, 1},
				{1, 1, 1},
				{1, 1, 1}};
		int m = 5, n = 3;
		dp = new int[n][n][30];
		for (int[][] arr1 : dp) {
			for (int[] arr2 : arr1) {
				Arrays.fill(arr2, -1);
			}
		}
		System.out.println(numberOfPaths(mat, n - 1, n - 1, m));
	}
}
