package DataStructures.Arrays.MinSwaps;

public class ToMakeAll1sTogether {
	public static void main(String[] args) {
		int[] arr = {1, 0, 1, 0, 1, 1};
		System.out.println(new ToMakeAll1sTogether().countSwaps(arr));
	}

	public int countSwaps(int[] arr) {
		int ones = 0;

		// total number of ones
		for (int i : arr) {
			if (i == 1) {
				ones++;
			}
		}

		int x = ones, count = 0, maxOnes;
		// number of ones in the maximum subarray
		for (int i = 0; i < x; i++) {
			if (arr[i] == 1) {
				count++;
			}
		}

		maxOnes = count;
		for (int i = 1; i <= arr.length - x; i++) {
			if (arr[i - 1] == 1) {
				count--;
			}

			if (arr[i + x - 1] == 1) {
				count++;
			}

			maxOnes = Math.max(maxOnes, count);
		}

		return x - maxOnes;

	}
}