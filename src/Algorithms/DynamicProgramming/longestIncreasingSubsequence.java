package Algorithms.DynamicProgramming;

import java.util.Arrays;

public class longestIncreasingSubsequence {
	public static void main(String[] args) {
		int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
		System.out.println(lis(arr, arr.length));
	}

	private static int lis(int[] arr, int n) {
		int[] lis = new int[n];
		int max = 1;
		Arrays.fill(lis, 1);
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
				if (max < lis[i]) {
					max = lis[i];
				}
			}
		}
		return max;
	}
}
