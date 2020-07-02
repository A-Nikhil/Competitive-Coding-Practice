/*
There is a m*n rectangular matrix whose top-left(start)
location is (1, 1) and bottom-right(end) location is (m*n).
There are k circles each with radius r. Find if there is any path from start to end without touching any circle.

The input contains values of m, n, k, r and two array of integers X and Y, each of length k.
(X[i], Y[i]) is the centre of ith circle.

https://www.geeksforgeeks.org/path-rectangle-containing-circles/
 */

package DataStructures.Graphs.Cycles;

import java.util.LinkedList;
import java.util.Queue;

public class RectanglesWithCircles {
	public static void main(String[] args) {
		int m = 5, n = 5, k = 2, r = 1;
		System.out.println(doesPathExist(m, n, k, r, new int[]{1, 3}, new int[]{3, 3}));
		System.out.println(doesPathExist(m, n, k, r, new int[]{1, 1}, new int[]{2, 3}));
	}

	private static boolean doesPathExist(int m, int n, int k, int r, int[] X, int[] Y) {
		int[][] rectangle = new int[m][n];
		// check for reachable cells
		for (int c = 0; c < k; c++) {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (underCircle(i, j, X[c], Y[c], r)) {
						rectangle[i][j] = -1;
					}
				}
			}
		}
		if (rectangle[0][0] == -1) {
			return false;
		}
		rectangle[0][0] = 1;
		Queue<Integer[]> queue = new LinkedList<>();
		queue.add(new Integer[]{0, 0});
		while (!queue.isEmpty()) {
			Integer[] current = queue.poll();
			int x = current[0], y = current[1];
			// Top left
			if (x > 0 && y > 0 && rectangle[x - 1][y - 1] == 0) {
				rectangle[x - 1][y - 1] = 1;
				queue.add(new Integer[]{x - 1, y - 1});
			}
			// Top
			if (x > 0 && rectangle[x - 1][y] == 0) {
				rectangle[x - 1][y] = 1;
				queue.add(new Integer[]{x - 1, y});
			}
			// Top right
			if (x > 0 && y < n - 1 && rectangle[x - 1][y + 1] == 0) {
				rectangle[x - 1][y + 1] = 1;
				queue.add(new Integer[]{x - 1, y + 1});
			}
			// left
			if (y > 0 && rectangle[x][y - 1] == 0) {
				rectangle[x][y - 1] = 1;
				queue.add(new Integer[]{x, y - 1});
			}
			// Right
			if (y < n - 1 && rectangle[x][y + 1] == 0) {
				rectangle[x][y + 1] = 1;
				queue.add(new Integer[]{x, y + 1});
			}
			// Bottom left
			if (x < m - 1 && y > 0 && rectangle[x + 1][y - 1] == 0) {
				rectangle[x + 1][y - 1] = 1;
				queue.add(new Integer[]{x + 1, y - 1});
			}
			// Bottom
			if (x < m - 1 && rectangle[x + 1][y] == 0) {
				rectangle[x + 1][y] = 1;
				queue.add(new Integer[]{x + 1, y});
			}
			// Bottom left
			if (x < m - 1 && y < n - 1 && rectangle[x + 1][y + 1] == 0) {
				rectangle[x + 1][y + 1] = 1;
				queue.add(new Integer[]{x + 1, y + 1});
			}
		}
		return rectangle[m - 1][n - 1] == 1;
	}

	private static boolean underCircle(int x1, int y1, int x2, int y2, int r) {
		x2--;
		y2--;
		return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow(y1 - y2, 2)) <= r;
	}
}
