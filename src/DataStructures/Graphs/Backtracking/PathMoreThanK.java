package DataStructures.Graphs.Backtracking;

import Commons.GraphMatrix;

public class PathMoreThanK {
	private static boolean pathTraversal(int[][] graph, int V,
										 boolean[] path, int node, int K) {
		if (K <= 0) {
			return true;
		}

		for (int v = 0; v < V; v++) {
			if (graph[node][v] > 0) {
				if (path[v]) {
					continue;
				}
				if (graph[node][v] >= K) {
					return true;
				}
				path[v] = true;
				if (pathTraversal(graph, V, path, v, K - graph[node][v])) {
					return true;
				}
				path[v] = false;
			}
		}
		return false;
	}

	private static boolean pathMoreThanK(int[][] graph, int V, int source, int K) {
		boolean[] path = new boolean[V];
		path[source] = true;
		return pathTraversal(graph, V, path, source, K);
	}

	public static void main(String[] args) {
		int V = 9;
		GraphMatrix g = new GraphMatrix(V, false, true);
		g.addEdge(0, 1, 4);
		g.addEdge(0, 7, 8);
		g.addEdge(1, 2, 8);
		g.addEdge(1, 7, 11);
		g.addEdge(2, 3, 7);
		g.addEdge(2, 8, 2);
		g.addEdge(2, 5, 4);
		g.addEdge(3, 4, 9);
		g.addEdge(3, 5, 14);
		g.addEdge(4, 5, 10);
		g.addEdge(5, 6, 2);
		g.addEdge(6, 7, 1);
		g.addEdge(6, 8, 6);
		g.addEdge(7, 8, 7);
		int source = 0, K = 62;
		int[][] graph = g.getGraph();
		System.out.println(pathMoreThanK(graph, V, source, K));
		System.out.println(pathMoreThanK(graph, V, source, 60));
	}
}
