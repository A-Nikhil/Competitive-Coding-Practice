/*
Count nodes within K-distance from all nodes in a set
Given an undirected tree with some marked nodes and a positive number K.
We need to print the count of all such nodes which have distance from all marked nodes less than K
that means every node whose distance from all marked nodes is less than K, should be counted in the result.

https://www.geeksforgeeks.org/count-nodes-within-k-distance-from-all-nodes-in-a-set/
 */

package DataStructures.Graphs.Traversals;

import Commons.GraphMatrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NodesAtKDistance {
	private static int[] dl, dr;

	public static void main(String[] args) {
		GraphMatrix graphMatrix = new GraphMatrix(10, false, true);
		int[][] edges =
				{
						{1, 0}, {0, 3}, {0, 8}, {2, 3},
						{3, 5}, {3, 6}, {3, 7}, {4, 5},
						{5, 9}
				};
		for (int[] temp : edges) {
			graphMatrix.addEdge(temp[0], temp[1]);
		}
		int[][] graph = graphMatrix.getGraph();
		int[] marked = {1, 2, 4};
		int K = 3;
		int V = 10;
		System.out.println(countNumberOfNodes(graph, V, marked, K));
	}

	private static int countNumberOfNodes(int[][] graph, int V, int[] nodeList, int K) {
		dl = new int[V];
		dr = new int[V];
		Arrays.fill(dl, -1);
		Arrays.fill(dr, -1);
		boolean[] marked = new boolean[V];
		for (int node : nodeList) {
			marked[node] = true;
		}
		int u = BFSWithDistance(graph, V, 0, true, marked);
		int v = BFSWithDistance(graph, V, u, true, marked);
		BFSWithDistance(graph, V, v, false, marked);
		int result = 0;
		for (int i = 0; i < V; i++) {
			if (dl[i] <= K && dr[i] <= K) {
				result++;
			}
		}
		return result;
	}

	private static int BFSWithDistance(int[][] graph, int V,
									   int node, boolean firstNode, boolean[] marked) {
		int lastMarked = 0;
		int[] distance = new int[V];
		Arrays.fill(distance, -1);
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		distance[node] = 0;
		while (!queue.isEmpty()) {
			node = queue.poll();
			if (marked[node]) {
				lastMarked = node;
			}
			for (int i = 0; i < V; i++) {
				if (graph[node][i] == 1 && distance[i] == -1) {
					distance[i] = distance[node] + 1;
					queue.add(i);
				}
			}
		}
		if (firstNode) {
			dl = distance.clone();
		} else {
			dr = distance.clone();
		}
		return lastMarked;
	}
}
