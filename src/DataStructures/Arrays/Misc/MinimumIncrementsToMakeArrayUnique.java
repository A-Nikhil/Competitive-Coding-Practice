package DataStructures.Arrays.Misc;

import java.util.Arrays;

public class MinimumIncrementsToMakeArrayUnique {
	public static void main(String[] args) {
		int[] arr = {3, 2, 1, 2, 1, 7};
		System.out.println(minIncrementForUnique(arr));
	}

	private static int minIncrementForUnique(int[] A) {
		Arrays.sort(A);
		int count = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] <= A[i - 1]) {
				count += A[i - 1] + 1 - A[i];
				A[i] = A[i - 1] + 1;
			}
		}
		return count;
	}
}
