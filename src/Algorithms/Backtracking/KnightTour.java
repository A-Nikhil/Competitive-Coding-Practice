package Algorithms.Backtracking;

import java.util.Arrays;

public class KnightTour {
	private static final int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
	private static final int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};
	private static int N;

	private static boolean solveKT(int n) {
		N = n;
		int[][] sol = new int[n][n];
		for (int[] arr : sol) {
			Arrays.fill(arr, -1);
		}
		sol[0][0] = 0;
		return solveKTUtil(0, 0, 1, sol);
	}

	private static boolean solveKTUtil(int x, int y, int move, int[][] sol) {
		int k, nextX, nextY;
		if (move == N * N) {
			return true;
		}
		for (k = 0; k < 8; k++) {
			nextX = x + xMove[k];
			nextY = y + yMove[k];
			if (isValid(nextX, nextY, sol)) {
				sol[nextX][nextY] = move;
				if (solveKTUtil(nextX, nextY, move + 1, sol)) {
					return true;
				} else {
					sol[nextX][nextY] = -1;
				}
			}
		}
		return false;
	}

	private static boolean isValid(int x, int y, int[][] sol) {
		return ((x >= 0) && (y >= 0) && (x < N) && (y < N) && (sol[x][y] == -1));
	}

	public static void main(String[] args) {
		int n = 8;
		System.out.println(solveKT(n));
	}
}
