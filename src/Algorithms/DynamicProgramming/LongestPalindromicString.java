package Algorithms.DynamicProgramming;

public class LongestPalindromicString {
	public static void main(String[] args) {
		System.out.println(longestPalindromic("forgeeksskeegfor"));
	}

	private static int longestPalindromic(String str) {
		int n = str.length();
		boolean[][] table = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			table[i][i] = true;
		}
		int maxlength = 0, start = 0;

		for (int i = 0; i < n - 1; ++i) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				table[i][i + 1] = true;
				start = i;
				maxlength = 2;
			}
		}
		for (int k = 3; k <= n; k++) {
			for (int i = 0; i < n - k + 1; i++) {
				int j = i + k - 1;
				if (table[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
					table[i][j] = true;
					if (maxlength < k) {
						start = i;
						maxlength = k;
					}
				}
			}
		}
		System.out.println(str.substring(start, start + maxlength));
		return maxlength;
	}
}
