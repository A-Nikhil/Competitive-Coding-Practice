package DataStructures.Graphs.Connectivity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumSetOfVertices {
	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
		List<Integer>[] graph = new ArrayList[n];
		for (List<Integer> edge : edges) {
			if (graph[edge.get(0)] == null) {
				graph[edge.get(0)] = new ArrayList<>();
			}
			graph[edge.get(0)].add(edge.get(1));
		}
		boolean[] visited = new boolean[n];
		Queue<Integer> q;
		int count;
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			q = new LinkedList<>();
			q.add(i);
			count = 0;
			while (!q.isEmpty()) {
				int temp = q.poll();
				if (graph[temp].size() == 0) {
					result.add(temp);
					break;
				}
				for (int x : graph[temp]) {
					if (!visited[x]) {
						visited[x] = true;
						q.add(x);
						count++;
					}
				}
			}
			if (count != 0) {
				result.add(i);
			}
		}
		return result;
	}
}
