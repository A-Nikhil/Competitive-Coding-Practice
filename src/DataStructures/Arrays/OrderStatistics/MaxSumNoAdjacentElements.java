package DataStructures.Arrays.OrderStatistics;

public class MaxSumNoAdjacentElements {
	public static void main(String[] args) {
		int[] arr = {5, 5, 10, 100, 10, 5};
		System.out.println(findMaxSum(arr, arr.length));
	}

	private static int findMaxSum(int[] arr, int n) {
		int incl = arr[0], excl = 0, excl_new, i;
		for (i = 1; i < n; i++) {
			excl_new = Math.max(incl, excl);
			incl = excl + arr[i];
			excl = excl_new;
		}
		return Math.max(incl, excl);
	}
}
