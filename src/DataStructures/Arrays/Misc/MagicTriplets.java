package DataStructures.Arrays.Misc;

import Commons.ArrayPrinter;

public class MagicTriplets {
	public static void main(String[] args) {
//		int[] arr = {7, 3, 4, 3, 3, 1};
		int[] arr = {3, 2, 1};
		System.out.println(findTriplets(arr));
	}

	private static int findTriplets(int[] arr) {
		int[] gleft = new int[arr.length];
		int[] sright = new int[arr.length];
		gleft[0] = 0;
		int count;
		for (int i = 1; i < arr.length; i++) {
			count = 0;
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[i]) {
					count++;
				}
			}
			gleft[i] = count;
		}

		for (int i = 0; i < arr.length - 1; i++) {
			count = 0;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					count++;
				}
			}
			sright[i] = count;
		}

		new ArrayPrinter().printArray(gleft);
		System.out.println();
		new ArrayPrinter().printArray(sright);
		count = 0;
		for (int i = 0; i < arr.length; i++) {
			count += gleft[i] * sright[i];
		}
		return count;
	}
}
