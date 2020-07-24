// https://leetcode.com/problems/avoid-flood-in-the-city/

package DataStructures.Arrays.Misc;

import Commons.ArrayPrinter;

import java.util.HashMap;
import java.util.TreeSet;

public class AvoidFloods {
	public static void main(String[] args) {
		int[] arr = {1, 2, 0, 0, 1, 2};
//		int[] arr = {0, 1, 1};
		new ArrayPrinter().printArray(avoidFlood(arr));
	}

	private static int[] avoidFlood(int[] rains) {
		if (rains.length == 0) {
			return null;
		}
		int[] result = new int[rains.length];
		HashMap<Integer, Integer> lakes = new HashMap<>();
		TreeSet<Integer> noRain = new TreeSet<>();
		for (int i = 0; i < rains.length; i++) {
			if (rains[i] == 0) {
				noRain.add(i);
			} else {
				if (lakes.containsKey(rains[i])) {
					Integer dry = noRain.ceiling(lakes.get(rains[i]));
					if (dry == null) {
						return new int[0];
					}
					noRain.remove(dry);
					result[dry] = rains[i];
				}
				lakes.put(rains[i], i);
				result[i] = -1;
			}
		}

		for (int x : noRain) {
			result[x] = 1;
		}

		return result;
	}
}
