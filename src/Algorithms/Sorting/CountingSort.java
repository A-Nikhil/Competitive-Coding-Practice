package Algorithms.Sorting;

public class CountingSort {
	public static void main(String[] args) {
		char[] arr = {'g', 'e', 'e', 'k', 's', 'f', 'o',
				'r', 'g', 'e', 'e', 'k', 's'
		};

		sort(arr);

		System.out.print("Sorted character array is ");
		for (char c : arr) System.out.print(c);
	}

	private static void sort(char[] arr) {
		int n = arr.length;

		// The output character array that will have sorted arr
		char[] output = new char[n];

		// Create a count array to store count of inidividul
		// characters and initialize count array as 0
		int[] count = new int[256];
		for (int i = 0; i < 256; ++i)
			count[i] = 0;

		// store count of each character
		for (char c : arr) ++count[c];

		// Change count[i] so that count[i] now contains actual
		// position of this character in output array
		for (int i = 1; i <= 255; ++i)
			count[i] += count[i - 1];

		// Build the output character array
		// To make it stable we are operating in reverse order.
		for (int i = n - 1; i >= 0; i--) {
			output[count[arr[i]] - 1] = arr[i];
			--count[arr[i]];
		}

		// Copy the output array to arr, so that arr now
		// contains sorted characters
		System.arraycopy(output, 0, arr, 0, n);
	}
}
