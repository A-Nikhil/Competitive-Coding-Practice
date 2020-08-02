// https://leetcode.com/problems/subsets-ii/

package DataStructures.Arrays.Misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
	public static void main(String[] args) {
		int[] nums = {1, 2, 2};
		System.out.println(new Subsets2().subsetsWithDup(nums));
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length == 0) {
			return result;
		}
		List<List<Integer>> prev = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = nums.length - 1; i >= 0; i--) {
			if (i == nums.length - 1 || nums[i] != nums[i + 1] || prev.size() == 0) {
				prev = new ArrayList<>();
				for (List<Integer> integers : result) {
					prev.add(new ArrayList<>(integers));
				}
			}

			for (List<Integer> temp : prev) {
				temp.add(0, nums[i]);
			}

			if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
				List<Integer> single = new ArrayList<>();
				single.add(nums[i]);
				prev.add(single);
			}

			for (List<Integer> temp : prev) {
				result.add(new ArrayList<>(temp));
			}
		}
		result.add(new ArrayList<>());
		return result;
	}
}
