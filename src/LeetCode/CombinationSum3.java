package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum3 {

	public static void main(String[] args) {
		int k = 3, n = 7;
		for (List<Integer> list : new CombinationSum3().combinationSum3(k, n)) {
			System.out.println(list);
		}
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		HashSet<List<Integer>> result = new HashSet<>();
		Set<Integer> temp = new HashSet<>();
		helper(result, k, 0, n, temp);
		return new ArrayList<>(result);
	}

	private void helper(HashSet<List<Integer>> result,
						int k, int currentSum, int n, Set<Integer> temp) {
		if (k == 0) {
			if (currentSum == n) {
				result.add(new ArrayList<>(temp));
			}
			return;
		}
		if (currentSum > n) {
			return;
		}
		for (int i = 1; i <= 9; i++) {
			if (!temp.contains(i)) {
				temp.add(i);
				helper(result, k - 1, currentSum + i, n, temp);
				temp.remove(i);
			}
		}
	}
}
