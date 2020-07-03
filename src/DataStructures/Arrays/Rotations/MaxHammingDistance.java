package DataStructures.Arrays.Rotations;

public class MaxHammingDistance {
	public static void main(String[] args) {
		int[] arr = {2, 4, 6, 8};
		int n = arr.length;
		System.out.print(returnMaxHammingDistance(arr, n));
	}

	private static int returnMaxHammingDistance(int[] arr, int n) {
		int[] temp = new int[2 * n];
		for (int i = 0; i < n; i++) {
			temp[n + i] = temp[i] = arr[i];
		}
		int maxHam = 0, currHam;
		for (int i = 1; i < n; i++) {
			currHam = 0;
			for (int j = i, k = 0; j < (i + n); j++, k++) {
				if (temp[j] != temp[k]) {
					currHam++;
				}
			}
			if (currHam == n) {
				return n;
			}

			maxHam = Math.max(currHam, maxHam);
		}
		return maxHam;
	}
}
