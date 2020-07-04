package Algorithms.Sorting;

import Commons.ArrayPrinter;

public class BubbleSort {
	@SuppressWarnings("Duplicates")
	public static void main(String[] args) {
		int[] arr = {10, 23, 19, 15, 48, 26, 54};
		new ArrayPrinter().printArray(bubbleSort(arr, arr.length), arr.length);
	}

	private static int[] bubbleSort(int[] arr, int n) {
		int temp;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
}
