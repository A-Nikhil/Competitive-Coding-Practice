/*
Utility class to return an adjacency matrix from given connections
 */

package graphs;

public class GraphMatrix {
	private final int[][] graph;
	private final boolean isDirected;

	GraphMatrix(int V, boolean isDirected) {
		graph = new int[V][V];
		this.isDirected = isDirected;
	}

	void addEdge(int source, int destination) {
		this.graph[source][destination] = 1;
		if (!isDirected) {
			this.graph[destination][source] = 1;
		}
	}

	int[][] getGraph() {
		return this.graph;
	}
}
