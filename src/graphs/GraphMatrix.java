/*
Utility class to return an adjacency matrix from given connections
 */

package graphs;

class GraphMatrix {
	private final int[][] graph;
	private final boolean isDirected;
	private final boolean isZeroIndexed;

	GraphMatrix(int V, boolean isDirected, boolean isZeroIndexed) {
		graph = new int[V][V];
		this.isDirected = isDirected;
		this.isZeroIndexed = isZeroIndexed;
	}

	void addEdge(int source, int destination) {
		if (!isZeroIndexed) {
			source--;
			destination--;
		}
		this.graph[source][destination] = 1;
		if (!isDirected) {
			this.graph[destination][source] = 1;
		}
	}

	int[][] getGraph() {
		return this.graph;
	}

	void printGraphMatrix(int[][] graph) {
		for (int i = 0; i < graph[0].length; i++) {
			System.out.print(i + " => ");
			for (int j = 0; j < graph[0].length; j++) {
				System.out.print(graph[i][j] + ", ");
			}
			System.out.println();
		}
	}
}
