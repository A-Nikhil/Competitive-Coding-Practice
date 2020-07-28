package DataStructures.Arrays.Misc;

import java.util.List;
import java.util.ArrayList;

public class CombinationSum {
    public List<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        System.out.println("Hello");
        List<Integer> current = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            backtrack(candidates, target, i, current);
        }
        return result;
    }

    public void backtrack(int[] candidates, int target, int i, List<Integer> current) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (i >= candidates.length) {
            return;
        }

        if (candidates[i] <= target) {
            System.out.println(candidates[i]);
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, current);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        List<List<Integer>> result = new CombinationSum().combinationSum2(candidates, target);
        System.out.println(result);
    }
}