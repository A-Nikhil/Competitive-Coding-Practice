package DataStructures.Arrays.Matrices;

public class SpiralOrderTraversal {
	public static void main(String[] args) {
		int n = 4;
		spiral(n);
	}

	private static void spiral(int n) {
		int i = 0, j = 0, index = 0;
		int colRight = n - 1, colLeft = 0, rowDown = n - 1, rowUp = 1;
		boolean travRowUp, travRowDown, travColLeft, travColRight = true;
		travRowUp = travRowDown = travColLeft = false;
		int[][] arr = new int[n][n];
		while (index < n * n) {
			System.out.println(i + " " + j);
			arr[i][j] = index;
			index++;

			if (travColRight) {
				if (j == colRight) {
					travRowDown = true;
					i++;
					travColRight = false;
					colRight--;
					continue;
				} else {
					j++;
				}
			}

			if (travColLeft) {
				if (j == colLeft) {
					travRowUp = true;
					i--;
					travColLeft = false;
					colLeft++;
					continue;
				} else {
					j--;
				}
			}

			if (travRowUp) {
				if (i == rowUp) {
					travColRight = true;
					travRowUp = false;
					j++;
					rowUp++;
					continue;
				} else {
					i--;
				}
			}

			if (travRowDown) {
				if (i == rowDown) {
					travColLeft = true;
					travRowDown = false;
					j--;
					rowDown--;
				} else {
					i++;
				}
			}
		}

		for (int[] x : arr) {
			for (int z : x) {
				System.out.print(z + " ");
			}
			System.out.println();
		}
	}
}
