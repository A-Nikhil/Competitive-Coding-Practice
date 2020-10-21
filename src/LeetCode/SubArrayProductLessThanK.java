package LeetCode;

public class SubArrayProductLessThanK {
	public static void main(String[] args) {
		int[] nums = {10, 5, 2, 6};
		int k = 100;
		System.out.println(new SubArrayProductLessThanK().numSubarrayProductLessThanK(nums, k));
	}

	public int numSubarrayProductLessThanK(int[] nums, int k) {
		if (k <= 1) {
			return 0;
		}
		int count = 0, left = 0, right = 0, prod = 1;
		while (right < nums.length) {
			prod *= nums[right];
			while (prod >= k) {
				prod /= nums[left++];
			}
			count += 1 + (right - left);
			right++;
		}
		return count;
	}
}
