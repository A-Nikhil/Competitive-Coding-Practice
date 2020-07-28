package DataStructures.Arrays.MinSwaps;

public class SortAnArrayTillN_NaturalNumbers {
	public static void main(String[] args) {
		int[] arr = {2, 3, 4, 1, 5};
		System.out.println(minSwaps(arr, arr.length));
	}

	private static int minSwaps(int[] arr, int n) {
		int count = 0, x;
		for (int i = 0; i < n; i++) {
			while (arr[i] != i + 1) {
				x = arr[arr[i] - 1];
				arr[arr[i] - 1] = arr[i];
				arr[i] = x;
				count++;
			}
		}
		return count;
	}
}
