package Algorithms.Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SieveOfErasothenes {
	public static void main(String[] args) {
		// prime numbers under n
		int n = 10;
		System.out.println(new SieveOfErasothenes().erasothenes(n));
	}

	public List<Integer> erasothenes(int n) {
		List<Integer> result = new ArrayList<>();
		if (n < 2) {
			return result;
		}
		boolean[] primes = new boolean[n + 1];
		Arrays.fill(primes, true);
		for (int p = 2; p * p <= n; p++) {
			if (primes[p]) {
				for (int i = p * p; i <= n; i += p) {
					primes[i] = false;
				}
			}
		}
		for (int i = 2; i <= n; i++) {
			if (primes[i]) {
				result.add(i);
			}
		}
		return result;
	}
}
