package DataStructures.Arrays.Misc;

import java.util.Arrays;

public class RangeSumOfSortedSubarrays {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		int n = 4, left = 1, right = 5;
		System.out.println(rangeSum(nums, n, left, right));
	}

	private static int rangeSum(int[] nums, int n, int left, int right) {
		int mod = ((int) Math.pow(10, 9)) + 7;
		int[] sum = new int[(n * (n + 1)) / 2];
		int tempSum, index = 0;
		for (int i = 0; i < n; i++) {
			tempSum = nums[i];
			sum[index++] = tempSum;
			for (int j = i + 1; j < n; j++) {
				tempSum += nums[j];
				sum[index++] = tempSum;
			}
		}
		Arrays.sort(sum);
		int result = 0;
		for (int i = left - 1; i < right; i++) {
			result = ((result % mod) + (sum[i] % mod)) % mod;
		}
		return result;
	}
}
