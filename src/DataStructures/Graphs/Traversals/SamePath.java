/*
Given a tree and 2 vertices, this program finds out if both the vertices lie on the same path of the tree
 */

package DataStructures.Graphs.Traversals;

public class SamePath {
	private final int[] inTime;
	private final int[] outTime;
	private final int V;
	private int timer;

	SamePath(int V) {
		this.V = V;
		inTime = new int[V];
		outTime = new int[V];
		timer = 0;
	}

	public static void main(String[] args) {
		SamePath samePath = new SamePath(7);
		int[][] graph = {
				{0, 1, 1, 1, 0, 0, 0},
				{0, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 1, 0},
				{0, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
		};
		boolean[] visited = new boolean[7];
		samePath.DFSUtil(graph, 0, visited);
		System.out.println(samePath.query(1, 5));
		System.out.println(samePath.query(1, 6));
		System.out.println(samePath.query(2, 6));
	}

	private void DFSUtil(int[][] graph, int v, boolean[] visited) {
		++timer;
		visited[v] = true;
		inTime[v] = timer;
		for (int x = 0; x < V; x++) {
			if (graph[v][x] == 1 && !visited[x]) {
				DFSUtil(graph, x, visited);
			}
		}
		++timer;
		outTime[v] = timer;
	}

	private boolean query(int v, int u) {
		v--;
		u--;
		return (((inTime[v] < inTime[u]) && (outTime[v] > outTime[u]))
				|| ((inTime[u] < inTime[v]) && (outTime[u] > outTime[v])));
	}

}
