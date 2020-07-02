package DataStructures.Graphs.SpanningTrees;

public class FloydWarshall {
	private static final int INF = 9999;

	public static void main(String[] args) {
		int[][] graph = {
				{0, 5, INF, 10},
				{INF, 0, 3, INF},
				{INF, INF, 0, 1},
				{INF, INF, INF, 0}
		};
		floydWarshall(graph, graph.length);
	}

	private static void floydWarshall(int[][] graph, int V) {
		int[][] distance = graph.clone();
		for (int k = 0; k < V; k++) {
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					if (distance[i][k] + distance[k][j] < distance[i][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}
		printSolution(distance, V);
	}

	private static void printSolution(int[][] dist, int V) {
		System.out.println("The following matrix shows the shortest " +
				"distances between every pair of vertices");
		for (int i = 0; i < V; ++i) {
			for (int j = 0; j < V; ++j) {
				if (dist[i][j] == INF)
					System.out.print("INF ");
				else
					System.out.print(dist[i][j] + "   ");
			}
			System.out.println();
		}
	}
}
