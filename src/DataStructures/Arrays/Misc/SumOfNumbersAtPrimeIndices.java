// Given an array of integers, find out the sum of elements at prime indexes

package DataStructures.Arrays.Misc;

import java.util.ArrayList;
import java.util.List;

public class SumOfNumbersAtPrimeIndices {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(new SumOfNumbersAtPrimeIndices().getSum(arr));
	}

	public int getSum(int[] arr) {
		List<Integer> primes = erasothenes(arr.length);
		int sum = 0;
		for (int i : primes) {
			sum += arr[i - 1];
		}
		return sum;
	}

	private List<Integer> erasothenes(int n) {
		boolean[] primes = new boolean[n + 1];
		// Instead of marking primes as true, I am marking primes as false. Saves O(n)
		for (int p = 2; p * p <= n; p++) {
			if (!primes[p]) {
				for (int i = p * p; i <= n; i += p) {
					primes[i] = true;
				}
			}
		}
		List<Integer> result = new ArrayList<>();
		for (int i = 2; i <= n; i++) {
			if (!primes[i]) {
				result.add(i);
			}
		}
		return result;
	}
}
