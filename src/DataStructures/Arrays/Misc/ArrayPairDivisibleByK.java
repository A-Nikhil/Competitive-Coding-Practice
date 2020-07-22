package DataStructures.Arrays.Misc;

import java.util.HashMap;

public class ArrayPairDivisibleByK {
	public static void main(String[] args) {

		// Set 1
//		int[] arr = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
//		int k = 5;

		// Set 2
		int[] arr = {-1, 1, -2, 2, -3, 3, -4, 4};
		int k = 3;
		System.out.println(canPairs(arr, k));

	}

	private static boolean canPairs(int[] arr, int k) {
		if (arr.length % 2 == 1) {
			return false;
		}

		HashMap<Integer, Integer> map = new HashMap<>();
		int rem;
		for (int i : arr) {
			rem = i % k;
			if (rem < 0) {
				rem += k;
			}
			map.put(rem, map.getOrDefault(rem, 0) + 1);
		}

		for (int a : map.keySet()) {
			if (a != 0) {
				int s = map.get(a);
				int z = map.getOrDefault(k - a, 0);
				if (a != (k - a)) {
					if (s != z) {
						return false;
					}
				} else {
					if (s % 2 == 1) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
