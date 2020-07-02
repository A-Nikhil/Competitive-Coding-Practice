/*
https://www.geeksforgeeks.org/find-k-cores-graph/
 */
package DataStructures.Graphs.Connectivity;

import java.util.Arrays;

public class KCores {
	public static void main(String[] args) {
		int[][] graph = {
				{0, 1, 1, 0, 0, 0, 0, 0, 0}, // 0
				{1, 0, 1, 0, 0, 1, 0, 0, 0}, // 1
				{1, 1, 0, 1, 1, 1, 1, 0, 0}, // 2
				{0, 0, 1, 0, 1, 0, 1, 1, 0},
				{0, 0, 1, 1, 0, 0, 1, 1, 0},
				{0, 1, 1, 0, 0, 0, 1, 0, 1},
				{0, 0, 1, 1, 1, 1, 0, 1, 1},
				{0, 0, 0, 1, 1, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 1, 1, 0, 0},
		};
		int V = 9;
		int K = 3;
		kCores(graph, V, K);
	}

	private static void kCores(int[][] graph, int V, int K) {
		int[] degree = new int[V];
		Arrays.fill(degree, 0);
		for (int i = 0; i < V; i++) {
			for (int j : graph[i]) {
				if (j == 1) {
					degree[i]++;
				}
			}
		}

		boolean[] visited = new boolean[V];

		for (int v = 0; v < V; v++) {
			if (!visited[v]) {
				DFSUtil(graph, degree, v, visited, K, V);
			}
		}

		for (int v = 0; v < V; v++) {
			if (degree[v] >= K) {
				System.out.print("\n" + v + " => ");
				for (int x = 0; x < V; x++) {
					if (graph[v][x] == 1 && degree[x] >= K) {
						System.out.print(x + ", ");
					}
				}
			}
		}
	}

	private static boolean DFSUtil(int[][] graph, int[] degree, int v,
								   boolean[] visited, int K, int V) {
		visited[v] = true;
		for (int x = 0; x < V; x++) {
			if (graph[v][x] == 1) {
				if (degree[v] < K) {
					degree[x]--;
				}
				if (!visited[x]) {
					if (DFSUtil(graph, degree, x, visited, K, V)) {
						degree[v]--;
					}
				}
			}
		}
		return degree[v] < K;
	}
}
