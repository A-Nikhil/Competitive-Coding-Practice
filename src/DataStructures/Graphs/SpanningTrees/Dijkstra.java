package DataStructures.Graphs.SpanningTrees;

import java.util.Arrays;
import java.util.HashSet;

@SuppressWarnings("Duplicates")
public class Dijkstra {
	public static void main(String[] args) {
		int[][] graph = {
				{0, 4, 0, 0, 0, 0, 0, 8, 0},
				{4, 0, 8, 0, 0, 0, 0, 11, 0},
				{0, 8, 0, 7, 0, 4, 0, 0, 2},
				{0, 0, 7, 0, 9, 14, 0, 0, 0},
				{0, 0, 0, 9, 0, 10, 0, 0, 0},
				{0, 0, 4, 14, 10, 0, 2, 0, 0},
				{0, 0, 0, 0, 0, 2, 0, 1, 6},
				{8, 11, 0, 0, 0, 0, 1, 0, 7},
				{0, 0, 2, 0, 0, 0, 6, 7, 0}
		};
		int V = graph.length, source = 0;
		dijkstra(graph, V, source);
	}

	private static void dijkstra(int[][] graph, int V, int source) {
		HashSet<Integer> sptSet = new HashSet<>();
		int[] distances = new int[V];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[source] = 0;
		while (sptSet.size() != V) {
			int u = findMinimum(distances, sptSet, V);
			sptSet.add(u);
			for (int v = 0; v < V; v++) {
				if (!sptSet.contains(v) && graph[u][v] > 0
						&& distances[u] + graph[u][v] < distances[v]) {
					distances[v] = distances[u] + graph[u][v];
				}
			}

		}
		printSolution(distances, V);
	}

	private static int findMinimum(int[] distances, HashSet<Integer> sptSet, int V) {
		int small = Integer.MAX_VALUE, pos = 0;
		for (int i = 0; i < V; i++) {
			if (!sptSet.contains(i)) {
				if (distances[i] < small) {
					small = distances[i];
					pos = i;
				}
			}
		}
		return pos;
	}

	private static void printSolution(int[] dist, int V) {
		System.out.println("Vertex \t\t Distance from Source");
		for (int i = 0; i < V; i++)
			System.out.println(i + " \t\t " + dist[i]);
	}
}
