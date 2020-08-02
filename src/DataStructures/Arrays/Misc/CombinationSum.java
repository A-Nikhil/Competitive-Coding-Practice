// https://leetcode.com/problems/combination-sum-ii/

package DataStructures.Arrays.Misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> result;

	public static void main(String[] args) {
		int[] candidates = {10, 1, 2, 7, 6, 1, 5};
		int target = 8;
		List<List<Integer>> result = new CombinationSum().combinationSum2(candidates, target);
		System.out.println(result);
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		result = new ArrayList<>();
		if (candidates.length == 0) {
			return result;
		}
		Arrays.sort(candidates);
		List<Integer> current = new ArrayList<>();

		backtrack(candidates, target, 0, current);

		return result;
	}

	public void backtrack(int[] candidates, int target, int start, List<Integer> current) {
		if (target < 0) {
			return;
		}

		if (target == 0) {
			result.add(new ArrayList<>(current));
			return;
		}

		int prev = -1;
		for (int i = start; i < candidates.length; i++) {
			if (prev != candidates[i]) {
				current.add(candidates[i]);
				backtrack(candidates, target - candidates[i], i + 1, current);
				current.remove(current.size() - 1);
				prev = candidates[i];
			}
		}
	}
}