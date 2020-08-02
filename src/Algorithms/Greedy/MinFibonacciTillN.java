package Algorithms.Greedy;

import java.util.ArrayList;
import java.util.List;

public class MinFibonacciTillN {
	public static void main(String[] args) {
		int k = 513314;
		System.out.println(new MinFibonacciTillN().findMinFibonacciNumbers(k));
	}

	public int findMinFibonacciNumbers(int k) {
		if (k == 0) {
			return 0;
		}
		if (k == 1) {
			return 1;
		}
		List<Integer> fibo = new ArrayList<>();
		fibo.add(1);
		fibo.add(1);
		for (int i = 2; i <= k; i++) {
			fibo.add(fibo.get(i - 1) + fibo.get(i - 2));
			if (fibo.get(i) > k) {
				break;
			}
		}
		int count = 0;
		int j = fibo.size() - 1;
		while (k > 0) {
			count += (k / fibo.get(j));
			k %= (fibo.get(j));
			j--;
		}
		return count;
	}
}
