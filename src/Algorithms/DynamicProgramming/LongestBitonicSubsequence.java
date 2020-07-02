package Algorithms.DynamicProgramming;

import java.util.Arrays;

public class LongestBitonicSubsequence {
	public static void main(String[] args) {
//		int[] arr = {80, 60, 30, 40, 20, 10};
		int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5,
				13, 3, 11, 7, 15};
		System.out.println(bitonic(arr, arr.length));
	}

	private static int bitonic(int[] arr, int n) {
		int[] lis = lis(arr, n), lds = lds(arr, n);
		int max = lis[0] + lds[0] - 1;
		for (int i = 1; i < n; i++) {
			max = Math.max(max, lis[i] + lds[i] - 1);
		}
		return max;
	}

	private static int[] lis(int[] arr, int n) {
		int[] lis = new int[n];
		Arrays.fill(lis, 1);
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
		}
		return lis;
	}

	private static int[] lds(int[] arr, int n) {
		int[] lds = new int[n];
		Arrays.fill(lds, 1);
		for (int i = n - 2; i >= 0; i--) {
			for (int j = n - 1; j > i; j--) {
				if (arr[j] < arr[i] && lds[i] < lds[j] + 1) {
					lds[i] = lds[j] + 1;
				}
			}
		}
		return lds;
	}
}
