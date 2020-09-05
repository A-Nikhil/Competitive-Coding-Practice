/*
Shortest Source to Destination Path

Given a boolean 2D matrix (0-based index), find whether there is path from (0,0) to (x,y) and
if there is one path, print the minimum no of steps needed to reach it,
else print -1 if the destination is not reachable. You may move in only four direction
ie up, down, left and right. The path can only be created out of a cell if its value is 1.

Input:
The first line of input contains an integer T denoting the no of Others.test cases.
Then T Others.test cases follow. Each Others.test case contains two lines .
The first line of each Others.test case contains two integers n and m denoting the size of the matrix.
Then in the next line are n*m space separated values of the matrix.
The following line after it contains two integers x and y denoting the index of the destination.

Output:
For each Others.test case print in a new line the min no of steps needed to reach the destination.

Constraints:
1<=T<=100
1<=n,m<=20

Example:
Input:
2
3 4
1 0 0 0 1 1 0 1 0 1 1 1
2 3
3 4
1 1 1 1 0 0 0 1 0 0 0 1
0 3
Output:
5
3

Approach =>
The idea is to BFS (breadth first search) on matrix cells.
Note that we can always use BFS to find shortest path if graph is unweighted.
	1. Store each cell as a node with their row, column values and distance from source cell.
	2. Start BFS with source cell.
	3. Make a visited array with all having “false” values except ‘0’cells which are assigned “true” values
		as they can not be traversed.
	4. Keep updating distance from source value in each move.
	5. Return distance when destination is met, else return -1 (no path exists in between source and destination).

https://practice.geeksforgeeks.org/problems/shortest-source-to-destination-path/
 */

package DataStructures.Graphs.Cycles;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestSourcePath {
	public static void main(String[] args) {
		try {
			int m = 3, n = 4;
			int[][] matrix = new int[m][n];
			String[] elements = "1 0 0 0 1 1 0 1 0 1 1 1".split(" ");
			int k = 0;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = Integer.parseInt(elements[k]);
					k++;
				}
			}
			int destX = 2, destY = 3;
			System.out.println(minimumDistance(matrix, m, n, destX, destY));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static int minimumDistance(int[][] matrix, int m, int n, int destX, int destY) {
		if (destX == 0 && destY == 0) {
			return 0;
		}

		boolean[][] visited = new boolean[m][n];

		// Marking invalid nodes as visited
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					visited[i][j] = true;
					if (i == destX && j == destY) {
						return -1;
					}
				}
			}
		}

		QueueItem source = new QueueItem(0, 0, 0);
		Queue<QueueItem> queue = new LinkedList<>();
		queue.add(source);
		visited[0][0] = true;
		while (!queue.isEmpty()) {
			source = queue.poll();
			int row = source.row, col = source.col;
			if (row == destX && col == destY) {
				return source.steps;
			} else {
				// Top
				if (row > 0 && !visited[row - 1][col]) {
					queue.add(new QueueItem(row - 1, col, source.steps + 1));
					visited[row - 1][col] = true;
				}

				// Bottom
				if (row < m - 1 && !visited[row + 1][col]) {
					queue.add(new QueueItem(row + 1, col, source.steps + 1));
					visited[row + 1][col] = true;
				}

				// Right
				if (col < n - 1 && !visited[row][col + 1]) {
					queue.add(new QueueItem(row, col + 1, source.steps + 1));
					visited[row][col + 1] = true;
				}

				// Left
				if (col > 0 && !visited[row][col - 1]) {
					queue.add(new QueueItem(row, col - 1, source.steps + 1));
					visited[row][col - 1] = true;
				}
			}
		}
		return -1;
	}

	static class QueueItem {
		int row, col, steps;

		QueueItem(int row, int col, int steps) {
			this.row = row;
			this.col = col;
			this.steps = steps;
		}
	}
}
