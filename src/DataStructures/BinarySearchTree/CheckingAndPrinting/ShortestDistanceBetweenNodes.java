/*
Shortest distance between two nodes in BST
Given a Binary Search Tree and two keys in it.
Find the distance between two nodes with given two keys.
It may be assumed that both keys exist in BST.

In the case of BST, we can find the distance faster. We start from the root and for every node,
we do following.
	If both keys are greater than the current node, we move to the right child of the current node.
	If both keys are smaller than current node, we move to left child of current node.
	If one keys is smaller and other key is greater, current node is Lowest Common Ancestor (LCA)
		of two nodes. We find distances of current node from two keys and return sum of the distances.


https://www.geeksforgeeks.org/shortest-distance-between-two-nodes-in-bst/
 */

package DataStructures.BinarySearchTree.CheckingAndPrinting;

import Commons.BinarySearchTree;
import Commons.Node;

public class ShortestDistanceBetweenNodes {
	private static int distance(Node root, int element) {
		if (root == null || root.val == element) {
			return 0;
		}

		if (root.val > element) {
			return 1 + distance(root.left, element);
		} else {
			return 1 + distance(root.right, element);
		}
	}

	private static int getShortestDistance(Node root, int n1, int n2) {
		if (root == null) {
			return 0;
		}

		if (n1 > root.val && n2 > root.val) {
			return getShortestDistance(root.right, n1, n2);
		}

		if (n1 < root.val && n2 < root.val) {
			return getShortestDistance(root.left, n1, n2);
		}

		if (n1 <= root.val && n2 >= root.val) {
			return distance(root, n1) +
					distance(root, n2);
		}

		return 0;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		Node root = bst.insert(null, 20);
		bst.insert(root, 10);
		bst.insert(root, 5);
		bst.insert(root, 15);
		bst.insert(root, 30);
		bst.insert(root, 25);
		bst.insert(root, 35);
		System.out.println(getShortestDistance(root, 5, 35));
	}
}
