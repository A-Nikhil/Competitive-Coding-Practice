package Algorithms.Counting;

import java.util.Arrays;

public class DivideNInGroupsOfK {
	private static final int[][][] dp = new int[500][500][500];

	private static int calculate(int pos, int prev, int left, int k) {
		if (pos == k) {
			if (left == 0) {
				return 1;
			} else {
				return 0;
			}
		}

		if (left == 0) {
			return 0;
		}

		if (dp[pos][prev][left] != -1) {
			return dp[pos][prev][left];
		}
		int ans = 0;
		for (int i = prev; i <= left; i++) {
			ans += calculate(pos + 1, i, left - i, k);
		}
		dp[pos][prev][left] = ans;
		return ans;
	}

	private static int getWays(int n, int k) {
		for (int[][] arr1 : dp) {
			for (int[] arr2 : arr1) {
				Arrays.fill(arr2, -1);
			}
		}
		return calculate(0, 1, n, k);
	}

	public static void main(String[] args) {
		int n = 24, k = 5;
		System.out.println(getWays(n, k));
	}
}
