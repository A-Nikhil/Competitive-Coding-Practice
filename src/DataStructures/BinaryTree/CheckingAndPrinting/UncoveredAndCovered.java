/*
Check sum of Covered and Uncovered nodes of Binary Tree

Given a binary tree, you need to check whether sum of all covered elements is equal to sum of
all uncovered elements or not.
In a binary tree, a node is called Uncovered if it appears either on left boundary or right boundary.
Rest of the nodes are called covered.

https://www.geeksforgeeks.org/check-sum-covered-uncovered-nodes-binary-tree/
 */

package DataStructures.BinaryTree.CheckingAndPrinting;

import Commons.Node;

public class UncoveredAndCovered {
	private static int totalSum(Node root) {
		if (root == null) {
			return 0;
		} else {
			return root.val + totalSum(root.left) + totalSum(root.right);
		}
	}

	private static int uncoveredSumLeft(Node root) {
		if (root.left == null && root.right == null) {
			return 0;
		}
		if (root.left != null) {
			return root.val + uncoveredSumLeft(root.left);
		} else {
			return root.val + uncoveredSumLeft(root.right);
		}
	}

	private static int uncoveredSumRight(Node root) {
		if (root.left == null && root.right == null) {
			return 0;
		}
		if (root.right != null) {
			return root.val + uncoveredSumRight(root.right);
		} else {
			return root.val + uncoveredSumRight(root.left);
		}
	}

	private static boolean checkCoverage(Node root) {
		int uncovered = root.val;
		if (root.left != null) {
			uncovered += uncoveredSumLeft(root.left);
		}
		if (root.right != null) {
			uncovered += uncoveredSumRight(root.right);
		}
		int total = totalSum(root);
		return uncovered == (total - uncovered);
	}

	public static void main(String[] args) {
		Node root;
		root = new Node(8);
		root.left = new Node(3);
		root.left.left = new Node(1);
		root.left.right = new Node(6);
		root.left.right.left = new Node(4);
		root.left.right.right = new Node(7);

		root.right = new Node(10);
		root.right.right = new Node(14);
		root.right.right.left = new Node(13);

		System.out.println(checkCoverage(root));
	}

}
