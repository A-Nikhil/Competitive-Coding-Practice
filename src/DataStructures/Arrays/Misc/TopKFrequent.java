// https://leetcode.com/problems/top-k-frequent-elements/

package DataStructures.Arrays.Misc;

import Commons.ArrayPrinter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TopKFrequent {
	public static void main(String[] args) {
		int[] arr = {1, 1, 1, 2, 2, 3};
		int k = 2;
		new ArrayPrinter().printArray(topKFrequent(arr, k));
	}

	private static int[] topKFrequent(int[] nums, int k) {
		if (nums.length == 0 || nums.length < k) {
			return new int[0];
		}
		int[] result = new int[k];
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		LinkedList<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
		list.sort(Map.Entry.comparingByValue());
		int index = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			result[index++] = list.get(i).getKey();
			if (index == k) {
				break;
			}
		}
		return result;
	}
}
