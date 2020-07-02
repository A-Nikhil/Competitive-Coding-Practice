package DataStructures.Graphs.SpanningTrees;

import java.util.Arrays;
import java.util.HashSet;

@SuppressWarnings("Duplicates")
public class Prims {
	public static void main(String[] args) {
		int[][] graph = {
				{0, 2, 0, 6, 0},
				{2, 0, 3, 8, 5},
				{0, 3, 0, 0, 7},
				{6, 8, 0, 0, 9},
				{0, 5, 7, 9, 0}
		};
		int V = graph.length;
		MinSpanningTree(graph, V);
	}

	private static void MinSpanningTree(int[][] graph, int V) {
		HashSet<Integer> mstSet = new HashSet<>();
		int[] distances = new int[V];
		int[] parent = new int[V];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[0] = 0;
		while (mstSet.size() != V) {
			int vertex = findMinimum(distances, mstSet, V);
			mstSet.add(vertex);
			for (int v = 0; v < V; v++) {
				if (graph[vertex][v] > 0 && graph[vertex][v] < distances[v] &&
						!mstSet.contains(v)) {
					distances[v] = graph[vertex][v];
					parent[v] = vertex;
				}
			}
		}
		printMST(graph, V, parent);
	}

	private static int findMinimum(int[] distances, HashSet<Integer> mstSet, int V) {
		int small = Integer.MAX_VALUE, pos = 0;
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

	private static void printMST(int[][] graph, int V, int[] parent) {
		System.out.println("Edge \tWeight");
		for (int i = 1; i < V; i++)
			System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
	}
}
