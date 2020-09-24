// https://leetcode.com/problems/product-of-array-except-self/

package LeetCode;

import Commons.ArrayPrinter;

public class ProductOfArrayExceptSelf {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};
		new ArrayPrinter().printArray(new ProductOfArrayExceptSelf().productExceptSelf(arr));
	}

	public int[] productExceptSelf(int[] nums) {
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		left[0] = 1;
		right[nums.length - 1] = 1;
		int runningProduct = 1;
		for (int i = 0; i < nums.length; i++) {
			left[i] = runningProduct;
			runningProduct *= nums[i];
		}
		runningProduct = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			right[i] = runningProduct;
			runningProduct *= nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			left[i] = left[i] * right[i];
		}
		return left;
	}
}
