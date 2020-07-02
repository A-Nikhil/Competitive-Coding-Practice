package Algorithms.Searching;

@SuppressWarnings("Duplicates")
public class InterpolationSearch {
	public static void main(String[] args) {
		int[] arr = {10, 15, 19, 23, 26, 48, 54, 60};
		int element = 60;
		System.out.println(interpolation(arr, arr.length, element));
	}

	private static int interpolation(int[] arr, int n, int element) {
		int pos, lo = 0, hi = n - 1;
		while (lo <= hi) {
			if (lo == hi) {
				if (arr[lo] == element) {
					return lo;
				} else {
					return -1;
				}
			}
			pos = lo + (element - arr[lo]) * (hi - lo) / (arr[hi] - arr[lo]);
			if (arr[pos] == element) {
				return pos;
			}
			if (element > arr[pos]) {
				lo = pos + 1;
			} else {
				hi = pos - 1;
			}
		}
		return -1;
	}
}
