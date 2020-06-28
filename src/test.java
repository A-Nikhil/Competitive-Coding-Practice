import java.util.Arrays;
import java.util.HashSet;

public class test {
	public static void main(String[] args) {
		int[][] arr = {
				{1, 2, 1},
				{1, 2, 1000},
				{2, 3, 3},
				{1, 3, 100},
		};
		beautifulPath(arr, 1, 3, 3);
	}

	static int beautifulPath(int[][] edges, int A, int B, int n) {
		int[][] graph = new int[n][n];
		for (int[] arr : edges) {
			int from = arr[0] - 1;
			int to = arr[0] - 1;
			graph[from][to] = graph[to][from] = arr[2];
		}

		return dijkstra(graph, n, A, B);
	}

	static int dijkstra(int[][] graph, int N, int A, int B) {
		HashSet<Integer> sptSet = new HashSet<>();
		int[] dist = new int[N];
		int[] parent = new int[N];
		Arrays.fill(parent, -1);
		Arrays.fill(dist, 9999);
		dist[A - 1] = 0;
		parent[A - 1] = -1;
		while (sptSet.size() != N) {
			int u = findMin(dist, sptSet, N);
			sptSet.add(u);
			for (int v = 0; v < N; v++) {
				if (!sptSet.contains(v) &&
						graph[u][v] > 0 &&
						(dist[u] | graph[u][v]) < dist[v]) {
					dist[v] = (dist[u] | graph[u][v]);
					parent[v] = u;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.println(dist[i]);
		}
		return 100;
		// int parentB = getParent(parent, B);
		// if (parentB == -1) {
		//     return dist[B-1];
		// } else {
		//     return -1;
		// }
	}

	private static int findMin(int[] dist, HashSet<Integer> sptSet, int n) {
		int small = 99999, pos = 0;
		for (int i = 0; i < n; i++) {
			if (!sptSet.contains(i)) {
				if (dist[i] < small) {
					small = dist[i];
					pos = i;
				}
			}
		}
		return pos;
	}

	private static int getParent(int[] parent, int B) {
		if (parent[B - 1] == -1) {
			return parent[B - 1];
		}
		return getParent(parent, parent[B - 1]);
	}

}
