/*
Utility class to return an adjacency matrix from given connections
 */

package graphs;

class GraphMatrix {
	private final int[][] graph;
	private final boolean isDirected;

	GraphMatrix(int V, boolean isDirected) {
		graph = new int[V][V];
		this.isDirected = isDirected;
	}

	void addEdge(int source, int destination, boolean zeroIndexing) {
		if (!zeroIndexing) {
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
