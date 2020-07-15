package DataStructures.Arrays.Misc;

public class PrefixSumCorporateBookings {
	public static void main(String[] args) {
		int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
		int n = 5;
		for (int i : getBookings(bookings, n)) {
			System.out.print(i + " ");
		}
	}

	private static int[] getBookings(int[][] bookings, int n) {
		int[] arr = new int[n];
		for (int[] x : bookings) {
			arr[x[0] - 1] += x[2];
			if (x[1] < n) {
				arr[x[1]] -= x[2];
			}
		}
		for (int i = 1; i < n; i++) {
			arr[i] += arr[i - 1];
		}
		return arr;
	}
}
