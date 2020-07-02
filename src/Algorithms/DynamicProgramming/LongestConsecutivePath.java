package Algorithms.DynamicProgramming;

import java.util.Arrays;

public class LongestConsecutivePath {
	private static final int[] rowMod = {0, 1, 1, -1, 1, 0, -1, -1},
			colMod = {1, 0, 1, 1, -1, -1, 0, -1};
	private static int R, C;
	private static int[][] dp;

	private static boolean isAdjacent(char prev, char curr) {
		return ((curr - prev) == 1);
	}

	private static boolean isValid(int i, int j) {
		return i >= 0 && j >= 0 && i < R && j < C;
	}

	private static int lengthRecur(char[][] mat, int i, int j, char prev) {
		if (!isValid(i, j) || !isAdjacent(prev, mat[i][j])) {
			return 0;
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int ans = 0;
		for (int k = 0; k < 8; k++) {
			ans = Math.max(ans, 1 + lengthRecur(mat, i + rowMod[k],
					j + colMod[k], mat[i][j]));
		}
		dp[i][j] = ans;
		return ans;
	}

	private static int getLength(char[][] mat, char s, int m, int n) {
		R = m;
		C = n;
		dp = new int[R][C];
		int ans = 0;
		for (int i = 0; i < R; i++) {
			Arrays.fill(dp[i], -1);
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (mat[i][j] == s) {
					for (int k = 0; k < 8; k++) {
						ans = Math.max(ans, 1 + lengthRecur(mat, i + rowMod[k],
								j + colMod[k], s));
					}
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		char[][] mat = {{'a', 'c', 'd'},
				{'h', 'b', 'a'},
				{'i', 'g', 'f'}};

		int r = 3, c = 3;
		System.out.println(getLength(mat, 'a', r, c));
		System.out.println(getLength(mat, 'e', r, c));
		System.out.println(getLength(mat, 'b', r, c));
		System.out.println(getLength(mat, 'f', r, c));
	}
}
