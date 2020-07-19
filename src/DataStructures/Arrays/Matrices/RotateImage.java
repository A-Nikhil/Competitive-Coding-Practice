package DataStructures.Arrays.Matrices;

import Commons.MatrixPrinter;

public class RotateImage {
	public static void main(String[] args) {
		int[][] matrix = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		rotate(matrix);
	}

	private static void rotate(int[][] matrix) {
		int n = matrix.length, i, j, temp;

		// transpose
		for (i = 0; i < n; i++) {
			for (j = i + 1; j < n; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

//		new MatrixPrinter().printMatrix(matrix);

		// switch
		int start = 0, end = n - 1;
		for (j = 0; j < n / 2; j++) {
			if (start < end) {
				for (i = 0; i < n; i++) {
					temp = matrix[i][start];
					matrix[i][start] = matrix[i][end];
					matrix[i][end] = temp;
				}
			}
			start++;
			end--;
		}

		new MatrixPrinter().printMatrix(matrix);
	}
}
