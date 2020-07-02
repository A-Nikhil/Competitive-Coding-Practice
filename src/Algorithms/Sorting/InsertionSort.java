package Algorithms.Sorting;

import Commons.ArrayPrinter;

public class InsertionSort {
	@SuppressWarnings("Duplicates")
	public static void main(String[] args) {
		int[] arr = {10, 23, 19, 15, 48, 26, 54};
		new ArrayPrinter().printArray(insertionSort(arr, arr.length), arr.length);
	}

	private static int[] insertionSort(int[] arr, int n) {
		int key, j;
		for (int i = 1; i < n; i++) {
			key = arr[i];
			j = i - 1;
			/* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
		return arr;
	}
}
