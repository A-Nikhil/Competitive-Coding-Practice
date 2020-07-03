package Algorithms.Sorting;

public class FindKClosestElements {
	private static int findCrossOver(int[] arr, int l, int h, int x) {
		if (x >= arr[h]) {
			return h;
		}
		if (x < arr[l]) {
			return l;
		}
		int mid = (l + h) / 2;
		if (arr[mid] <= x && arr[mid + 1] > x) {
			return mid;
		}
		if (x <= arr[mid]) {
			return findCrossOver(arr, l, mid - 1, x);
		} else {
			return findCrossOver(arr, mid + 1, h, x);
		}
	}

	private static void printKClosest(int[] arr, int n, int k, int x) {
		int l = findCrossOver(arr, 0, n - 1, x), r = l + 1, count = 0;
		if (arr[l] == x) {
			l--;
		}
		while (l >= 0 && count < k && r < n) {
			if (x - arr[l] < arr[r] - x) {
				System.out.print(arr[l] + " ");
				l--;
			} else {
				System.out.print(arr[r] + " ");
				r++;
			}
			count++;
		}
		while (count < k && l >= 0) {
			System.out.print(arr[l] + " ");
			l--;
			count++;
		}
		while (count < k && r < n) {
			System.out.print(arr[r] + " ");
			r++;
			count++;
		}
	}

	public static void main(String[] args) {
		int[] arr = {12, 16, 22, 30, 35, 39, 42,
				45, 48, 50, 53, 55, 56};
		int n = arr.length;
		int x = 35, k = 4;
		printKClosest(arr, n, k, x);
	}
}
