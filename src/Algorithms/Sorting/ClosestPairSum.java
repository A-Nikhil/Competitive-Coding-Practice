package Algorithms.Sorting;

public class ClosestPairSum {
	public static void main(String[] args) {
		int[] ar1 = {1, 4, 5, 7};
		int[] ar2 = {10, 20, 30, 40};
		int m = ar1.length;
		int x = 38;
		showPair(ar1, ar2, m, x);
	}

	private static void showPair(int[] arr1, int[] arr2, int n, int sum) {
		int a1 = 0, a2 = n - 1, diff = Integer.MAX_VALUE;
		int r1 = 0, r2 = 0;
		while (a1 < n && a2 >= 0) {
			if (arr1[a1] + arr2[a2] - sum < diff) {
				diff = arr1[a1] + arr2[a2] - sum;
				r1 = a1;
				r2 = a2;
			}
			if (arr1[a1] + arr2[a2] < sum) {
				a1++;
			} else {
				a2--;
			}
		}
		System.out.println("Pair => (" + arr1[r1] + "," + arr2[r2] + ")");
	}
}
