package Algorithms.Counting;

public class WaysToGenerateSum {
	public static void main(String[] args) {
		int[] arr = {1, 3, 4};
		int sum = 5;
		System.out.println(generateSum(arr, arr.length, sum));
	}

	private static int generateSum(int[] arr, int n, int sum) {
		int[] dp = new int[sum + 1];
		dp[0] = 0;
		for (int i = 1; i <= sum; i++) {
			for (int j = 0; j < n; j++) {
				dp[j] += dp[j - arr[j]];
			}
		}
		return dp[sum];
	}
}
