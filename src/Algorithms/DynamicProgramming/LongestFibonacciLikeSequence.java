// https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/submissions/

package Algorithms.DynamicProgramming;

import java.util.TreeSet;

public class LongestFibonacciLikeSequence {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
//		int[] arr = {2, 4, 5, 6, 7, 8, 11, 13, 14, 15, 21, 22, 34};
//		int[] arr = {1, 3, 7, 11, 12, 14, 18};
		System.out.println(lengthOfSequence(arr));
	}

	private static int lengthOfSequence(int[] A) {
		int maxLen = 0, len, x, y;
		TreeSet<Integer> set = new TreeSet<>();
		for (int i : A) {
			set.add(i);
		}
		for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j < A.length; j++) {
				x = A[j];
				y = A[i] + A[j];
				len = 2;
				while (set.contains(y)) {
					int z = x + y;
					x = y;
					y = z;
					len++;
					maxLen = Math.max(maxLen, len);
				}
			}
		}
		return maxLen >= 3 ? maxLen : 0;
	}
}
