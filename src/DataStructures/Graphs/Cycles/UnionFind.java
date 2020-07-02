package DataStructures.Graphs.Cycles;

import java.util.Arrays;

public class UnionFind {
	private static int Find(int[] parent, int i) {
		if (parent[i] == -1)
			return i;
		else
			return Find(parent, parent[i]);
	}

	private static void Union(int[] parent, int x, int y) {
		int xSet = Find(parent, x);
		int ySet = Find(parent, y);
		parent[xSet] = ySet;
	}

	private static boolean isCycle(Graph graph) {
		int[] parent = new int[graph.V];
		Arrays.fill(parent, -1);
		for (int i = 0; i < graph.E; i++) {
			int x = Find(parent, graph.edges[i].source);
			int y = Find(parent, graph.edges[i].destination);
			if (x == y)
				return true;
			Union(parent, x, y);
		}
		return false;
	}

	public static void main(String[] args) {
		int V = 3, E = 3;
		Graph graph = new Graph(V, E);

		// add edge 0-1
		graph.edges[0].source = 0;
		graph.edges[0].destination = 1;

		// add edge 1-2
		graph.edges[1].source = 1;
		graph.edges[1].destination = 2;

		// add edge 0-2
		graph.edges[2].source = 0;
		graph.edges[2].destination = 2;

		if (isCycle(graph))
			System.out.println("graph contains cycle");
		else
			System.out.println("graph doesn't contain cycle");
	}

	private static class Graph {
		int V, E;
		Edge[] edges;

		public Graph(int v, int e) {
			V = v;
			E = e;
			edges = new Edge[E];
			for (int i = 0; i < e; i++)
				edges[i] = new Edge();
		}
	}

	private static class Edge {
		int source;
		int destination;
	}
}
