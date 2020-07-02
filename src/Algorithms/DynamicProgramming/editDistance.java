package Algorithms.DynamicProgramming;

public class editDistance {
	public static void main(String[] args) {
		String a = "CART", b = "MARCH";
		System.out.println(findEditDistance(a, b, a.length(), b.length()));
	}

	private static int findEditDistance(String s1, String s2, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0) {
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else {
					if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
						dp[i][j] = dp[i - 1][j - 1];
					} else {
						dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),
								dp[i - 1][j - 1]) + 1;
					}
				}
			}
		}
		return dp[m][n];
	}
}
