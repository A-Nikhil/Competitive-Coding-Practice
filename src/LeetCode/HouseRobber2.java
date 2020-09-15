package LeetCode;

@SuppressWarnings("Duplicates")
public class HouseRobber2 {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 1};
		System.out.println(new HouseRobber2().rob(nums));
	}

	public int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		} else if (nums.length == 1) {
			return nums[0];
		} else if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		int[] first = new int[nums.length - 1];
		int[] second = new int[nums.length - 1];
		int indexOne = 0, indexTwo = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				first[indexOne++] = nums[i];
			} else if (i == nums.length - 1) {
				second[indexTwo++] = nums[i];
			} else {
				first[indexOne++] = nums[i];
				second[indexTwo++] = nums[i];
			}
		}
		return Math.max(robHelper(first), robHelper(second));
	}

	private int robHelper(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(nums[i],
					Math.max(dp[i - 1], dp[i - 2] + nums[i]));
		}
		return dp[nums.length - 1];
	}
}
