package DataStructures.Arrays.OrderStatistics;

import java.util.Arrays;

public class KthSmallestAbsoluteDifference {
	public static void main(String[] args) {
		int k = 3;
		int[] a = {1, 2, 3, 4};
		int n = a.length;
		System.out.println(kthDiff(a, n, k));
	}

	private static int kthDiff(int[] arr, int n, int k) {
		Arrays.sort(arr);
		int low = arr[1] - arr[0];
		for (int i = 1; i <= n - 2; i++) {
			low = Math.min(low, arr[i + 1] - arr[i]);
		}
		int high = arr[n - 1] - arr[0];
		while (low < high) {
			int mid = (low + high) / 2;
			if (countPairs(arr, n, mid) < k) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	private static int countPairs(int[] arr, int n, int mid) {
		int res = 0;
		for (int i = 0; i < n; i++) {
			// Upper bound returns pointer to position
			// of next higher number than a[i]+mid in
			// a[i..n-1]. We subtract (ub + i + 1) from
			// this position to count
			int ub = upperbound(arr, n, arr[i] + mid);
			res += (ub - (i - 1));
		}
		return res;
	}

	private static int upperbound(int[] arr, int n, int value) {
		int low = 0, high = n - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (value >= arr[mid]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}
}
