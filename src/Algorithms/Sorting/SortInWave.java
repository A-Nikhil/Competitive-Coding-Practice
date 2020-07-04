package Algorithms.Sorting;

import Commons.ArrayPrinter;

public class SortInWave {
	public static void main(String[] args) {
		int[] arr = {10, 90, 49, 2, 1, 5, 23};
		waveSort(arr, arr.length);
	}

	private static void waveSort(int[] arr, int n) {
		int temp;
		for (int i = 0; i < n; i += 2) {
			if (i > 0 && arr[i] < arr[i - 1]) {
				temp = arr[i - 1];
				arr[i - 1] = arr[i];
				arr[i] = temp;
			}
			if (i < n - 1 && arr[i] < arr[i + 1]) {
				temp = arr[i + 1];
				arr[i + 1] = arr[i];
				arr[i] = temp;
			}
		}
		new ArrayPrinter().printArray(arr, arr.length);
	}
}
