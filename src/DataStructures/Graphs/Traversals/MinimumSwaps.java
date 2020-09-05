/*
Minimum Swaps to sort an array

Given an array of integers. Find the minimum number of swaps required to sort the array in non-decreasing order.

Input:
The first line of input contains an integer T denoting the no of Others.test cases.
Then T Others.test cases follow. Each Others.test case contains an integer N denoting the no of element of the array A[ ].
In the next line are N space separated values of the array A[ ] .

Output:
For each Others.test case in a new line output will be an integer denoting minimum umber of swaps that are
required to sort the array.
 */

package DataStructures.Graphs.Traversals;

import Commons.GraphList;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumSwaps {
	public static void main(String[] args) {
//		int[] arr = {1, 5, 4, 3, 2};
		int[] arr = {4, 2, 3, 1};
		System.out.println(minimumSwaps(arr, arr.length));
	}

	private static int minimumSwaps(int[] arr, int n) {
		int[] temp = arr.clone();
		Arrays.sort(temp);
		GraphList graphList = new GraphList(n, true, false);
		for (int i = 0; i < n; i++) {
			if (arr[i] != temp[i]) {
				graphList.addEdge(arr[i], temp[i]);
			}
		}
		boolean[] visited = new boolean[n];
		ArrayList<Integer>[] graph = graphList.getGraph();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i] || temp[i] == arr[i]) {
				continue;
			}
			int cycle = 0;
			int j = i, v = 0;
			while (!visited[j]) {
				visited[j] = true;
				cycle++;
				if (v < graph[j].size()) {
					j = graph[j].get(v);
					v++;
				} else {
					break;
				}
			}
			if (cycle > 0) {
				ans += cycle - 1;
			}
		}
		return ans;
	}
}
