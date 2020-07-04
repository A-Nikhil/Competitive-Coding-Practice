package DataStructures.Arrays.Rearrangement;

import Commons.ArrayPrinter;

public class MoveZeroesToEndInSingleTraversal {
	public static void main(String[] args) {
		int[] arr = {0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
		moveZeroes(arr, arr.length);
	}

	private static void moveZeroes(int[] arr, int n) {
		int temp, count = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] != 0) {
				temp = arr[count];
				arr[count] = arr[i];
				arr[i] = temp;
				count++;
			}
		}
		new ArrayPrinter().printArray(arr);
	}
}
