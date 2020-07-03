/*
rotate(arr[], d, n)
  reverse(arr[], 1, d) ;
  reverse(arr[], d + 1, n);
  reverse(arr[], 1, n);
 */

package DataStructures.Arrays.Rotations;

import Commons.ArrayPrinter;

public class ReversalAlgorithm {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		int n = arr.length;
		int d = 2;
		leftRotate(arr, n, d);
	}

	private static void leftRotate(int[] arr, int n, int d) {
		d = d % n;
		if (d == 0) {
			return;
		}
		reverseArray(arr, 0, d - 1);
		reverseArray(arr, d, n - 1);
		reverseArray(arr, 0, n - 1);
		new ArrayPrinter().printArray(arr, arr.length);
	}

	private static void reverseArray(int[] arr, int start, int end) {
		int temp;
		while (start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
}
