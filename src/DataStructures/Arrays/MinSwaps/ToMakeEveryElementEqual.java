package DataStructures.Arrays.MinSwaps;

import java.util.HashMap;

public class ToMakeEveryElementEqual {
	public static void main(String[] args) {
//		int[] arr = {2, 3, 3, 4};
		int[] arr = {1, 2, 3, 4};
		int n = arr.length;
		System.out.println(minChanges(arr, n));
	}

	private static int minChanges(int[] arr, int n) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int maxCount = 0, max = arr[0];
		for (int i : arr) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
			if (map.get(i) > maxCount) {
				maxCount = map.get(i);
				max = i;
			}
		}

		return n - map.get(max);
	}
}
