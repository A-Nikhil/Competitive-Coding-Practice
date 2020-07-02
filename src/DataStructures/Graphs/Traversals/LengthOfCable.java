/*
NOTE : This is the same for LONGEST PATH IN DIRECTED ACYCLIC GRAPH

Longest path between any pair of vertices
We are given a map of cities connected with each other via cable lines such that
there is no cycle between any two cities.
We need to find the maximum length of cable between any two cities for given city map.

Input : n = 6
        1 2 3  // Cable length from 1 to 2 (or 2 to 1) is 3
        2 3 4
        2 6 2
        6 4 6
        6 5 5
Output: maximum length of cable = 12

https://www.geeksforgeeks.org/longest-path-between-any-pair-of-vertices/
 */
package DataStructures.Graphs.Traversals;

import Commons.GraphMatrix;

import java.util.Arrays;
import java.util.Stack;

public class LengthOfCable {
	private static void TopologicalSort(int[][] graph, int V, int node, boolean[] visited, Stack<Integer> stack) {
		visited[node] = true;
		for (int v = 0; v < V; v++) {
			if (graph[node][v] == 1 && !visited[v]) {
				TopologicalSort(graph, V, v, visited, stack);
			}
		}
		stack.push(node);
	}

	private static int findLength(int[][] graph, int V, int[][] weight) {
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[V];
		for (int v = 0; v < V; v++) {
			TopologicalSort(graph, V, v, visited, stack);
		}
		int[] distances = new int[V];
		Arrays.fill(distances, Integer.MIN_VALUE);
		int node;
		while (!stack.isEmpty()) {
			node = stack.pop();
			for (int v = 0; v < V; v++) {
				if (graph[node][v] == 1) {
					if (distances[node] < (distances[v] + weight[node][v])) {
						distances[node] = distances[v] + weight[node][v];
					}
				}
			}
		}
		Arrays.sort(distances);
		return distances[V - 1] - Integer.MIN_VALUE + 1;
	}

	public static void main(String[] args) {
		int[][] input = {
				{1, 2, 3},
				{2, 3, 4},
				{2, 6, 2},
				{6, 4, 6},
				{6, 5, 5}
		};
		int V = 6;
		GraphMatrix graphMatrix = new GraphMatrix(V, true, false);
		int[][] weights = new int[V][V];
		for (int[] arr : input) {
			graphMatrix.addEdge(arr[0], arr[1]);
			weights[arr[0] - 1][arr[1] - 1] = arr[2];
		}
		System.out.println(findLength(graphMatrix.getGraph(), V, weights));
	}
}
