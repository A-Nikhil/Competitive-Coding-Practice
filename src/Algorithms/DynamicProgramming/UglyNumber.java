package Algorithms.DynamicProgramming;

public class UglyNumber {
	public static void main(String[] args) {
		int[] arr = {7, 10, 15, 150};
		for (int i : arr) {
			System.out.println(getUgly(i));
		}
	}

	private static int getUgly(int n) {
		int[] ugly = new int[n];
		int i2, i3, i5;
		i2 = i3 = i5 = 0;
		ugly[0] = 1;
		int m2 = ugly[i2] * 2,
				m3 = ugly[i3] * 3,
				m5 = ugly[i5] * 5;
		int next = 0;
		for (int i = 1; i < n; i++) {
			next = Math.min(Math.min(m2, m3), m5);
			ugly[i] = next;
			if (m2 == next) {
				i2++;
				m2 = ugly[i2] * 2;
			}
			if (m3 == next) {
				i3++;
				m3 = ugly[i3] * 3;
			}
			if (m5 == next) {
				i5++;
				m5 = ugly[i5] * 5;
			}
		}
		return next;
	}
}
