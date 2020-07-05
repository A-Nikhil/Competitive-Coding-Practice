package DataStructures.Arrays.MinSwaps;

import Commons.ArrayPrinter;

public class SegregateOddEven {
	public static void main(String[] args) {
		int[] arr = {12, 34, 45, 9, 8, 90, 3};
		System.out.println("\n" + segregate(arr, arr.length));
	}

	private static int segregate(int[] arr, int n) {
		int l = 0, r = n - 1;
		int count = 0;
		while (l < r) {
			while (arr[l] % 2 == 0 && l < r) {
				l++;
			}
			while (arr[r] % 2 == 1 && l < r) {
				r--;
			}
			if (l < r) {
				int temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
				count++;
				l++;
				r--;
			}
		}
		new ArrayPrinter().printArray(arr);
		return count;
	}
}
