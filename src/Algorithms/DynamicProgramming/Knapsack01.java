package Algorithms.DynamicProgramming;

public class Knapsack01 {
	public static void main(String[] args) {
		int[] val = {60, 100, 120};
		int[] wt = {10, 20, 30};
		int W = 50;
		int n = val.length;
		System.out.println(knapsack(W, wt, val, n));
	}

	private static int knapsack(int W, int[] wt, int[] val, int items) {
		int[][] kp = new int[items + 1][W + 1];
		int i, j;
		for (i = 0; i <= items; i++) {
			for (j = 0; j <= W; j++) {
				if (i == 0 || j == 0) {
					kp[i][j] = 0;
				} else if (wt[i - 1] <= j) {
					kp[i][j] = Math.max(
							kp[i - 1][j],
							val[i - 1] + kp[i - 1][j - wt[i - 1]]
					);
				} else {
					kp[i][j] = kp[i - 1][j];
				}
			}
		}
		return kp[items][W];
	}
}
