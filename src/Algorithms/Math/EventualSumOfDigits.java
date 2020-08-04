/*
579 = 5 + 7 + 9 = 21
21 = 2 + 1 = 3

Answer = 3
 */

package Algorithms.Math;

public class EventualSumOfDigits {
	public static void main(String[] args) {
		int n = 579;
		System.out.println(new EventualSumOfDigits().eventualSum(n));
	}

	public int eventualSum(int n) {
		if (n < 10) {
			return n;
		}
		int sum = 0;
		while (n > 9) {
			while (n > 0) {
				sum += n % 10;
				n /= 10;
			}
			n = sum;
			sum = 0;
		}
		return n;
	}
}
