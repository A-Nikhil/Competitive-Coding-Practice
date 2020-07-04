package DataStructures.Arrays.MinSwaps;

public class ToBringPairsTogether {
	private static void updateIndex(int[] arr, int a, int ai, int b, int bi) {
		arr[a] = ai;
		arr[b] = bi;
	}

	private static int minSwapsUtil(int[] arr, int[] pairs, int[] index, int i, int n) {
		// If all pairs processed so
		// no swapping needed return 0
		if (i > n) {
			return 0;
		}

		// If current pair is valid so
		// DO NOT DISTURB this pair
		// and move ahead.
		if (pairs[arr[i]] == arr[i + 1]) {
			return minSwapsUtil(arr, pairs, index, i + 2, n);
		}

		// If we reach here, then arr[i] and
		// arr[i+1] don't form a pair

		// Swap pair of arr[i] with arr[i+1]
		// and recursively compute minimum swap
		// required if this move is made.
		int one = arr[i];
		int indexTwo = arr[i + 1];
		int indexOne = index[pairs[arr[i]]];
		int two = arr[index[pairs[arr[i]]]];
		updateIndex(arr, one, indexOne, two, indexTwo);
		int a = minSwapsUtil(arr, pairs, index, i + 2, n);

		// Backtrack to previous configuration.
		// Also restore the previous
		// indices, of one and two
		arr[i + 1] = arr[i + 1] ^ arr[indexOne] ^
				(arr[indexOne] = arr[i + 1]);
		updateIndex(index, one, indexTwo, two, indexOne);
		one = arr[i];
		indexOne = index[pairs[arr[i + 1]]];

		// Now swap arr[i] with pair of arr[i+1]
		// and recursively compute minimum swaps
		// required for the subproblem
		// after this move
		two = arr[index[pairs[arr[i + 1]]]];
		indexTwo = i;
		arr[i] = arr[i] ^ arr[indexOne] ^ (arr[indexOne] = arr[i]);
		updateIndex(index, one, indexOne, two, indexTwo);
		int b = minSwapsUtil(arr, pairs, index, i + 2, n);

		// Backtrack to previous configuration. Also restore
		// the previous indices, of one and two
		arr[i] = arr[i] ^ arr[indexOne] ^ (arr[indexOne] = arr[i]);
		updateIndex(index, one, indexTwo, two, indexOne);

		// Return minimum of two cases
		return 1 + Math.min(a, b);
	}

	private static int minSwaps(int[] arr, int n, int[] pairs) {
		int[] index = new int[2 * n + 1];
		for (int i = 1; i <= 2 * n; i++) {
			index[arr[i]] = i;
		}

		return minSwapsUtil(arr, pairs, index, 1, 2 * n);
	}

	public static void main(String[] args) {
		int[] arr = {0, 3, 5, 6, 4, 1, 2};

		// if (a, b) is pair than we have assigned elements
		// in array such that pairs[a] = b and pairs[b] = a
		int[] pairs = {0, 3, 6, 1, 5, 4, 2};
		int m = pairs.length;

		// Number of pairs n is half of total elements
		int n = m / 2;
		System.out.println(minSwaps(arr, n, pairs));
	}
}
