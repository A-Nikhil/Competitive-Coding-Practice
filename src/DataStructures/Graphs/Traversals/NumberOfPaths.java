/*
Given a graph, a source vertex and a destination vertex, find the number of paths
https://www.geeksforgeeks.org/count-possible-paths-two-vertices/
 */
package DataStructures.Graphs.Traversals;

public class NumberOfPaths {
	private static int counter = 0;

	private static void vertexIterator(int[][] graph, int current, int destination, int V) {
		if (current == destination) {
			counter++;
		} else {
			for (int v = 0; v < V; v++) {
				if (graph[current][v] == 1) {
					vertexIterator(graph, v, destination, V);
				}
			}
		}
	}

	private static void countPaths(int[][] graph, int V, int source, int destination) {
		vertexIterator(graph, source, destination, V);
		System.out.println("Number of paths => " + counter);
	}

	public static void main(String[] args) {
		int[][] graph = {
				{0, 1, 1, 0, 1},
				{0, 0, 0, 1, 1},
				{0, 0, 0, 0, 1},
				{0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0}
		};
		int V = 5;
		int source = 0, destination = 4;
		countPaths(graph, V, source, destination);
	}
}
