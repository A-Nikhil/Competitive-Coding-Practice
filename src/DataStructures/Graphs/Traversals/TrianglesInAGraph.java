/*
This program calculates the number of triangles in a graph
 */

package DataStructures.Graphs.Traversals;

public class TrianglesInAGraph {
	public static void main(String[] args) {
		int[][] graph = {{0, 1, 1, 0},
				{1, 0, 1, 1},
				{1, 1, 0, 1},
				{0, 1, 1, 0}
		};
		System.out.println(findTriangles(graph, 4));
	}

	private static int findTriangles(int[][] graph, int V) {
		int[][] aux2 = new int[V][V];
		int[][] aux3 = new int[V][V];
		multiply(graph, graph, aux2, V);
		multiply(graph, aux2, aux3, V);
		int trace = 0;
		for (int i = 0; i < V; i++) {
			trace += aux3[i][i];
		}
		return trace / 6;
	}

	private static void multiply(int[][] A, int[][] B, int[][] C, int V) {
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				C[i][j] = 0;
				for (int k = 0; k < V; k++) {
					C[i][j] += A[i][k] * B[k][j];
				}
			}
		}
	}
}
