package Algorithms.Searching;

public class TernarySearch {
	public static void main(String[] args) {
		int[] arr = {10, 15, 19, 23, 26, 48, 54, 60};
		int element = 60;
		System.out.println(ternary(arr, arr.length, element, 0, arr.length - 1));
	}

	private static int ternary(int[] arr, int n, int element, int l, int r) {
		if (r >= l) {
			int mid1 = l + (r - l) / 3;
			int mid2 = mid1 + (r - l) / 3;
			if (arr[mid1] == element)
				return mid1;
			if (arr[mid2] == element)
				return mid2;
			if (element < mid1) {
				return ternary(arr, n, element, l, mid1 - 1);
			}
			if (element > mid2) {
				return ternary(arr, n, element, mid2 + 1, r);
			}
			return ternary(arr, n, element, mid1 + 1, mid1 - 1);
		}
		return -1;
	}
}
