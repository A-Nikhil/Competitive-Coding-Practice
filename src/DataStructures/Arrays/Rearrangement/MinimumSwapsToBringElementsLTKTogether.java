package DataStructures.Arrays.Rearrangement;

public class MinimumSwapsToBringElementsLTKTogether {
	public static void main(String[] args) {
		int[] arr = {2, 1, 5, 6, 3};
		int n = arr.length;
		int k = 3;
		System.out.println(minSwaps(arr, n, k));
	}

	private static int minSwaps(int[] arr, int n, int k) {
		int ans, count, bad, i, j;
		count = bad = 0;
		for (i = 0; i < n; i++) {
			if (arr[i] <= k) {
				count++;
			}
		}

		for (i = 0; i < count; i++) {
			if (arr[i] > k) {
				bad++;
			}
		}

		ans = bad;
		for (i = 0, j = count; j < n; i++, j++) {
			if (arr[i] > k) {
				bad--;
			}
			if (arr[j] > k) {
				bad++;
			}
			ans = Math.min(ans, bad);
		}
		return ans;
	}
}
