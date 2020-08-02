// https://leetcode.com/problems/first-missing-positive/

package DataStructures.Arrays.Misc;

public class FirstMissingPositive {
	public static void main(String[] args) {
		// int[] arr = { 3, 4, -1, 1 };
		// int[] arr = { 1, 2, 0 };
		int[] arr = {1, 2};
		System.out.println(new FirstMissingPositive().firstMissingPositive(arr));
	}

	public int firstMissingPositive(int[] A) {
		int n = A.length;
		for (int i = 0; i < n; i++) {
			if (A[i] > 0 && A[i] <= n) {
				if (A[i] - 1 != i && A[A[i] - 1] != A[i]) {
					int temp = A[A[i] - 1];
					A[A[i] - 1] = A[i];
					A[i] = temp;
					i--;
				}
			}
		}
		for (int i = 0; i < n; i++)
			if (A[i] != i + 1)
				return i + 1;
		return n + 1;
	}
}