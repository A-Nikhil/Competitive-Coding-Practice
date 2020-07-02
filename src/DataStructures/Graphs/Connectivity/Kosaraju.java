/*
Strongly Connected Components
A directed graph is strongly connected if there is a path between all pairs of vertices.
A strongly connected component (SCC) of a directed graph is a maximal strongly connected subgraph.

We can find all strongly connected components in O(V+E) time using Kosaraju’s algorithm.
Following is detailed Kosaraju’s algorithm.
	1) Create an empty stack ‘S’ and do DFS traversal of a graph.
		In DFS traversal, after calling recursive DFS for adjacent vertices of a vertex,
		push the vertex to stack. In the above graph, if we start DFS from vertex 0,
		we get vertices in stack as 1, 2, 4, 3, 0.
	2) Reverse directions of all arcs to obtain the transpose graph.
	3) One by one pop a vertex from S while S is not empty.
		Let the popped vertex be ‘v’. Take v as source and do DFS (call DFSUtil(v)).
		The DFS starting from v prints strongly connected component of v.
		In the above example, we process vertices in order 0, 3, 4, 2, 1 (One by one popped from stack).
 */
package DataStructures.Graphs.Connectivity;

import Commons.GraphMatrix;

import java.util.Stack;

public class Kosaraju {
	private static int[][] graphTranspose(int[][] graph, int V) {
		int[][] transpose = new int[V][V];
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				transpose[i][j] = graph[j][i];
			}
		}
		return transpose;
	}

	private static void DFSUtil(int[][] graph, int V, int node, boolean fillOrder,
								boolean[] visited, Stack<Integer> stack) {
		visited[node] = true;
		if (!fillOrder) {
			System.out.print(node + ", ");
		}
		for (int v = 0; v < V; v++) {
			if (graph[node][v] == 1 && !visited[v]) {
				DFSUtil(graph, V, v, fillOrder, visited, stack);
			}
		}
		if (fillOrder) {
			stack.push(node);
		}
	}

	private static void showSCC(int[][] graph, int V) {
		boolean[] visited = new boolean[V];
		Stack<Integer> stack = new Stack<>();
		for (int v = 0; v < V; v++) {
			if (!visited[v]) {
				DFSUtil(graph, V, v, true, visited, stack);
			}
		}
		graph = graphTranspose(graph, V);
		visited = new boolean[V];
		while (!stack.isEmpty()) {
			int node = stack.pop();
			if (!visited[node]) {
				DFSUtil(graph, V, node, false, visited, stack);
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		int V = 5;
		GraphMatrix g = new GraphMatrix(V, true, true);
		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(0, 3);
		g.addEdge(3, 4);
		showSCC(g.getGraph(), V);
	}
}
