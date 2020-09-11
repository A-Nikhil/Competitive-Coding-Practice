package Algorithms.DynamicProgramming;

public class MaximumProductSubarray {
	public static void main(String[] args) {
		int[] nums = {2, 3, -2, 4};
		System.out.println(new MaximumProductSubarray().maxProduct(nums));
	}

	public int maxProduct(int[] nums) {
		int currentMax = nums[0], currentMin = nums[0], previousMax, result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			previousMax = currentMax;
			currentMax = Math.max(nums[i],
					Math.max(currentMax * nums[i], currentMin * nums[i]));
			currentMin = Math.min(nums[i],
					Math.min(currentMin * nums[i], previousMax * nums[i]));
			result = Math.max(result, currentMax);
		}
		return result;
	}
}
