package DataStructures.Arrays.Misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSum {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		int target = 3;
		List<List<Integer>> result = new TwoSum().twoSum(nums, target);
		for (List<Integer> pair : result) {
			System.out.println(pair);
		}
	}

	public List<List<Integer>> twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		List<Integer> temp;
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length == 0) {
			return result;
		}
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				temp = new ArrayList<>();
				temp.add(complement);
				temp.add(nums[i]);
				result.add(temp);
			}
			map.put(nums[i], i);
		}
		return result;
	}
}
