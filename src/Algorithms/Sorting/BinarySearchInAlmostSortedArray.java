package Algorithms.Sorting;

public class BinarySearchInAlmostSortedArray {
	public static void main(String[] args) {
		int[] arr = {10, 3, 40, 20, 50, 80, 70};
		int key = 40;
		System.out.println(findElement(arr, arr.length, key));
	}

	private static int findElement(int[] arr, int n, int ele) {
		int lo = 0, hi = n - 1, mid;
		while (lo <= hi) {
			mid = (lo + hi) / 2;
			if (arr[mid] == ele) {
				return mid;
			}
			if (mid + 1 < n && arr[mid + 1] == ele) {
				return mid + 1;
			}
			if (mid - 1 > 0 && arr[mid - 1] == ele) {
				return mid - 1;
			}
			if (ele < arr[mid]) {
				hi = mid - 1;
			}
			if (ele > arr[mid]) {
				lo = mid + 1;
			}
		}
		return -1;
	}
}
