package Algorithms.DynamicProgramming;

public class SameSumTwoHalvesSubstring {
	public static void main(String[] args) {
		String str = "153803";
		System.out.println(findLength(str, str.length()));
	}

	private static int findLength(String str, int n) {
		int[] sum = new int[n + 1];
		int ans = 0, i, len;
		sum[0] = 0;
		for (i = 1; i <= n; i++) {
			sum[i] = sum[i - 1] + (str.charAt(i - 1) - '0');
		}
		for (len = 2; len <= n; len++) { // length of substring
			for (i = 0; i <= n - len; i++) {
				if ((sum[i + len / 2] - sum[i]) == (sum[i + len] - sum[i + len / 2])) {
					ans = Math.max(ans, len);
				}
			}
		}
		return ans;
	}
}
