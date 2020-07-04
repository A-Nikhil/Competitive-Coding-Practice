/*
Maximum Unique Element in every subarray of size K
Given an array and an integer K.
We need to find the maximum of every segment of length K which has no duplicates in that segment.

Examples:

Input : a[] = {1, 2, 2, 3, 3},
          K = 3.
Output : 1 3 2
For segment (1, 2, 2), Maximum = 1.
For segment (2, 2, 3), Maximum = 3.
For segment (2, 3, 3), Maximum = 2.

Input : a[] = {3, 3, 3, 4, 4, 2},
          K = 4.
Output : 4 Nothing 3

An efficient solution is to use sliding window technique. We maintain two structures in every window.
1) A hash table to store counts of all elements in current window.
2) A self balancing BST (implemented using set in C++ STL and TreeSet in Java).
The idea is to quickly find maximum element and update maximum element.

We process first K-1 elements and store their counts in hash table.
We also store unique elements in set. Now we one by one process last element of every window.
If current element is unique, we add it to set. We also increase its count.
After processing last element, we print maximum from set. Before starting next iteration,
we remove first element of previous window.

https://www.geeksforgeeks.org/maximum-unique-element-every-subarray-size-k/
 */

package DataStructures.BinarySearchTree.CheckingAndPrinting;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class UniqueNumberInSubSequence {
	public static void main(String[] args) {
		int[] a = {3, 3, 3, 4, 4, 2},
				b = {1, 2, 2, 3, 3};
		int Ka = 4,
				Kb = 3;
		findMaxUnique(a, a.length, Ka);
		System.out.println();
		findMaxUnique(b, b.length, Kb);
	}

	private static void findMaxUnique(int[] arr, int n, int k) {
		TreeSet<Integer> set = new TreeSet<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < k - 1; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				set.add(entry.getKey());
			}
		}

		for (int i = k - 1; i < n; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}

			if (map.get(arr[i]) == 1) {
				set.add(arr[i]);
			} else {
				set.remove(arr[i]);
			}

			// Set is empty => No element is unique
			if (set.size() == 0) {
				System.out.print("Nothing ");
			} else {
				System.out.print(set.last() + " ");
			}

			// Remove first element of current
			// window before next iteration.
			int x = arr[i - k + 1];
			map.put(x, map.get(x) - 1);
			if (map.get(x) == 1) {
				set.add(x);
			} else {
				set.remove(x);
			}
		}
	}
}
