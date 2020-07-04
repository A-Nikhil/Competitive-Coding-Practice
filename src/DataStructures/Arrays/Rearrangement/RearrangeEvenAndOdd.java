// Rearrange array such that arr[i] >= arr[j] if i is even and arr[i]<=arr[j] if i is odd and j < i

package DataStructures.Arrays.Rearrangement;

import Commons.ArrayPrinter;

import java.util.Arrays;

public class RearrangeEvenAndOdd {
	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
		rearrangeArray(arr, arr.length);
	}

	private static void rearrangeArray(int[] arr, int n) {
		int even = n / 2;
		int odd = n - even;
		int[] temp = arr.clone();
		Arrays.sort(temp);
		int j = odd - 1;

		// fill up odd positions in arr
		for (int i = 0; i < n; i += 2) {
			arr[i] = temp[j];
			j--;
		}
		j = odd;

		// full up even positions
		for (int i = 1; i < n; i += 2) {
			arr[i] = temp[j];
			j++;
		}

		new ArrayPrinter().printArray(arr);
	}
}