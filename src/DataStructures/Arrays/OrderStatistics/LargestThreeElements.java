package DataStructures.Arrays.OrderStatistics;

public class LargestThreeElements {
	public static void main(String[] args) {
		int[] arr = {12, 13, 1, 10, 34, 1};
		int n = arr.length;
		findThree(arr, n);
	}

	private static void findThree(int[] arr, int n) {
		int first, second, third;
		first = second = third = Integer.MIN_VALUE;
		for (int i : arr) {
			if (i > first) {
				third = second;
				second = first;
				first = i;
			} else if (i > second) {
				third = second;
				second = i;
			} else if (i > third) {
				third = i;
			}
		}
		System.out.println(first + " " + second + " " + third);
	}
}
