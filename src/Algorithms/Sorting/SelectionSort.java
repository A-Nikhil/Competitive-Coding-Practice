package Algorithms.Sorting;

import Commons.ArrayPrinter;

public class SelectionSort {
	@SuppressWarnings("Duplicates")
	public static void main(String[] args) {
		int[] arr = {10, 23, 19, 15, 48, 26, 54};
		new ArrayPrinter().printArray(selectionSort(arr, arr.length), arr.length);
	}

	private static int[] selectionSort(int[] arr, int n) {
		int pos, temp, small;
		for (int i = 0; i < n; i++) {
			small = arr[i];
			pos = i;
			for (int j = i; j < n; j++) {
				if (small > arr[j]) {
					small = arr[j];
					pos = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[pos];
			arr[pos] = temp;
		}
		return arr;
	}
}

