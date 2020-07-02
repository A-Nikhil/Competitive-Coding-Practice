/*
Check whether a given binary tree is perfect or not

A Binary tree is Perfect Binary Tree in which all internal nodes have two children and
all leaves are at same level.

			   10
           /       \
         20         30
        /  \        /  \
      40    50    60   70

Below is an idea to check whether a given Binary Tree is perfect or not.

Find depth of any node (in below tree we find depth of leftmost node). Let this depth be d.
Now recursively traverse the tree and check for following two conditions.
	Every internal node should have both children non-empty
	All leaves are at depth ‘d’

https://www.geeksforgeeks.org/check-weather-given-binary-tree-perfect-not/
 */

package DataStructures.BinaryTree.CheckingAndPrinting;

import Commons.Node;

@SuppressWarnings("Duplicates")
public class PerfectBinaryTree {
	private static int leftLeafLevel(Node root) {
		if (root.left == null && root.right == null) {
			return 0;
		}
		if (root.left != null) {
			return 1 + leftLeafLevel(root.left);
		} else {
			return 0;
		}
	}

	private static boolean checkLeaves(Node root, int leafLevel, int myLevel) {
		if (root == null) {
			return true;
		}

		if (isLeaf(root)) {
			return myLevel == leafLevel;
		} else {
			return checkLeaves(root.left, leafLevel, myLevel + 1)
					&& checkLeaves(root.right, leafLevel, myLevel + 1);
		}
	}

	private static boolean checkInternalNodes(Node root) {
		if (root == null || isLeaf(root)) {
			return true;
		}
		if (root.left != null && root.right != null) {
			return checkInternalNodes(root.left) && checkInternalNodes(root.right);
		} else {
			return false;
		}
	}

	private static boolean isLeaf(Node root) {
		return root.left == null && root.right == null;
	}

	private static boolean isPerfect(Node root) {
		int leafLevel = leftLeafLevel(root);
		return checkLeaves(root, leafLevel, 0)
				&& checkInternalNodes(root);
	}

	public static void main(String[] args) {
		Node root;
		root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);

		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.left = new Node(60);
		root.right.right = new Node(70);

		System.out.println(isPerfect(root));
	}
}
