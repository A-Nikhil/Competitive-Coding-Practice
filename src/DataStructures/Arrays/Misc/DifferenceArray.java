// https://www.geeksforgeeks.org/difference-array-range-update-query-o1/

package DataStructures.Arrays.Misc;

public class DifferenceArray {
	static int[] arr, diff;
	static int n;

	public static void main(String[] args) {
		// Array to be updated
		arr = new int[]{10, 5, 20, 40};
		n = arr.length;
		diff = new int[n + 1];
		initializeDifference();
		updateRangeQuery(0, 1, 10);
		printArray();
		updateRangeQuery(1, 3, 20);
		updateRangeQuery(2, 2, 30);
		printArray();
	}

	private static void initializeDifference() {
		diff[0] = arr[0];
		diff[n] = 0;
		for (int i = 1; i < n; i++) {
			diff[i] = arr[i] - arr[i - 1];
		}
	}

	private static void updateRangeQuery(int l, int r, int x) {
		diff[l] += x;
		diff[r + 1] -= x;
	}

	private static void printArray() {
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				arr[i] = diff[i];
			} else {
				arr[i] = diff[i] + arr[i - 1];
			}
			System.out.print(arr[i] + " ");
		}
	}
}
