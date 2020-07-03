package DataStructures.Arrays.Rotations;

public class FindElementAtPositionAfterRotations {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};

		// No. of rotations
		int rotations = 2;

		// Ranges according to 0-based indexing
		int[][] ranges = {{0, 2}, {0, 3}};

		int index = 1;

		System.out.println(returnElement(arr, ranges, rotations, index));
	}

	private static int returnElement(int[] arr, int[][] ranges, int rotations, int index) {
		int left, right, i;
		for (i = rotations - 1; i >= 0; i--) {
			left = ranges[i][0];
			right = ranges[i][1];
			if (left <= index && right >= index) {
				if (index == left) {
					index = right;
				} else {
					index--;
				}
			}
		}
		return arr[index];
	}
}
