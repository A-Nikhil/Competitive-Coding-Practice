/*
Rearrange an array in order – smallest, largest, 2nd smallest, 2nd largest, ..
 */

package DataStructures.Arrays.Rearrangement;

import Commons.ArrayPrinter;

import java.util.Arrays;

public class RearrangeArrayInOrder {
	public static void main(String[] args) {
		int[] arr = {5, 8, 1, 4, 2, 9, 3, 7, 6};
		new ArrayPrinter().printArray(rearrange(arr, arr.length));
	}

	private static int[] rearrange(int[] arr, int n) {
		Arrays.sort(arr);
		int[] temp = new int[n];
		int i = 0, j = n - 1;
		int count = 0;
		while (count < n) {
			if (count % 2 == 0) {
				temp[count] = arr[i];
				i++;
			} else {
				temp[count] = arr[j];
				j--;
			}
			count++;
		}
		return temp;
	}
}
