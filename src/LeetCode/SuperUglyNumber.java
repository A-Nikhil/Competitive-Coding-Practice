// https://leetcode.com/problems/super-ugly-number/
package LeetCode;

import java.util.PriorityQueue;

public class SuperUglyNumber {
	public static void main(String[] args) {
		int[] primes = {2, 7, 13, 19};
		int n = 32;
		System.out.println(new SuperUglyNumber().nthSuperUglyNumber(n, primes));
	}

	public int nthSuperUglyNumber(int n, int[] primes) {
		PriorityQueue<Long> pq = new PriorityQueue<>();
		pq.add(1L);
		for (int i = 1; i < n; i++) {
			long num = pq.poll();
			while (!pq.isEmpty() && pq.peek() == num) {
				pq.poll();
			}
			for (int prime : primes) {
				pq.add(prime * num);
			}
		}
		return pq.poll().intValue();
	}
}
