package DataStructures.Graphs.SpanningTrees;

import java.util.Arrays;

public class Kruskal {
	private static int Find(subset[] subsets, int i) {
		if (subsets[i].parent != i)
			subsets[i].parent = Find(subsets, subsets[i].parent);

		return subsets[i].parent;
	}

	private static void Union(subset[] subsets, int x, int y) {
		int xRoot = Find(subsets, x);
		int yRoot = Find(subsets, y);

		// Attach smaller rank tree under root of high rank tree
		// (Union by Rank)
		if (subsets[xRoot].rank < subsets[yRoot].rank)
			subsets[xRoot].parent = yRoot;
		else if (subsets[xRoot].rank > subsets[yRoot].rank)
			subsets[yRoot].parent = xRoot;

			// If ranks are same, then make one as root and increment
			// its rank by one
		else {
			subsets[yRoot].parent = xRoot;
			subsets[xRoot].rank++;
		}
	}

	private static void KruskalMST(Graph graph, int V) {
		Edge[] result = new Edge[V];
		int e = 0, i = 0;
		Arrays.fill(result, new Edge());
		Edge[] edge = graph.edge;
		Arrays.sort(edge);
		subset[] subsets = new subset[V];
		for (int v = 0; v < V; v++) {
			subsets[v] = new subset();
			subsets[v].parent = v;
			subsets[v].rank = 0;
		}

		while (e < V - 1) {
			// Step 2: Pick the smallest edge. And increment
			// the index for next iteration
			Edge next_edge = edge[i++];

			int x = Find(subsets, next_edge.source);
			int y = Find(subsets, next_edge.dest);

			// If including this edge does't cause cycle,
			// include it in result and increment the index
			// of result for next edge
			if (x != y) {
				result[e++] = next_edge;
				Union(subsets, x, y);
			}
			// Else discard the next_edge
		}

		// print the contents of result[] to display
		// the built MST
		System.out.println("Following are the edges in " +
				"the constructed MST");
		for (i = 0; i < e; ++i)
			System.out.println(result[i].source + " -- " +
					result[i].dest + " == " + result[i].weight);
	}

	public static void main(String[] args) {
		int V = 4;  // Number of vertices in graph
		int E = 5;  // Number of edges in graph
		Graph graph = new Graph(V, E);

		// add edge 0-1
		graph.edge[0].source = 0;
		graph.edge[0].dest = 1;
		graph.edge[0].weight = 10;

		// add edge 0-2
		graph.edge[1].source = 0;
		graph.edge[1].dest = 2;
		graph.edge[1].weight = 6;

		// add edge 0-3
		graph.edge[2].source = 0;
		graph.edge[2].dest = 3;
		graph.edge[2].weight = 5;

		// add edge 1-3
		graph.edge[3].source = 1;
		graph.edge[3].dest = 3;
		graph.edge[3].weight = 15;

		// add edge 2-3
		graph.edge[4].source = 2;
		graph.edge[4].dest = 3;
		graph.edge[4].weight = 4;

		KruskalMST(graph, V);
	}

	static class Edge implements Comparable<Edge> {
		int source, dest, weight;

		public int compareTo(Edge compareEdge) {
			return this.weight - compareEdge.weight;
		}
	}

	static class subset {
		int parent, rank;
	}

	static class Graph {
		int V, E;
		Edge[] edge;

		public Graph(int v, int e) {
			V = v;
			E = e;
			edge = new Edge[E];
			for (int i = 0; i < e; ++i)
				edge[i] = new Edge();
		}
	}
}
