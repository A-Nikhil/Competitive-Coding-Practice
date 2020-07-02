package Algorithms.Sorting;

import Commons.ArrayPrinter;

public class HeapSort {
	private static void heapify(int[] arr, int n, int i) {
		int largest = i, left = 2 * i + 1, right = 2 * i + 2;
		if (left < n && arr[left] > arr[largest]) {
			largest = left;
		}
		if (right < n && arr[right] > arr[largest]) {
			largest = right;
		}
		if (largest != i) {
			int swap = arr[largest];
			arr[largest] = arr[i];
			arr[i] = swap;
			heapify(arr, n, largest);
		}
	}

	private static void sort(int[] arr, int n) {
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}
		for (int i = n - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, n, 0);
		}
		new ArrayPrinter().printArray(arr, n);
	}

	public static void main(String[] args) {
		int[] arr = {10, 23, 19, 15, 48, 26, 54};
		sort(arr, arr.length);
	}
}
