package DataStructures.Graphs.Traversals;

import Commons.GraphMatrix;

public class DetectCycleInGraph {
	private static boolean cycleUtil(int[][] graph, int V, int node,
									 int parent, boolean[] visited) {
		visited[node] = true;
		for (int v = 0; v < V; v++) {
			if (graph[node][v] == 1) {
				if (!visited[v]) {
					if (cycleUtil(graph, V, v, node, visited)) {
						return true;
					}
				} else if (v != parent) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isCyclic(int[][] graph, int V) {
		boolean[] visited = new boolean[V];
		for (int v = 0; v < V; v++) {
			if (!visited[v]) {
				if (cycleUtil(graph, V, v, -1, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		GraphMatrix g1 = new GraphMatrix(5, false, true);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 1);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);

		GraphMatrix g2 = new GraphMatrix(3, false, true);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);

		System.out.println(isCyclic(g1.getGraph(), 5));
		System.out.println(isCyclic(g2.getGraph(), 3));
	}
}
