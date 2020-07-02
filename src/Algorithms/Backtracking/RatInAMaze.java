package Algorithms.Backtracking;

public class RatInAMaze {
	private static int R, C;

	private static boolean solveMaze(int[][] mat, int r, int c) {
		R = r;
		C = c;
		int[][] sol = new int[R][C];
		return solveMazeUtil(mat, 0, 0, sol);

	}

	private static boolean solveMazeUtil(int[][] mat, int i, int j, int[][] sol) {
		if (i == R - 1 && j == C - 1 && mat[i][j] == 1) {
			sol[i][j] = 1;
			return true;
		}

		if (isValid(mat, i, j)) {
			sol[i][j] = 1;
			if (solveMazeUtil(mat, i + 1, j, sol)) {
				return true;
			}

			if (solveMazeUtil(mat, i, j + 1, sol)) {
				return true;
			}
			sol[i][j] = 0;
			return false;
		}

		return false;
	}

	private static boolean isValid(int[][] mat, int i, int j) {
		return ((i >= 0) && (j >= 0) && (i < R) && (j < C) && mat[i][j] == 1);
	}


	public static void main(String[] args) {
		int[][] maze = {
				{1, 0, 0, 0},
				{1, 1, 0, 1},
				{0, 1, 0, 0},
				{1, 1, 1, 1}
		};
		System.out.println(solveMaze(maze, maze.length, maze[0].length));
	}
}
