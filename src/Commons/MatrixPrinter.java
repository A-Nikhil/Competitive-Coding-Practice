package Commons;

public class MatrixPrinter {
	public void printMatrix(int[][] matrix) {
		int n = matrix.length;
		for (int[] ints : matrix) {
			for (int j = 0; j < n; j++) {
				System.out.print(ints[j] + " ");
			}
			System.out.println();
		}
	}
}
