// Rearrange an array such that ‘arr[j]’ becomes ‘i’ if ‘arr[i]’ is ‘j’

package DataStructures.Arrays.Rearrangement;

import Commons.ArrayPrinter;

public class RearrangeWithRule {
	public static void main(String[] args) {
		int[] arr = {2, 0, 1, 4, 5, 3};
		rearrange(arr, arr.length);
	}

	private static void rearrange(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			arr[arr[i] % n] += i * n;
		}
		for (int i = 0; i < n; i++) {
			arr[i] = arr[i] / n;
		}
		new ArrayPrinter().printArray(arr);
	}
}
