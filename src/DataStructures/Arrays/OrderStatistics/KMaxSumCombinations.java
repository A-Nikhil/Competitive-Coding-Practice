package DataStructures.Arrays.OrderStatistics;

import java.util.Arrays;

public class KMaxSumCombinations {
	public static void main(String[] args) {
		int[] a = {4, 2, 5, 1};
//		int[] a = {4, 2};
		int[] b = {8, 0, 3, 5};
//		int[] b = {8, 0};
		int k = 3;
//		int k = 2;
		KMaxSumCombos(a, b, a.length, b.length, k);
	}

	private static void KMaxSumCombos(int[] a, int[] b, int n, int m, int k) {
		Arrays.sort(a);
		Arrays.sort(b);
		int i = n - 1, j = m - 1, count = 0;
		while (count < k && i >= 0 && j >= 0) {
			System.out.println(a[i] + b[j]);
			count++;
			if (i > 0 && j > 0 && a[i - 1] > b[j - 1]) {
				j--;
			} else {
				i--;
			}
		}
	}
}
