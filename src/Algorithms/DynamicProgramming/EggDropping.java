package Algorithms.DynamicProgramming;

public class EggDropping {
	public static void main(String[] args) {
		System.out.println(minAttempts(2, 36));
	}

	private static int minAttempts(int n, int k) {
		int[][] egg = new int[n + 1][k + 1];
		int res;
		for (int i = 1; i <= n; i++) {
			egg[i][1] = 1;
			egg[i][0] = 0;
		}
		for (int i = 1; i <= k; i++) {
			egg[1][i] = i;
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 2; j <= k; j++) {
				egg[i][j] = Integer.MAX_VALUE;
				for (int x = 1; x <= j; x++) {
					res = 1 + Math.max(egg[i - 1][x - 1], egg[i][j - x]);
					if (res < egg[i][j]) {
						egg[i][j] = res;
					}
				}
			}
		}
		return egg[n][k];
	}
}
