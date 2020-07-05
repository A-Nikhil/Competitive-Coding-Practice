package DataStructures.Arrays.OrderStatistics;

public class ElementsWhichHaveAtleast2ElementsGreater {
	public static void main(String[] args) {
		int[] arr = {2, -6, 3, 5, 1};
		printNumbers(arr, arr.length);
	}

	private static void printNumbers(int[] arr, int n) {
		int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
		for (int i : arr) {
			if (i > first) {
				second = first;
				first = i;
			} else if (i > second) {
				second = i;
			}
		}
		for (int i : arr) {
			if (i <= second) {
				System.out.print(i + " ");
			}
		}
	}
}
