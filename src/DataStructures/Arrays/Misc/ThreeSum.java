package DataStructures.Arrays.Misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		System.out.println(threeSums(nums));
	}

	private static List<List<Integer>> threeSums(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		ArrayList<Integer> list;
		for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			while (j < k) {
				if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
					k--;
					continue;
				}
				if (nums[i] + nums[j] + nums[k] > 0) {
					k--;
				} else if (nums[i] + nums[j] + nums[k] < 0) {
					j++;
				} else {
					list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[j]);
					list.add(nums[k]);
					result.add(new ArrayList<>(list));
					j++;
					k--;
				}
			}
		}
		return result;
	}
}
