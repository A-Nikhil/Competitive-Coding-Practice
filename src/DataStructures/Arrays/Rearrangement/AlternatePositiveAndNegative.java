package DataStructures.Arrays.Rearrangement;

import Commons.ArrayPrinter;

public class AlternatePositiveAndNegative {
	public static void main(String[] args) {
		int[] arr = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
		alternate(arr, arr.length);
	}

	private static void alternate(int[] arr, int n) {
		int out = -1;
		for (int index = 0; index < n; index++) {
			if (out >= 0) {
				// find the item which must be moved into the out-of-place
				// entry if out-of-place entry is positive and current
				// entry is negative OR if out-of-place entry is negative
				// and current entry is negative then right rotate
				//
				// [...-3, -4, -5, 6...] -->   [...6, -3, -4, -5...]
				//      ^                          ^
				//      |                          |
				//     outofplace      -->      outofplace
				if (((arr[index] >= 0) && (arr[out] < 0)) || ((arr[index] < 0) && (arr[out] >= 0))) {
					rightRotate(arr, out, index);
					if (index - out > 2) {
						out = out + 2;
					} else {
						out = -1;
					}
				}
			}

			if (out == -1) {
				if (((arr[index] >= 0) && ((index % 2) != 0)) || ((arr[index] < 0) && ((index % 2) == 0))) {
					out = index;
				}
			}
		}
		new ArrayPrinter().printArray(arr);
	}

	private static void rightRotate(int[] arr, int out, int cur) {
		int temp = arr[cur];
		for (int i = cur; i > out; i--) {
			arr[i] = arr[i - 1];
		}
		arr[out] = temp;
	}
}
