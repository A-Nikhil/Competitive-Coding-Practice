package DataStructures.Arrays.Rearrangement;

import Commons.ArrayPrinter;

public class AlternatePositiveNegativeWithConstantSpace {
	public static void main(String[] args) {
		int[] arr = {12, 11, -13, -5, 6, -7, 5, -3, -6};
		rearrange(arr, arr.length);
	}

	private static void rearrange(int[] arr, int n) {
		int key, j;
		for (int i = 1; i < n; i++) {
			key = arr[i];
			if (key > 0) {
				continue;
			}
			j = i - 1;
			while (j >= 0 && arr[j] > 0) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
		new ArrayPrinter().printArray(arr);
	}
}
