// https://leetcode.com/problems/find-all-duplicates-in-an-array/

package DataStructures.Arrays.Misc;

import java.util.ArrayList;
import java.util.List;

public class DuplicatesInArray {
	public static void main(String[] args) {
		int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
		List<Integer> result = new DuplicatesInArray().getDuplicates(nums);
		System.out.println(result);
	}

	public List<Integer> getDuplicates(int[] nums) {
		List<Integer> result = new ArrayList<>();
		if (nums.length == 0) {
			return result;
		}
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int pos = nums[i] % n;
			nums[pos] += n;
		}
		for (int i = 0; i < n; i++) {
			if ((double) nums[i] / n > 2.0) {
				result.add(i == 0 ? n : i);
			}
		}
		return result;
	}
}