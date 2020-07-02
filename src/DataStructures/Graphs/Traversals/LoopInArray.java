/*
Check loop in array according to given constraints
Given an array arr[0..n-1] of positive and negative numbers we need to find if there is
a cycle in array with given rules of movements. If a number at an i index is positive,
then move arr[i]%n forward steps, i.e., next index to visit is (i + arr[i])%n.
Conversely, if it’s negative, move backward arr[i]%n steps i.e., next index to visit is (i – arr[i])%n.
Here n is size of array. If value of arr[i]%n is zero, then it means no move from index i.

https://www.geeksforgeeks.org/check-loop-array-according-given-constraints/
 */
package DataStructures.Graphs.Traversals;

public class LoopInArray {
	public static void main(String[] args) {
		int[] arr = {1, 1, 1, 1, 1};
		int n = arr.length;
		System.out.println(checkForLoops(arr, n));
	}

	private static boolean checkForLoops(int[] arr, int n) {
		boolean[] visited = new boolean[n];
		boolean[] recursive = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (LoopRecursive(arr, n, i, visited, recursive)) {
				return true;
			}
		}
		return false;
	}

	private static boolean LoopRecursive(int[] arr, int n, int current,
										 boolean[] visited, boolean[] recursive) {
		visited[current] = true;
		recursive[current] = true;
		int next;
		if (arr[current] < 0) {
			next = ((current + arr[current]) % n);
		} else {
			next = ((current + arr[current] + n) % n);
		}
		if (next == current) {
			return false;
		}
		if (recursive[next]) {
			return true;
		}
		if (!visited[next]) {
			if (LoopRecursive(arr, n, next, visited, recursive)) {
				return true;
			}
		} else if (visited[next] && recursive[next]) {
			return true;
		}
		recursive[current] = false;
		return false;
	}
}
