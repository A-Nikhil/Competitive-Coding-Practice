/*
Find sum of all left leaves in a given Binary Tree

The idea is to traverse the tree, starting from root.
For every node, check if its left subtree is a leaf. If it is, then add it to the result.

Input : Binary tree:
        5
       / \
      2   5
     / \ / \
    7  2 2  3
Output : 9

https://www.geeksforgeeks.org/find-sum-left-leaves-given-binary-tree/
 */

package DataStructures.BinaryTree.Summation;

import Commons.Node;

public class SumOfLeftLeaves {
	private static int sum = 0;

	private static void sumCalculator(Node root) {
		if (root == null) {
			return;
		}

		if (root.left != null) {
			if (root.left.left == null && root.left.right == null) {
				sum += root.left.val;
			}
		}

		sumCalculator(root.left);
		sumCalculator(root.right);
	}

	public static void main(String[] args) {
		sum = 0;
		Node root;
		root = new Node(20);
		root.left = new Node(9);
		root.right = new Node(49);
		root.left.right = new Node(12);
		root.left.left = new Node(5);
		root.right.left = new Node(23);
		root.right.right = new Node(52);
		root.left.right.right = new Node(12);
		root.right.right.left = new Node(50);

		sumCalculator(root);
		System.out.println(sum);
	}
}
