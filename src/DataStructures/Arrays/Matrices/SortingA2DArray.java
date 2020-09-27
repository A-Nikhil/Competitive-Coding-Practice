package DataStructures.Arrays.Matrices;

import java.util.PriorityQueue;

public class SortingA2DArray {
	public static void main(String[] args) {
		int[][] mat = {
				{10, 20, 30, 40},
				{15, 25, 35, 45},
				{27, 29, 37, 48},
				{32, 33, 39, 50},
		};
		new SortingA2DArray().sort(mat);
	}

	public void sort(int[][] arr) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				pq.add(arr[i][j]);
			}
		}
		for (int i = 0; i < arr.length * arr[0].length; i++) {
			System.out.println(pq.poll());
		}
	}
}
