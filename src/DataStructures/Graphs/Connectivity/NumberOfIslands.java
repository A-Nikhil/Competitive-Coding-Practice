/*
Find the number of islands | Set 1 (Using DFS)
Given a boolean 2D matrix, find the number of islands.
A group of connected 1s forms an island. For example, the below matrix contains 5 islands

Example:
Input : mat[][] = {{1, 1, 0, 0, 0},
                   {0, 1, 0, 0, 1},
                   {1, 0, 0, 1, 1},
                   {0, 0, 0, 0, 0},
                   {1, 0, 1, 0, 1}
Output : 5
 */

package DataStructures.Graphs.Connectivity;

public class NumberOfIslands {
	private static void DFSUtil(int[][] matrix, int m, int n,
								int row, int col, boolean[][] visited) {
		visited[row][col] = true;
		int[] rowMovement = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] colMovement = {-1, 0, 1, -1, 1, -1, 0, 1};
		for (int k = 0; k < 8; k++) {
			if (isSafe(row + rowMovement[k], col + colMovement[k], m, n) &&
					!visited[row + rowMovement[k]][col + colMovement[k]] &&
					(matrix[row + rowMovement[k]][col + colMovement[k]] != 0)) {
				DFSUtil(matrix, m, n, row + rowMovement[k],
						col + colMovement[k], visited);
			}
		}
	}

	private static boolean isSafe(int row, int col, int m, int n) {
		return ((row >= 0) && (col >= 0) && (row < m) && (col < n));
	}

	private static int numberOfIslands(int[][] matrix, int m, int n) {
		boolean[][] visited = new boolean[m][n];
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 1 && !visited[i][j]) {
					DFSUtil(matrix, m, n, i, j, visited);
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] matrix = {
				{1, 1, 0, 0, 0},
				{0, 1, 0, 0, 1},
				{1, 0, 0, 1, 1},
				{0, 0, 0, 0, 0},
				{1, 0, 1, 0, 1}};
		int m = 5, n = 5;
		System.out.println(numberOfIslands(matrix, m, n));
	}
}
