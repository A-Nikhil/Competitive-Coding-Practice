/*
Check if the given array can represent Level Order Traversal of Binary Search Tree

Given an array of size n.
The problem is to check whether the given array can represent the level order traversal
of a Binary Search Tree or not.

Examples:

Input : arr[] = {7, 4, 12, 3, 6, 8, 1, 5, 10}
Output : Yes
For the given arr[] the Binary Search Tree is:
         7
       /    \
      4     12
     / \    /
    3   6  8
   /   /    \
  1   5     10

Input : arr[] = {11, 6, 13, 5, 12, 10}
Output : No
The given arr[] do not represent the level
order traversal of a BST.

Approach =>
The idea is to use a queue data structure.
Every element of queue has a structure say NodeDetails which stores details of a tree node.
The details are node’s data, and two variables min and max where min stores the lower limit
for the node values which can be a part of the left subtree and max stores the upper limit
for the node values which can be a part of the right subtree for the specified node in
NodeDetails structure variable. For the 1st array value arr[0], create a NodeDetails
structure having arr[0] as node’s data and min = INT_MIN and max = INT_MAX.
Add this structure variable to the queue. This Node will be the root of the tree.

Move to 2nd element in arr[] and then perform the following steps:
	Pop NodeDetails from the queue in temp.
	Check whether the current array element can be a left child of the node in temp
		with the help of min and temp.data values. If it can, then create a new
		NodeDetails structure for this new array element value with its proper ‘min’ and ‘max’
		values and push it to the queue, and move to next element in arr[].
	Check whether the current array element can be a right child of the node in temp with
		the help of max and temp.data values. If it can, then create a new NodeDetails
		structure for this new array element value with its proper ‘min’ and ‘max’
		values and push it to the queue, and move to next element in arr[].
	Repeat steps 1, 2 and 3 until there are no more elements in arr[] or there are
		no more elements in the queue.

https://www.geeksforgeeks.org/check-given-array-can-represent-level-order-traversal-binary-search-tree/
 */

package DataStructures.BinarySearchTree.CheckingAndPrinting;

import java.util.LinkedList;
import java.util.Queue;

public class ArrayLevelOrderTraversal {
	public static void main(String[] args) {
		int[] arr = {7, 4, 12, 3, 6, 8, 1, 5, 10};
		System.out.println(checkRepresentation(arr, arr.length));
		int[] arr2 = {11, 6, 13, 5, 12, 10};
		System.out.println(checkRepresentation(arr2, arr2.length));
	}

	private static boolean checkRepresentation(int[] arr, int V) {
		Queue<NodeDetails> queue = new LinkedList<>();
		queue.add(new NodeDetails(arr[0], -99999, 99999));
		NodeDetails current;
		int index = 1;
		while (!queue.isEmpty() && (index < V)) {
			current = queue.poll();
			if (arr[index] < current.data && arr[index] > current.min) {
				queue.add(new NodeDetails(arr[index], current.min, current.data));
				index++;
			}

			if (arr[index] > current.data && arr[index] < current.max) {
				queue.add(new NodeDetails(arr[index], current.data, current.max));
				index++;
			}
		}

		return index == V;
	}

	static class NodeDetails {
		int data, min, max;

		public NodeDetails(int data, int min, int max) {
			this.data = data;
			this.min = min;
			this.max = max;
		}
	}
}
