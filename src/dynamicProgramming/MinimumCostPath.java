package dynamicProgramming;

public class MinimumCostPath {
	public static void main(String[] args) {
		int[][] cost = {
				{1, 2, 3},
				{4, 8, 2},
				{1, 5, 3}
		};
		System.out.println(minimumCostPath(cost, 3, 3));
	}

	private static int minimumCostPath(int[][] arr, int m, int n) {
		int[][] cost = new int[m + 1][n + 1];
		int i, j;
		for (i = 1; i <= m; i++) {
			cost[i][0] = arr[i - 1][0];
		}
		for (j = 1; j < n; j++) {
			cost[0][j] = arr[0][j - 1];
		}
		cost[0][0] = 0;
		for (i = 1; i <= m; i++) {
			for (j = 1; j <= n; j++) {
				cost[i][j] = arr[i - 1][j - 1] +
						Math.min(
								Math.min(cost[i - 1][j - 1], cost[i - 1][j]),
								cost[i][j - 1]);
			}
		}
		return cost[m][n];
	}
}
