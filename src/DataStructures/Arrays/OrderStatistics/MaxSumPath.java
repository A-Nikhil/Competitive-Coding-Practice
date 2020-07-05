package DataStructures.Arrays.OrderStatistics;

public class MaxSumPath {
	public static void main(String[] args) {
		int[] ar1 = {2, 3, 7, 10, 12, 15, 30, 34};
		int[] ar2 = {1, 5, 7, 8, 10, 15, 16, 19};
		int m = ar1.length;
		int n = ar2.length;
		System.out.println(maxSumPath(ar1, ar2, m, n));
	}

	private static int maxSumPath(int[] ar1, int[] ar2, int m, int n) {
		int i = 0, j = 0, result = 0, sum1 = 0, sum2 = 0;
		while (i < m && j < n) {
			if (ar1[i] < ar2[j]) {
				sum1 += ar1[i];
				i++;
			} else if (ar1[i] > ar2[j]) {
				sum2 += ar2[j];
				j++;
			} else {
				result += Math.max(sum1, sum2);
				sum1 = sum2 = 0;
				while (i < m && j < n && ar1[i] == ar2[j]) {
					result += ar1[i];
					i++;
					j++;
				}
			}
		}

		while (i < m) {
			sum1 += ar1[i];
			i++;
		}

		while (j < n) {
			sum2 += ar2[j];
			j++;
		}

		result += Math.max(sum1, sum2);

		return result;
	}
}
