/*
MergeSort(arr[], l,  r)
If r > l
     1. Find the middle point to divide the array into two halves:
             middle m = (l+r)/2
     2. Call mergeSort for first half:
             Call mergeSort(arr, l, m)
     3. Call mergeSort for second half:
             Call mergeSort(arr, m+1, r)
     4. Merge the two halves sorted in step 2 and 3:
             Call merge(arr, l, m, r)
 */

package Algorithms.Sorting;

import Commons.ArrayPrinter;

public class MergeSort {
	@SuppressWarnings("Duplicates")
	public static void main(String[] args) {
		int[] arr = {10, 23, 19, 15, 48, 26, 54};
		new ArrayPrinter().printArray(driver(arr, arr.length), arr.length);
	}

	private static int[] driver(int[] arr, int n) {
		mergeSort(arr, 0, n - 1);
		return arr;
	}

	private static void mergeSort(int[] arr, int l, int r) {
		if (l < r) {
			int mid = (l + r) / 2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid + 1, r);
			merge(arr, l, mid, r);
		}
	}

	private static void merge(int[] arr, int l, int mid, int r) {
		int n1 = mid - l + 1, n2 = r - mid, i, j;
		int[] L = new int[n1];
		int[] R = new int[n2];
		for (i = 0; i < n1; i++) {
			L[i] = arr[i + l];
		}
		for (j = 0; j < n2; j++) {
			R[j] = arr[mid + 1 + j];
		}
		i = j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
}
