// https://www.geeksforgeeks.org/find-the-maximum-repeating-number-in-ok-time/

package DataStructures.Arrays.OrderStatistics;

public class MaxRepeatingNumberInOK {
	public static void main(String[] args) {
		int[] arr = {2, 3, 3, 5, 3, 4, 1, 7};
		int n = arr.length;
		int k = 8;
		System.out.println(getNumber(arr, n, k));
	}

	private static int getNumber(int[] arr, int n, int k) {
		int i;
		for (i = 0; i < n; i++) {
			arr[arr[i] % k] += k;
		}
		int max = arr[0], result = 0;
		for (i = 1; i < n; i++) {
			if (max < arr[i]) {
				max = arr[i];
				result = i;
			}
		}

		// The maximum repeating number would be the index
		// and not arr[result]
		return result;
	}
}
