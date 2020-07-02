package DataStructures.Graphs.Cycles;

public class CyclesInDigraph {
	private static boolean cyclic(int[][] graph, int v, boolean[] recursion,
								  boolean[] visited, int V) {

		// Present in the recursion stack => Cycle exists
		if (recursion[v])
			return true;

		// If not present in recursive stack, but visited => skip it
		if (visited[v])
			return false;

		// Mark in recursive stack that the current node is under recursion
		recursion[v] = true;
		visited[v] = true;
		for (int i = 0; i < V; i++) {
			if (graph[v][i] == 1 && !visited[i]) {
				if (cyclic(graph, i, recursion, visited, V)) {
					return true;
				}
			}
		}
		recursion[v] = false;
		return false;
	}

	private static boolean detectCycle(int[][] graph, int V) {
		boolean[] visited = new boolean[V];
		boolean[] recursion = new boolean[V];
		for (int v = 0; v < V; v++) {
			if (cyclic(graph, v, recursion, visited, V)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
//		int[][] graph = {
//				{0, 1, 1, 0},
//				{0, 0, 0, 0},
//				{0, 0, 0, 1},
//				{0, 0, 0, 0}
//		};
//		int V = 4;

		int[][] graph = {
				{0, 1},
				{1, 0}
		};
		int V = 2;
		System.out.println(detectCycle(graph, V));
	}
}
