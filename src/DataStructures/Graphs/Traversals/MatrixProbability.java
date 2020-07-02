package DataStructures.Graphs.Traversals;

public class MatrixProbability {
	private static double DFS(int m, int n, int x, int y, int steps) {
		if ((x < 0) || (x > m) || (y < 0) || (y > n)) {
			return 0.0;
		}
		if (steps == 0) {
			return 1.0;
		}
		double probability = 0.0;
		// top
		probability += (DFS(m, n, x - 1, y, steps - 1) * 0.25);
		// bottom
		probability += (DFS(m, n, x + 1, y, steps - 1) * 0.25);
		// left
		probability += (DFS(m, n, x, y - 1, steps - 1) * 0.25);
		// top
		probability += (DFS(m, n, x, y + 1, steps - 1) * 0.25);
		return probability;
	}

	public static void main(String[] args) {
		System.out.println(DFS(5, 5, 1, 1, 2));
	}
}
