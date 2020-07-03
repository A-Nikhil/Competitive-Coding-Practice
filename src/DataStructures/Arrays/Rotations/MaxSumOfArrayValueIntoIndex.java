package DataStructures.Arrays.Rotations;

public class MaxSumOfArrayValueIntoIndex {
	public static void main(String[] args) {
		int[] arr = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(getMax(arr, arr.length));
	}

	// Max of arr[i] * i among all rotations
	private static int getMax(int[] arr, int n) {
		int arrSum = 0, i, r0 = 0;
		for (i = 0; i < n; i++) {
			arrSum += arr[i];
			r0 += (i * arr[i]);
		}

		// R(j) - R(j-1) = arrSum - n * arr[n-j]
		// => R(j) = arrSum - n * arr[n-j] +R(j-1)
		int maxSum = r0, current, prev = r0;
		for (i = 1; i < n; i++) {
			current = arrSum - (n * arr[n - i]) + prev;
			if (maxSum < current) {
				maxSum = current;
			}
			prev = current;
		}
		return maxSum;
	}
}
