package Commons;

import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class GraphList {
	private final ArrayList<Integer>[] graph;
	private final boolean isDirected;
	private final boolean isZeroIndexed;

	public GraphList(int V, boolean isDirected, boolean isZeroIndexed) {
		this.graph = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			this.graph[i] = new ArrayList<>();
		}
		this.isDirected = isDirected;
		this.isZeroIndexed = isZeroIndexed;
	}

	public void addEdge(int source, int destination) {
		if (!isZeroIndexed) {
			source--;
			destination--;
		}
		this.graph[source].add(destination);
		if (!isDirected) {
			this.graph[destination].add(source);
		}
	}

	public ArrayList<Integer>[] getGraph() {
		return graph;
	}
}
