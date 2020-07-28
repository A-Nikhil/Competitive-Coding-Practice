package DataStructures.Graphs.TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unchecked")
public class KahnAlgorithm {
	public static void main(String[] args) {
		int V = 0;
		ArrayList<Integer>[] graph = new ArrayList[V];
		kahnTopologicalSort(graph, V);
	}

	private static void kahnTopologicalSort(ArrayList<Integer>[] graph, int V) {
		int[] indegree = new int[V];
		for (int i = 0; i < V; i++) {
			for (int j : graph[i]) {
				indegree[j]++;
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < V; i++) {
			if (indegree[i] == 0)
				queue.add(i);
		}

		int count = 0, u;
		ArrayList<Integer> top = new ArrayList<>();
		while (!queue.isEmpty()) {
			u = queue.poll();
			top.add(u);

			for (int j : graph[u]) {
				indegree[j]--;
				if (indegree[j] == 0)
					queue.add(j);
			}
			count++;
		}

		if (count != V) {
			System.out.println("Cycle Exists");
			return;
		}

		for (int i : top) {
			System.out.print(i + " ");
		}
	}
}
