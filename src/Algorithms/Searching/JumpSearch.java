package Algorithms.Searching;

import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class JumpSearch {
	public static void main(String[] args) {
		int[] arr = {10, 15, 19, 23, 26, 48, 54, 60};
		int element = 60;
		System.out.println(jumpSearch(arr, arr.length, element));
	}

	private static int jumpSearch(int[] arr, int n, int element) {
		Arrays.sort(arr);
		int m = (int) Math.floor(Math.sqrt(n));
		for (int i = 1; i <= n / m + 1; i++) {
			if ((i * m) < n && element <= arr[i * m]) {
				if (element == arr[i * m]) {
					return i * m + 1;
				}
				for (int j = (i - 1) * m; j < Math.min(i * m, n); j++) {
					if (arr[j] == element) {
						return j + 1;
					}
				}
			}
		}
		return -1;
	}
}
