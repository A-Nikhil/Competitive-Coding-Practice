/*
Maximum difference between node and its ancestor in Binary Tree

Given a binary tree, we need to find maximum value we can get by subtracting value of node B
from value of node A, where A and B are two nodes of the binary tree and A is an ancestor of B.
Expected time complexity is O(n).

If we are at leaf node then just return its value because it can’t be ancestor of any node.
Then at each internal node we will try to get minimum value from left subtree and right subtree
and calculate the difference between node value and this minimum value and according to that
we will update the result.
As we are calculating minimum value while retuning in recurrence we will check all
optimal possibilities (checking node value with minimum subtree value only) of
differences and hence calculate the result in one traversal only.

https://www.geeksforgeeks.org/maximum-difference-between-node-and-its-ancestor-in-binary-tree/
 */

package DataStructures.BinaryTree.LowestCommonAncestor;

import Commons.GlobalVar;
import Commons.Node;

public class MaxDifferenceBetweenNodeAndAncestor {
	private static int findMinimum(Node root, GlobalVar small) {
		if (root == null) {
			return 99999;
		}

		// Return leaf node if encountered
		if (root.left == null && root.right == null) {
			return root.val;
		}

		int value = Math.min(findMinimum(root.left, small),
				findMinimum(root.right, small));

		small.var = Math.max(small.var, root.val - value);

		return Math.min(value, root.val);
	}

	private static int getMaxDifference(Node root) {
		GlobalVar small = new GlobalVar(-9999);
		findMinimum(root, small);
		return small.var;
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

		System.out.println(getMaxDifference(root));
	}
}
