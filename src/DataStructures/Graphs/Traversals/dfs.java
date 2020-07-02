package DataStructures.Graphs.Traversals;

import java.util.Arrays;

public class dfs {
	private static void DFSUtil(int[][] graph, int v, int V, boolean[] visited) {
		visited[v] = true;
		System.out.print((v + 1) + " ");
		for (int x = 0; x < V; x++) {
			if (graph[v][x] == 1 && !visited[x]) {
				DFSUtil(graph, x, V, visited);
			}
		}
	}

	public static void main(String[] args) {
		int[][] graph = {
				{0, 1, 1, 0, 0, 0},
				{1, 0, 0, 1, 1, 0},
				{1, 0, 0, 0, 1, 0},
				{0, 1, 0, 0, 1, 1},
				{0, 1, 1, 1, 0, 1},
				{0, 0, 0, 1, 1, 0}
		};
		boolean[] visited = new boolean[6];
		Arrays.fill(visited, false);
		DFSUtil(graph, 0, 6, visited);
	}
}
