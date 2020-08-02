package DataStructures.Arrays.Misc;

public class MinimumSizeSumSubArray {
	public static void main(String[] args) {
		int[] nums = {2, 3, 1, 2, 4, 3};
		int s = 7;
		System.out.println(new MinimumSizeSumSubArray().minSubArrayLen(s, nums));
	}

	public int minSubArrayLen(int s, int[] nums) {
		if (s == 0 || nums.length == 0) {
			return 0;
		}
		int start, i, sum, result = nums.length;
		start = i = sum = 0;
		boolean exists = false;
		while (i <= nums.length) {
			if (sum >= s) {
				exists = true;
				if (start == i - 1) {
					return 1;
				}
				result = Math.min(result, i - start);
				sum -= nums[start];
				start++;
			} else {
				if (i == nums.length) {
					break;
				}
				sum += nums[i];
				i++;
			}
		}
		return exists ? result : 0;
	}
}