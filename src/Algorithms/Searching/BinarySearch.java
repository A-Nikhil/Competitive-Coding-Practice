package Algorithms.Searching;

import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = {10, 15, 19, 23, 48, 26, 54};
		int element = 26;
		System.out.println(binarySearch(arr, arr.length, element));
	}

	private static int binarySearch(int[] arr, int n, int element) {
		Arrays.sort(arr);
		int low = 0, high = n - 1, mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (arr[mid] == element) {
				return mid + 1;
			} else if (element < arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
}
