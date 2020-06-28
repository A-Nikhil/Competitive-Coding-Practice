/*
Utility class to return an adjacency matrix from given connections
 */

package Commons;

public class GraphMatrix {
	private final int[][] graph;
	private final boolean isDirected;
	private final boolean isZeroIndexed;

	public GraphMatrix(int V, boolean isDirected, boolean isZeroIndexed) {
		graph = new int[V][V];
		this.isDirected = isDirected;
		this.isZeroIndexed = isZeroIndexed;
	}

	public void addEdge(int source, int destination) {
		if (!isZeroIndexed) {
			source--;
			destination--;
		}
		this.graph[source][destination] = 1;
		if (!isDirected) {
			this.graph[destination][source] = 1;
		}
	}

	public void addEdge(int source, int destination, int weight) {
		if (!isZeroIndexed) {
			source--;
			destination--;
		}
		this.graph[source][destination] = weight;
		if (!isDirected) {
			this.graph[destination][source] = weight;
		}
	}

	public int[][] getGraph() {
		return this.graph;
	}

	public void printGraphMatrix(int[][] graph) {
		for (int i = 0; i < graph[0].length; i++) {
			System.out.print(i + " => ");
			for (int j = 0; j < graph[0].length; j++) {
				System.out.print(graph[i][j] + ", ");
			}
			System.out.println();
		}
	}
}
