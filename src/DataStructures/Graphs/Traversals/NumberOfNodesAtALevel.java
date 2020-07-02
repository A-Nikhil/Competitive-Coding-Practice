package DataStructures.Graphs.Traversals;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfNodesAtALevel {
	public static void main(String[] args) {
		int[][] tree = {
				{0, 1, 1, 0, 0, 0, 0},
				{0, 0, 0, 1, 1, 1, 0},
				{0, 0, 0, 0, 0, 0, 1},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
		};
		int V = 7, start = 0;
		System.out.println("At level 0 => " + findNumber(tree, V, 0, start));
		System.out.println("At level 1 => " + findNumber(tree, V, 1, start));
		System.out.println("At level 2 => " + findNumber(tree, V, 2, start));
	}

	private static int findNumber(int[][] tree, int V, int level, int start) {
		int[] nodeLevel = new int[V];
		boolean[] visited = new boolean[V];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		nodeLevel[start] = 0;
		while (!queue.isEmpty()) {
			start = queue.poll();
			for (int i = 0; i < V; i++) {
				if (tree[start][i] == 1 && !visited[i]) {
					nodeLevel[i] = nodeLevel[start] + 1;
					visited[i] = true;
					queue.add(i);
				}
			}
		}
		int counter = 0;
		for (int i = 0; i < V; i++) {
			if (nodeLevel[i] == level) {
				counter++;
			}
		}
		return counter;
	}
}
