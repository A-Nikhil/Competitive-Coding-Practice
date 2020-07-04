package DataStructures.Arrays.Rotations;

public class PairWithSumXInSortedRotatedArray {
	public static void main(String[] args) {
		int[] arr = {11, 15, 6, 8, 9, 10};
		int sum = 16;
		printPair(arr, arr.length, sum);
	}

	private static void printPair(int[] arr, int n, int sum) {
		int i;
		for (i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				break;
			}
		}
		int r = i, l = (r + 1) % n;
		while (l != r) {
			if (arr[l] + arr[r] == sum) {
				System.out.println(arr[l] + "," + arr[r]);
				return;
			}
			if (arr[l] + arr[r] < sum) {
				l = (l + 1) % n;
			} else {
				r = (n + r - 1) % n;
			}
		}
		System.out.println("NO Pair");
	}
}
