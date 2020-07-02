/*
Finding the mother vertex of a graph. A mother vertex is such that starting a graph traversal with that vertex, one
can visit all the vertices of the graph.
The following approach does the following by performing a DFS and noting the last visited vertex. Then another DFS is
performed and checked whether all vertices are visited or not.
 */

package DataStructures.Graphs.Connectivity;

import java.util.Arrays;

public class MotherVertex {
	public static void main(String[] args) {
		int[][] graph = {
				{0, 1, 1, 0, 0, 0, 0},
				{0, 0, 0, 1, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 0, 0, 0},
				{0, 0, 1, 0, 0, 0, 1},
				{1, 0, 0, 0, 1, 0, 0},
		};
		int V = 7;
		System.out.println(new MotherVertex().findMother(graph, V));
	}

	private void DFS(int[][] graph, int v, boolean[] visited, int V) {
		visited[v] = true;
		for (int x = 0; x < V; x++) {
			if (graph[v][x] == 1 && !visited[x]) {
				DFS(graph, x, visited, V);
			}
		}
	}

	private int findMother(int[][] graph, int V) {
		int v = 0;
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				DFS(graph, i, visited, V);
				v = i;
			}
		}
		Arrays.fill(visited, false);
		DFS(graph, v, visited, V);
		for (boolean b : visited) {
			if (!b) {
				return -1;
			}
		}
		return v;
	}
}
