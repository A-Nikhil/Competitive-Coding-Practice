package Algorithms.DynamicProgramming;

public class DecodeWays {
	public static void main(String[] args) {
		String x = "226";
//		String x = "12";
//		String x = "01";
		System.out.println(numDecodings(x));
	}

	private static int numDecodings(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = 1;
		char c, p;
		for (int i = 1; i < s.length(); i++) {
			c = s.charAt(i);
			p = s.charAt(i - 1);

			// current is 0 and previous is greater than 30
			if (c == '0' && (p == '0' || p > '2')) {
				return 0;
			}

			if (p == '0') {
				dp[i + 1] = dp[i];
			} else if (p == '1') {
				if (c == '0') {
					dp[i + 1] = dp[i - 1];
				} else {
					dp[i + 1] = dp[i - 1] + dp[i];
				}
			} else if (p == '2') {
				if (c == '0') {
					dp[i + 1] = dp[i - 1];
				} else if (c <= '6') {
					dp[i + 1] = dp[i - 1] + dp[i];
				} else {
					dp[i + 1] = dp[i];
				}
			} else {
				dp[i + 1] = dp[i];
			}
		}
		return dp[s.length()];
	}
}
