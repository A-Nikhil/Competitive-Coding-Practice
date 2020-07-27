/*
Check for Children Sum Property in a Binary Tree

Given a binary tree, write a function that returns true if the tree satisfies below property.
For every node, data value must be equal to sum of data values in left and right children.
Consider data value as 0 for NULL children. Below tree is an example

https://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/
 */

package DataStructures.BinaryTree.CheckingAndPrinting;

import Commons.Node;

public class ChildSumProperty {
	private static boolean childSum(Node root) {
		int sum = 0;
		if (root == null ||
				(root.left == null && root.right == null)) {
			return true;
		}
		if (root.left != null) {
			sum += root.left.val;
		}
		if (root.right != null) {
			sum += root.right.val;
		}
		return (sum == root.val) &&
				childSum(root.left) &&
				childSum(root.right);
	}

	public static void main(String[] args) {
		Node root;
		root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.right = new Node(2);
		System.out.println(childSum(root));
	}
}
