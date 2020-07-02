package DataStructures.Graphs.Traversals;

import java.util.ArrayList;
import java.util.Arrays;

public class bfs {
	public static void main(String[] args) {
		int[][] graph = {
				{0, 1, 1, 0, 0, 0},
				{1, 0, 0, 1, 1, 0},
				{1, 0, 0, 0, 1, 0},
				{0, 1, 0, 0, 1, 1},
				{0, 1, 1, 1, 0, 1},
				{0, 0, 0, 1, 1, 0}
		};
		BFS(graph, 6, 1);
	}

	private static void BFS(int[][] graph, int V, int start) {
		boolean[] visited = new boolean[V];
		Arrays.fill(visited, false);
		ArrayList<Integer> queue = new ArrayList<>();
		start = start - 1;
		queue.add(start);
		visited[start] = true;
		while (!queue.isEmpty()) {
			start = queue.get(0);
			System.out.print((start + 1) + " ");
			queue.remove(0);

			for (int v = 0; v < V; v++) {
				if ((graph[start][v] == 1) && !visited[v]) {
					queue.add(v);
					visited[v] = true;
				}
			}
		}
	}
}
