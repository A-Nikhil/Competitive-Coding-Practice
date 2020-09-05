/*
Full Binary Tree

To check whether a binary tree is a full binary tree we need to Others.test the following cases:-

1) If a binary tree node is NULL then it is a full binary tree.
2) If a binary tree node does have empty left and right sub-trees, then
	it is a full binary tree by definition.
3) If a binary tree node has left and right sub-trees, then it is a
	part of a full binary tree by definition.
	In this case recursively check if the left and right sub-trees are also binary trees themselves.
4) In all other combinations of right and left sub-trees, the binary tree is not a full binary tree.

https://www.geeksforgeeks.org/check-whether-binary-tree-full-binary-tree-not/
 */
package DataStructures.BinaryTree.CheckingAndPrinting;

import Commons.Node;

public class FullBinaryTree {
	private static boolean isFull(Node root) {
		if (root == null) {
			return true;
		}
		if (root.left == null && root.right == null) {
			return true;
		}
		if (root.left != null && root.right != null) {
			return isFull(root.left) && isFull(root.right);
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Node root;
		root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.right = new Node(40);
		root.left.left = new Node(50);
		root.right.left = new Node(60);
		root.left.left.left = new Node(80);
		root.right.right = new Node(70);
		root.left.left.right = new Node(90);
		root.left.right.left = new Node(80);
		root.left.right.right = new Node(90);
		root.right.left.left = new Node(80);
		root.right.left.right = new Node(90);
		root.right.right.left = new Node(80);
		root.right.right.right = new Node(90);

		System.out.println(isFull(root));
	}
}
