package Algorithms.Sorting;

public class KthSmallest {
	private static int partition(int[] arr, int lo, int hi) {
		int pivot = arr[hi];
		int i = lo - 1, temp;
		for (int j = lo; j <= hi - 1; j++) {
			if (arr[j] <= pivot) {
				i++;
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		temp = arr[i + 1];
		arr[i + 1] = arr[hi];
		arr[hi] = temp;
		return i + 1;
	}

	private static int returnKth(int[] arr, int l, int r, int k) {
		if (l <= r) {
			int pi = partition(arr, l, r);
			if (pi - l == k - 1) {
				return arr[pi];
			}
			if (pi - l > k - 1) {
				return returnKth(arr, l, pi - 1, k);
			}
			return returnKth(arr, pi + 1, r, k - pi + l - 1);
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = {12, 3, 5, 7, 4, 19, 26};
		int k = 3;
		System.out.println(returnKth(arr, 0, arr.length - 1, k));
	}
}
