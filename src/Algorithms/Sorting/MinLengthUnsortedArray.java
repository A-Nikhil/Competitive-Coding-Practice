package Algorithms.Sorting;

import Commons.ArrayPrinter;

public class MinLengthUnsortedArray {
	public static void main(String[] args) {
		int[] arr = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
		int arr_size = arr.length;
		getMinUnsorted(arr, arr_size);
	}

	private static void getMinUnsorted(int[] arr, int n) {
		int s = 0, e = 0, i;
		for (i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				s = i;
				break;
			}
		}
		for (i = n - 1; i > 0; i--) {
			if (arr[i] < arr[i - 1]) {
				e = i;
				break;
			}
		}
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (i = s; i <= e; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		for (i = 0; i < s; i++) {
			if (arr[i] > min) {
				s = i;
				min = arr[i];
			}
		}
		for (i = e + 1; i < n; i++) {
			if (arr[i] < max) {
				e = i;
				max = arr[i];
			}
		}
		new ArrayPrinter().printArray(arr, s, e);
	}
}
