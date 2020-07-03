package Algorithms.Sorting;

public class CommonElementInSortedArrays {
	public static void main(String[] args) {
		int[] ar1 = {1, 5, 10, 20, 40, 80};
		int[] ar2 = {6, 7, 20, 80, 100};
		int[] ar3 = {3, 4, 15, 20, 30, 70, 80, 120};
		printCommon(ar1, ar2, ar3, ar1.length, ar2.length, ar3.length);
	}

	private static void printCommon(int[] arr1, int[] arr2, int[] arr3,
									int l1, int l2, int l3) {
		int i, j, k;
		i = j = k = 0;
		while (i < l1 && j < l2 && k < l3) {
			if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
				System.out.println(arr1[i]);
				i++;
				j++;
				k++;
			} else if (arr1[i] < arr2[j]) {
				i++;
			} else if (arr1[i] > arr3[k] && arr2[j] > arr3[k]) {
				k++;
			} else {
				j++;
			}
		}
	}
}
