package DataStructures.Arrays.MinSwaps;

public class ToMakeSumK {
	public static void main(String[] args) {
		int[] arr = {1, 3, 2, 5, 6};
		int n = arr.length;
		int k = 5;
		System.out.println(minChanges(arr, n, k));
	}

	private static int minChanges(int[] arr, int n, int k) {
		int min = n + 1, sum = 0, j = 0;
		boolean found = false;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum >= k) {
				if (sum == k) {
					min = Math.min(n - (i + 1) + j, min);
					found = true;
				}
				while (sum > k) {
					sum = sum - arr[j];
					j++;
				}
				if (sum == k) {
					min = Math.min(n - (i + 1) + j, min);
					found = true;
				}
			}
		}
		if (found) {
			return min;
		} else {
			return -1;
		}
	}
}
