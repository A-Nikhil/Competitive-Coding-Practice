package DataStructures.Arrays.Rearrangement;

import Commons.ArrayPrinter;

public class RearrangeSuchThatAiEQi {
	public static void main(String[] args) {
		int[] A = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
		fix(A, A.length);
	}

	private static void fix(int[] arr, int n) {
		int x, y;
		for (int i = 0; i < n; i++) {
			if (arr[i] != -1 && arr[i] != i) {
				x = arr[i];
				while (arr[x] != -1 && arr[x] != x) {
					y = arr[x];
					arr[x] = x;
					x = y;
				}
				arr[x] = x;
				if (arr[i] != i) {
					arr[i] = -1;
				}
			}
		}
		new ArrayPrinter().printArray(arr);
	}
}
