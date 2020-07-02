package DataStructures.Queues;

import java.util.LinkedList;
import java.util.Queue;

public class MinTimeToRotOranges {
	private static final int[] rowMod = {1, 0, -1, 0}; // Up - Left - Down - Right
	private static final int[] colMod = {0, -1, 0, 1}; // Up - Left - Down - Right
	private static int R, C;

	public static void main(String[] args) {
		int[][] arr = {
				{2, 1, 0, 2, 1},
				{1, 0, 1, 2, 1},
				{1, 0, 0, 2, 1}
		};
		System.out.println(rotOranges(arr, arr.length, arr[0].length));
	}

	private static int rotOranges(int[][] mat, int r, int c) {
		R = r;
		C = c;
		int ans = 0, currX, currY;
		Queue<Element> queue = new LinkedList<>();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < C; j++) {
				if (mat[i][j] == 2) {
					queue.add(new Element(i, j));
				}
			}
		}
		queue.add(new Element(-1, -1));
		boolean flag;
		while (!queue.isEmpty()) {
			flag = false;
			while (!queue.isEmpty() && !isDelim(queue.peek().x, queue.peek().y)) {
				for (int i = 0; i < 4; i++) {
					assert queue.peek() != null;
					currX = queue.peek().x + rowMod[i];
					currY = queue.peek().y + colMod[i];
					if (isValid(currX, currY) && mat[currX][currY] == 1) {
						if (!flag) {
							ans++;
							flag = true;
						}
						mat[currX][currY] = 2; // rot the cell
						queue.add(new Element(currX, currY)); // add the newly rotted orange
					}
				}
				queue.remove();
			}
			queue.remove();
			if (!queue.isEmpty()) {
				queue.add(new Element(-1, -1));
			}
		}
		return checkAll(mat) ? -1 : ans;
	}

	private static boolean isDelim(int x, int y) {
		return x == -1 && y == -1;
	}

	private static boolean isValid(int x, int y) {
		return ((x >= 0) && (y >= 0) && (x < R) && (y < C));
	}

	private static boolean checkAll(int[][] mat) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (mat[i][j] == 1) {
					return true;
				}
			}
		}
		return false;
	}

	static class Element {
		int x, y;

		public Element(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
