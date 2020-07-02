/*
Given a sorted dictionary (array of words) of an alien language, find order of characters in the language.

Examples =>
	Input:  words[] = {"baa", "abcd", "abca", "cab", "cad"}
	Output: Order of characters is 'b', 'd', 'a', 'c'
	Note that words are sorted and in the given language "baa"
	comes before "abcd", therefore 'b' is before 'a' in output.
	Similarly we can find other orders.

	Input:  words[] = {"caa", "aaa", "aab"}
	Output: Order of characters is 'c', 'a', 'b'

Approach =>
	1) Create a graph g with number of vertices equal to the size of alphabet in the given alien language.
		For example, if the alphabet size is 5, then there can be 5 characters in words.
		Initially there are no edges in graph.

	2) Do following for every pair of adjacent words in given sorted array.
	…..a) Let the current pair of words be word1 and word2. One by one compare characters of
			both words and find the first mismatching characters.
	…..b) Create an edge in g from mismatching character of word1 to that of word2.

	3) Print topological sorting of the above created graph.

https://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
 */
package DataStructures.Graphs.TopologicalSort;

import java.util.Stack;

@SuppressWarnings("Duplicates")
public class AlienDictionary {
	public static void main(String[] args) {
		String[] dictionary = {"baa", "abcd", "abca", "cab", "cad"};
		findOrder(dictionary);
	}

	private static void findOrder(String[] dictionary) {
		int V = Integer.MIN_VALUE;
		for (String s : dictionary) {
			V = Math.max(V, s.length());
		}
		int[][] graph = new int[V][V];
		String word1, word2;
		for (int i = 0; i < dictionary.length - 1; i++) {
			word1 = dictionary[i];
			word2 = dictionary[i + 1];
			for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
				if (word1.charAt(j) != word2.charAt(j)) {
					graph[word1.charAt(j) - 'a'][word2.charAt(j) - 'a'] = 1;
					break;
				}
			}
		}
		boolean[] visited = new boolean[V];
		Stack<Integer> stack = new Stack<>();
		for (int v = 0; v < V; v++) {
			if (!visited[v]) {
				TopologicalSort(graph, V, v, visited, stack);
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(((char) (stack.pop() + 97)) + ", ");
		}
	}

	private static void TopologicalSort(int[][] graph, int V, int node, boolean[] visited, Stack<Integer> stack) {
		visited[node] = true;
		for (int v = 0; v < V; v++) {
			if (graph[node][v] == 1 && !visited[v]) {
				TopologicalSort(graph, V, v, visited, stack);
			}
		}
		stack.push(node);
	}

}
