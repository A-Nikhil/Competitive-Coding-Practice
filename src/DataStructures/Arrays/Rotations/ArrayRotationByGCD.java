package DataStructures.Arrays.Rotations;

import Commons.ArrayPrinter;

public class ArrayRotationByGCD {
	private static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}

	private static void leftRotate(int[] arr, int n, int d) {
		// to handle d > n
		d = d % n;
		int i, j, k, temp;
//		int gcd = gcd(d, n);
		int gcd = gcd(n, d);
		for (i = 0; i < gcd; i++) {
			temp = arr[i];
			j = i;
			while (true) {
				k = j + d;
				if (k >= n) {
					k = k - n;
				}
				if (k == i) {
					break;
				}
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}
		new ArrayPrinter().printArray(arr, arr.length);
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		int d = 2;
		leftRotate(arr, arr.length, d);
	}
}
