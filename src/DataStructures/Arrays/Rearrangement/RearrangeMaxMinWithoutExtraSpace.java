package DataStructures.Arrays.Rearrangement;

import Commons.ArrayPrinter;

public class RearrangeMaxMinWithoutExtraSpace {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6};
		rearrange(arr, arr.length);
	}

	private static void rearrange(int[] arr, int n) {
		int max = n - 1;
		int min = 0;
		int maxElem = arr[n - 1] + 1;
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				arr[i] += (arr[max] % maxElem) * maxElem;
				max--;
			} else {
				arr[i] += (arr[min] % maxElem) * maxElem;
				min++;
			}
		}
		for (int i = 0; i < n; i++) {
			arr[i] = arr[i] / maxElem;
		}
		new ArrayPrinter().printArray(arr);
	}
}
