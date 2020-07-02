/*
Check whether the given graph is a Tree or not

An undirected graph is tree if it has following properties.
1) There is no cycle.
2) The graph is connected.

How to detect cycle in an undirected graph?
We can either use BFS or DFS. For every visited vertex ‘v’, if there is an adjacent ‘u’
such that u is already visited and u is not parent of v, then there is a cycle in graph.
If we don’t find such an adjacent for any vertex, we say that there is no cycle

How to check for connectivity?
Since the graph is undirected, we can start BFS or DFS from any vertex and check
if all vertices are reachable or not. If all vertices are reachable, then graph is connected,
otherwise not.

https://www.geeksforgeeks.org/check-given-graph-tree/
 */

package DataStructures.BinaryTree.CheckingAndPrinting;

import Commons.GraphMatrix;

public class GraphIsATree {
	private static boolean checkCycle(int[][] graph, int V, int node, int parent, boolean[] visited) {
		visited[node] = true;

		for (int v = 0; v < V; v++) {
			if (graph[node][v] == 1) {
				if (!visited[v]) {
					if (checkCycle(graph, V, v, node, visited)) {
						return true;
					}
				} else if (v != parent) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isTree(int[][] graph, int V) {
		boolean[] visited = new boolean[V];
		if (checkCycle(graph, V, 0, -1, visited)) {
			return false;
		}
		for (int v = 0; v < V; v++) {
			if (!visited[v]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		GraphMatrix g1 = new GraphMatrix(5, false, true);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);

		GraphMatrix g2 = new GraphMatrix(5, false, true);
		g2.addEdge(1, 0);
		g2.addEdge(0, 2);
		g2.addEdge(2, 1);
		g2.addEdge(0, 3);
		g2.addEdge(3, 4);

		System.out.println(isTree(g1.getGraph(), g1.getGraph().length));
		System.out.println(isTree(g2.getGraph(), g2.getGraph().length));
	}
}
