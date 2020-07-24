// https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/

package DataStructures.Arrays.Misc;

public class SubArraysWithBoundedMaximum {
	public static void main(String[] args) {
		int[] arr = {2, 1, 4, 3};
		int L = 2, R = 3;
		System.out.println(numSubarrayBoundedMax(arr, L, R));
	}

	private static int numSubarrayBoundedMax(int[] A, int L, int R) {
		return getBelowCount(A, R) - getBelowCount(A, L - 1);
	}

	private static int getBelowCount(int[] A, int bound) {
		int count = 0, temp = 0;
		for (int i : A) {
			if (i <= bound) {
				temp++;
				count += temp;
			} else {
				temp = 0;
			}
		}
		return count;
	}
}
