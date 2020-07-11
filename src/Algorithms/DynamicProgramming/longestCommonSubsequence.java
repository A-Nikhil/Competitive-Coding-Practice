package Algorithms.DynamicProgramming;

public class longestCommonSubsequence {
	private static int[][] table;

	public static void main(String[] args) {
//		String X = "AGGTAB";
//		String Y = "GXTXAYB";
//		int m = X.length();
//		int n = Y.length();
		String X = "ABCDGH";
		String Y = "ACDGHR";
		int m = X.length();
		int n = Y.length();
		System.out.println(lengthOfLCS(X, Y, m, n));
		System.out.println(findLCS(X, Y, m, n));
	}

	private static int lengthOfLCS(String a, String b, int m, int n) {
		table = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == 0 || j == 0) {
					table[i][j] = 0;
				}
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					table[i][j] = table[i - 1][j - 1] + 1;
				} else {
					table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
				}
			}
		}
		return table[m][n];
	}

	private static String findLCS(String a, String b, int m, int n) {
		String lcs = "";
		int i = m, j = n;
		while (i > 0 && j > 0) {
			if (a.charAt(i - 1) == b.charAt(j - 1)) {
				lcs = a.charAt(i - 1) + lcs;
				i--;
				j--;
			} else if (table[i - 1][j] > table[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}
		return lcs;
	}
}
