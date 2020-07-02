package DataStructures.Graphs.TopologicalSort;

import java.util.Arrays;
import java.util.Stack;

public class topologicalSort {
	private static int V;

	private static void TopologicalSortUtil(int[][] graph, int v, boolean[] visited, Stack<Integer> stack) {
		visited[v] = true;
		for (int x = 0; x < V; x++) {
			if (graph[v][x] == 1 && !visited[x]) {
				TopologicalSortUtil(graph, x, visited, stack);
			}
		}
		stack.push(v);
	}

	private static void TopologicalSortRunner(int[][] graph) {
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[V];
		Arrays.fill(visited, false);
		for (int v = 0; v < V; v++) {
			if (!visited[v]) {
				TopologicalSortUtil(graph, v, visited, stack);
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	public static void main(String[] args) {
		int[][] demoGraph = {
				{0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0},
				{0, 0, 0, 1, 0, 0},
				{0, 1, 0, 0, 0, 0},
				{1, 1, 0, 0, 0, 0},
				{1, 0, 1, 0, 0, 0}
		};
		V = 6;
		TopologicalSortRunner(demoGraph);
	}
}
