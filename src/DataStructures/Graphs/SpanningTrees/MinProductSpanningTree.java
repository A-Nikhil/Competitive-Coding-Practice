package DataStructures.Graphs.SpanningTrees;

import java.util.Arrays;
import java.util.HashSet;

@SuppressWarnings("Duplicates")
public class MinProductSpanningTree {
	public static void main(String[] args) {
		int[][] graph = {
				{0, 2, 0, 6, 0},
				{2, 0, 3, 8, 5},
				{0, 3, 0, 0, 7},
				{6, 8, 0, 0, 9},
				{0, 5, 7, 9, 0},
		};

		// Print the solution
		System.out.println(getMinimumProduct(graph, graph.length));
	}

	private static int getMinimumProduct(int[][] graph, int V) {
		double[][] logGraph = new double[V][V];
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				logGraph[i][j] = graph[i][j] > 0 ? Math.log(graph[i][j]) : 0;
			}
		}
		return MinSpanningTree(graph, V, logGraph);
	}

	private static int MinSpanningTree(int[][] graph, int V, double[][] logGraph) {
		HashSet<Integer> mstSet = new HashSet<>();
		double[] distances = new double[V];
		int[] parent = new int[V];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[0] = 0.0;
		while (mstSet.size() != V) {
			int vertex = findMinimum(distances, mstSet, V);
			mstSet.add(vertex);
			for (int v = 0; v < V; v++) {
				if (logGraph[vertex][v] > 0 && logGraph[vertex][v] < distances[v] &&
						!mstSet.contains(v)) {
					distances[v] = logGraph[vertex][v];
					parent[v] = vertex;
				}
			}
		}
		return printMST(graph, V, parent);
	}

	private static int findMinimum(double[] distances, HashSet<Integer> mstSet, int V) {
		double small = Double.MAX_VALUE;
		int pos = 0;
		for (int i = 0; i < V; i++) {
			if (!mstSet.contains(i)) {
				if (distances[i] < small) {
					small = distances[i];
					pos = i;
				}
			}
		}
		return pos;
	}

	private static int printMST(int[][] graph, int V, int[] parent) {
		int product = 1;
		for (int i = 1; i < V; i++) {
			product *= graph[parent[i]][i];
		}
		return product;
	}
}
