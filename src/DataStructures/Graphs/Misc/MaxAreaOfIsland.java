package DataStructures.Graphs.Misc;

public class MaxAreaOfIsland {
	private static int R, C, size;

	private static int maxAreaOfIsland(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		R = grid.length;
		C = grid[0].length;
		boolean[][] visited = new boolean[R][C];
		int max = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (grid[i][j] == 1 && !visited[i][j]) {
					size = 0;
					DFS(grid, i, j, visited);
					max = Math.max(size, max);
				}
			}
		}
		return max;
	}

	private static boolean isValid(int x, int y) {
		return ((x >= 0) && (y >= 0) && (x < R) && (y < C));
	}

	private static void DFS(int[][] grid, int x, int y, boolean[][] visited) {
		if (!isValid(x, y)) {
			return;
		}

		if (grid[x][y] != 1 || visited[x][y]) {
			return;
		}

		size++;
		visited[x][y] = true;

		DFS(grid, x + 1, y, visited);
		DFS(grid, x - 1, y, visited);
		DFS(grid, x, y + 1, visited);
		DFS(grid, x, y - 1, visited);

	}

	public static void main(String[] args) {
		int[][] grid = {
				{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
				{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
				{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
		};

		System.out.println(maxAreaOfIsland(grid));
	}
}
