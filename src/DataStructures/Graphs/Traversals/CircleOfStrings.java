/*
Circle of Strings

Given an array of strings A[], determine if the strings can be chained together to form a circle. A
string X can be chained together with another string Y if the last character of X is same as first
character of Y. If every string of the array can be chained, it will form a circle.

For eg for the array arr[] = {"for", "geek", "rig", "kaf"}
the answer will be Yes as the given strings can be chained as "for", "rig", "geek" and "kaf"

https://www.geeksforgeeks.org/find-array-strings-can-chained-form-circle-set-2/
 */

package DataStructures.Graphs.Traversals;

import Commons.GraphList;

import java.util.ArrayList;

public class CircleOfStrings {
	private static boolean checkForLoops(String[] arr) {
		int V = 26;
		int[] inDegree = new int[V];
		int[] outDegree = new int[V];
		boolean[] mark = new boolean[26];
		GraphList graphList = new GraphList(V, true, true);
		for (String s : arr) {
			int f = s.charAt(0) - 'a';
			int l = s.charAt(s.length() - 1) - 'a';
			mark[f] = mark[l] = true;
			outDegree[f]++;
			inDegree[l]++;
			graphList.addEdge(f, l);
		}
		for (int i = 0; i < V; i++) {
			if (inDegree[i] != outDegree[i]) {
				return false;
			}
		}
		ArrayList<Integer>[] graph = graphList.getGraph();
		return isConnected(graph, V, mark,
				(arr[0].charAt(0) - 'a'));
	}

	private static boolean isConnected(ArrayList<Integer>[] graph, int V, boolean[] marked, int node) {
		boolean[] visited = new boolean[V];
		DFS(graph, visited, node);
		for (int i = 0; i < V; i++) {
			if (marked[i] && !visited[i])
				return false;
		}
		return true;
	}

	private static void DFS(ArrayList<Integer>[] graph, boolean[] visited, int node) {
		visited[node] = true;
		for (int i : graph[node]) {
			if (!visited[i])
				DFS(graph, visited, i);
		}
	}

	public static void main(String[] args) {
//		String[] arr = {"ab", "bc", "cd", "de", "ed", "da"};
//		String[] arr = {"aaa", "bbb"};
		String[] arr = {"ijk", "kji", "abc", "cba"};
		System.out.println(checkForLoops(arr));
	}

}
