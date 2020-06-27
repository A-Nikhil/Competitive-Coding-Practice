package dynamicProgramming;

public class MinNumberOfSquaresForGivenSum {
	public static void main(String[] args) {
		int n = 6;
		System.out.println(getSquares(n));
	}

	private static int getSquares(int n) {
		if (n <= 3) {
			return n;
		}

		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		int temp;
		for (int i = 4; i <= n; i++) {
			dp[i] = i;
			for (int x = 1; x <= Math.ceil(Math.sqrt(i)); x++) {
				temp = x * x;
				if (temp > i) {
					break;
				} else {
					dp[i] = Math.min(dp[i], dp[i - temp] + 1);
				}
			}
		}
		return dp[n];
	}
}
