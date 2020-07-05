package DataStructures.Arrays.OrderStatistics;

import java.util.PriorityQueue;

public class KthLargestSumContiguousSubArray {
	public static void main(String[] args) {
		int[] arr = new int[]{10, -10, 20, -40};
		int n = arr.length;
		int k = 6;
		System.out.println(kthLargestSum(arr, n, k));
	}

	private static int kthLargestSum(int[] arr, int n, int k) {
		int[] sum = new int[n + 1];
		sum[0] = 0;
		sum[1] = arr[0];
		for (int i = 2; i <= n; i++) {
			sum[i] = arr[i - 1] + sum[i - 1];
		}
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				int x = sum[j] - sum[i - 1];
				if (queue.size() < k) {
					queue.add(x);
				} else {
					if (queue.peek() < x) {
						queue.poll();
						queue.add(x);
					}
				}
			}
		}
		return queue.poll();
	}
}
