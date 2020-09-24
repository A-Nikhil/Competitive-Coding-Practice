package LeetCode;

public class CarPooling {
	public static void main(String[] args) {
		int[][] trips = {{3, 2, 7}, {3, 7, 9}, {8, 3, 9}};
		int capacity = 11;
		System.out.println(new CarPooling().carPooling(trips, capacity));
	}

	public boolean carPooling(int[][] trips, int capacity) {
		int max = -1;
		for (int[] trip : trips) {
			max = Math.max(max, trip[2]);

		}
		int[] locations = new int[max + 1];
		for (int[] trip : trips) {
			locations[trip[1]] += trip[0];
			locations[trip[2]] -= trip[0];
		}
		int sum = 0;
		for (int i = 0; i < max; i++) {
			sum += locations[i];
			locations[i] = sum;
			if (sum > capacity)
				return false;
		}
		return true;
	}
}
