package DataStructures.Queues;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeElementInWindow {
	public static void main(String[] args) {
		int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
		int k = 3;
		getNegatives(arr, arr.length, k);
	}

	private static void getNegatives(int[] arr, int n, int k) {
		Queue<Integer> queue = new LinkedList<>();
		int i;
		for (i = 0; i < k; i++) {
			if (arr[i] < 0) {
				queue.add(i);
			}
		}

		for (i = k; i < n; i++) {
			if (!queue.isEmpty()) {
				System.out.print(arr[queue.peek()] + " ");
			} else {
				System.out.print("0 ");
			}

			// removing elements out of this window
			while (!queue.isEmpty() && queue.peek() < (i - k + 1)) {
				queue.poll();
			}

			if (arr[i] < 0) {
				queue.add(i);
			}
		}

		if (!queue.isEmpty()) {
			System.out.print(arr[queue.peek()] + " ");
		} else {
			System.out.print("0 ");
		}
	}
}
