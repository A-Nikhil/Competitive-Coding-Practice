/*
Query for ancestor-descendant relationship in a tree

Given a rooted tree with N vertices and N-1 edges.
We will be given many pairs of vertices u and v, we need to tell whether u is an
ancestor of v or not. Given tree will be rooted at the vertex with index 0.

We can solve this problem using depth first search of the tree.
While doing dfs we can observe a relation between the order in which we visit a node
and its ancestors. If we assign in-time and out-time to each node when entering and leaving
that node in dfs then we can see that for each pair of ancestor-descendant the in-time of ancestor
is less than that of descendant and out-time of ancestor is more than that of descendant,
so using this relation we can find the result for each pair of node in O(1) time.
So time complexity for preprocessing will be O(N) and for the query it will be O(1).

https://www.geeksforgeeks.org/query-ancestor-descendant-relationship-tree/
 */

package DataStructures.BinaryTree.LowestCommonAncestor;

import Commons.GraphMatrix;

public class AncestorDescendantQuery {
	private static int[] timeOut, timeIn;
	private static int counter;

	private static void dfsWithTime(int[][] tree, int V, int u, int parent) {
		timeIn[u] = counter++;
		for (int v = 0; v < V; v++) {
			if (tree[u][v] == 1) {
				if (v != parent) {
					dfsWithTime(tree, V, v, u);
				}
			}
		}
		timeOut[u] = counter;
	}

	private static boolean isAncestor(int[][] tree, int V, int u, int v) {
		timeOut = timeIn = new int[V];
		dfsWithTime(tree, V, u, v);
		return ((timeIn[u] <= timeIn[v]) && (timeOut[v] <= timeOut[u]));
	}

	public static void main(String[] args) {
		int[][] edges = {
				{0, 1},
				{0, 2},
				{1, 3},
				{1, 4},
				{2, 5},
				{4, 6},
				{5, 7}
		};
		int V = 8;
		GraphMatrix graphMatrix = new GraphMatrix(V, false, true);
		for (int[] arr : edges) {
			graphMatrix.addEdge(arr[0], arr[1]);
		}
		int[][] tree = graphMatrix.getGraph();
		System.out.println(isAncestor(tree, V, 1, 6));
		System.out.println(isAncestor(tree, V, 1, 7));
	}
}
