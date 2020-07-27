/*
A program to check if a binary tree is BST or not

A better solution looks at each node only once.
The trick is to write a utility helper function isBSTUtil(struct node* node, int min, int max)
that traverses down the tree keeping track of the narrowing min and max allowed values as it goes,
looking at each node only once.
The initial values for min and max should be INT_MIN and INT_MAX — they narrow from there.

https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
 */

package DataStructures.BinarySearchTree.CheckingAndPrinting;

import Commons.Node;

public class BinaryTreeIsBST {
	private static boolean traverseBST(Node root, int min, int max) {
		if (root == null) {
			return true;
		}

		if (root.val < min || root.val > max) {
			return false;
		}

		// if left => min = min, max = current data-1
		// if right => min = current data+1, max = max
		return traverseBST(root.left, min, root.val - 1)
				&& traverseBST(root.right, root.val + 1, max);
	}

	public static void main(String[] args) {
		Node root;
		root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		System.out.println(traverseBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
}
