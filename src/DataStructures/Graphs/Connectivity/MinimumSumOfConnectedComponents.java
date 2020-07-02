/*
Sum of the minimum elements in all connected components of an undirected graph

Given an array A of N numbers where Ai represent the value of the (i+1)th node.
Also given are M pair of edges where u and v represent the nodes that are connected by an edge.
The task is to find the sum of the minimum element in all the connected components of the given undirected graph.
If a node has no connectivity to any other node, count it as a component with one node.

https://www.geeksforgeeks.org/sum-of-the-minimum-elements-in-all-connected-components-of-an-undirected-graph/
*/


package DataStructures.Graphs.Connectivity;

import Commons.GraphMatrix;

public class MinimumSumOfConnectedComponents {
	private static void DFS(int[][] graph, int V, int[] values,
							int node, int mini, boolean[] visited) {
		mini = Math.min(mini, values[node]);
		visited[node] = true;
		for (int i = 0; i < V; i++) {
			if (graph[node][i] == 1 && !visited[i]) {
				DFS(graph, V, values, i, mini, visited);
			}
		}
	}

	private static int getSum(int[][] graph, int V, int[] values) {
		boolean[] visited = new boolean[V];
		int sum = 0, mini;
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				mini = values[i];
				DFS(graph, V, values, i, mini, visited);
				sum += mini;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
//		int[] values = {1, 6, 2, 7, 3, 8, 4, 9, 5, 10};
//		GraphMatrix graphMatrix = new GraphMatrix(10, false);
//		graphMatrix.addEdge(1, 2, false);
//		graphMatrix.addEdge(3, 4, false);
//		graphMatrix.addEdge(5, 6, false);
//		graphMatrix.addEdge(7, 8, false);
//		graphMatrix.addEdge(9, 10, false);

		GraphMatrix graphMatrix = new GraphMatrix(10, false, false);
		int[] values = {2, 5, 3, 4, 8};
		graphMatrix.addEdge(1, 4);
		graphMatrix.addEdge(4, 5);
		System.out.println(getSum(graphMatrix.getGraph(), values.length, values));
	}
}
