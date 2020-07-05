package DataStructures.Arrays.OrderStatistics;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KNumbersWithMostOccurrences {
	public static void main(String[] args) {
		int[] arr = {3, 1, 4, 4, 5, 2, 6, 1};
		int k = 2;
		kThOccurrence(arr, k);
	}

	private static void kThOccurrence(int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : arr) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		PriorityQueue<Map.Entry<Integer, Integer>> queue =
				new PriorityQueue<>(
						(a, b) -> a.getValue().equals(b.getValue()) ?
								Integer.compare(b.getKey(), a.getKey()) :
								Integer.compare(b.getValue(), a.getValue()));
		queue.addAll(map.entrySet());
		for (int i = 0; i < k; i++) {
			System.out.print(queue.poll().getKey() + " ");
		}
	}
}
