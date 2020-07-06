package DataStructures.Queues;

public class PetrolPumpTour {
	public static void main(String[] args) {
//		int[][] arr = {{4, 6}, {6, 5}, {7, 3}, {4, 5}};
//		int[][] arr = {{6, 4}, {3, 6}, {7, 3}};
		int[][] arr = {{3, 3}, {3, 4}, {4, 4}};
		System.out.println(getTour(arr, arr.length));
	}

	private static int getTour(int[][] arr, int n) {
		int start = 0, pos;
		int petrol = 0, distance;
		while (start < n) {
			petrol = arr[start][0];
			distance = arr[start][1];
			pos = start;
			while (petrol >= distance) {
				pos = (pos + 1) % n;
				petrol = petrol - distance;
				petrol += arr[pos][0];
				distance = arr[pos][1];
				if (pos == start) {
					return pos;
				}
			}
			start = (start + 1) % n;
			if (start == 0) {
				return -1;
			}
		}
		return -1;
	}
}
