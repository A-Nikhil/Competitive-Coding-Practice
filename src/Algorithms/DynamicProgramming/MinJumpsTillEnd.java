package Algorithms.DynamicProgramming;

import java.util.Arrays;

public class MinJumpsTillEnd {
	public static void main(String[] args) {
//		int[] arr = {1, 3, 6, 1, 0, 9};
//		int[] arr = {3, 2, 1, 0, 4};
		int[] arr = {2, 3, 1, 1, 4};
		System.out.println(minJump(arr, arr.length));
	}

	private static int minJump(int[] arr, int n) {
		int[] jumps = new int[n + 1];
		int maxer = 99999999;
		Arrays.fill(jumps, maxer);
		jumps[0] = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (i <= j + arr[j] && jumps[j] != maxer) {
					jumps[i] = Math.min(jumps[i], jumps[j] + 1);
					break;
				}
			}
		}
		return jumps[n - 1];
	}
}
