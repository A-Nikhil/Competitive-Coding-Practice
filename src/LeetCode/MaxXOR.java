package LeetCode;

public class MaxXOR {
	public static void main(String[] args) {
		int[] nums = {3, 10, 5, 25, 2, 8};
		System.out.println(new MaxXOR().findMaximumXOR(nums));
	}

	public int findMaximumXOR(int[] nums) {
		int max = -1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				max = Math.max(max, nums[i] ^ nums[j]);
			}
		}
		return max;
	}
}
