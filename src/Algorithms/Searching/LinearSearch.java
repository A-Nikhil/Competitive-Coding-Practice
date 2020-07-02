package Algorithms.Searching;

@SuppressWarnings("Duplicates")
public class LinearSearch {
	public static void main(String[] args) {
		int[] arr = {10, 23, 19, 15, 48, 26, 54};
		int element = 26;
		System.out.println(linearSearch(arr, arr.length, element));
	}

	private static int linearSearch(int[] arr, int n, int element) {
		for (int i = 0; i < n; i++) {
			if (arr[i] == element) {
				return i + 1;
			}
		}
		return -1;
	}
}
