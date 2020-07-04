package Algorithms.DynamicProgramming;

public class PartitionProblem {
	public static void main(String[] args) {
		int[] arr = {3, 1, 1, 2, 2, 1};
		int n = arr.length;
		System.out.println(partition(arr, n));
	}

	private static boolean partition(int[] arr, int n) {
		int sum = 0;
		int i, j;
		for (int x : arr) {
			sum += x;
		}
		if (sum % 2 != 0) {
			return false;
		}

		boolean[][] part = new boolean[sum / 2 + 1][n + 1];
		for (i = 0; i <= n; i++) {
			part[0][i] = true;
		}
		for (j = 1; j <= sum / 2; j++) {
			part[j][0] = false;
		}
		for (i = 1; i <= sum / 2; i++) {
			for (j = 1; j <= n; j++) {
				part[i][j] = part[i][j - 1];
				if (i >= arr[j - 1]) {
					part[i][j] = part[i][j - 1] ||
							part[i - arr[j - 1]][j - 1];
				}
			}
		}
		return part[sum / 2][n];
	}
}
