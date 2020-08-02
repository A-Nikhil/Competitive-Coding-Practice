// https://leetcode.com/problems/subsets/

package DataStructures.Arrays.Misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets1 {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		List<List<Integer>> result = new Subsets1().subsets(nums);
		System.out.println(result);
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length == 0) {
			return result;
		}

		Arrays.sort(nums);
		for (int num : nums) {
			List<List<Integer>> temp = new ArrayList<>();
			for (List<Integer> a : result) {
				temp.add(new ArrayList<>(a));
			}

			for (List<Integer> a : temp) {
				a.add(num);
			}

			List<Integer> single = new ArrayList<>();
			single.add(num);
			temp.add(single);

			result.addAll(temp);
		}
		result.add(new ArrayList<>());
		return result;
	}
}
