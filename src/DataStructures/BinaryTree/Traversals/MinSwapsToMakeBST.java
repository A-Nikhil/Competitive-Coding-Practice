/*Minimum swap required to convert binary tree to binary search tree
Given the array representation of Complete Binary Tree i.e, if index i is the parent,
index 2*i + 1 is the left child and index 2*i + 2 is the right child.
The task is to find the minimum number of swap required to convert it into Binary Search Tree.

The idea is to use the fact that inorder traversal of Binary Search Tree is in increasing order of their value.
So, find the inorder traversal of the Binary Tree and store it in the array and try to sort the array.
The minimum number of swap required to get the array sorted will be the answer.
*/

package DataStructures.BinaryTree.Traversals;

import Commons.Node;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings({"Duplicates", "unchecked"})
public class MinSwapsToMakeBST {
	private static int[] inOrder;
	private static int index = 0;

	private static void inOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left);
		inOrder[index] = root.val;
		index++;
		inOrderTraversal(root.right);
	}

	private static int swapNumber(Node root, int V) {
		inOrder = new int[V];
		inOrderTraversal(root);
		int[] temp = inOrder.clone();
		Arrays.sort(temp);
		boolean[] visited = new boolean[V];
		ArrayList<Integer>[] graph = new ArrayList[V];
		Arrays.fill(graph, new ArrayList<>());
		for (int i = 0; i < V; i++) {
			if (temp[i] != inOrder[i]) {
				graph[temp[i]].add(inOrder[i]);
			}
		}
		int ans = 0;
		for (int i = 0; i < V; i++) {
			if (visited[i] || temp[i] == inOrder[i]) {
				continue;
			}
			int cycle = 0, j = i, v = 0;
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

	public static void main(String[] args) {
		Node root = new Node(25);
		int v = 1;
		System.out.println(swapNumber(root, v));
	}

}
