package Algorithms.Sorting;

import Commons.ArrayPrinter;

import java.util.Stack;

public class IterativeQuickSort {
	public static void main(String[] args) {
		int[] arr = {4, 3, 5, 2, 1, 3, 2, 3};
		int n = 8;
		quickSort(arr, 0, n - 1);
	}

	private static void quickSort(int[] arr, int l, int h) {
		Stack<Integer> stack = new Stack<>();
		stack.push(l);
		stack.push(h);
		while (!stack.isEmpty()) {
			h = stack.pop();
			l = stack.pop();
			int p = partition(arr, l, h);
			if (p - 1 > l) {
				stack.push(l);
				stack.push(p - 1);
			}
			if (p + 1 < h) {
				stack.push(p + 1);
				stack.push(h);
			}
		}
		new ArrayPrinter().printArray(arr, arr.length);
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1, temp;
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}
}
