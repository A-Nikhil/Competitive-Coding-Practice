/*
We can find the maximum sum using single traversal of binary tree.
The idea is to maintain two values in recursive calls
1) Maximum root to leaf path sum for the subtree rooted under current node.
2) The maximum path sum between leaves (desired output).

For every visited node X, we find the maximum root to leaf sum in left and right subtrees of X.
We add the two values with X->data, and compare the sum with maximum path sum found so far.

https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/
 */

package DataStructures.BinaryTree.Summation;

import Commons.Node;

public class MaxPathSum {
	private static int result = Integer.MIN_VALUE;

	private static int getResult(Node root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return root.val;
		}

		// Find maximum sum in left and right subtree. Also
		// find maximum root to leaf sums in left and right
		// subtrees and store them in ls and rs
		int ls = getResult(root.left),
				rs = getResult(root.right);

		// If both left and right children exist
		if (root.left != null && root.right != null) {
			result = Math.max(result, ls + rs + root.val);
			return Math.max(ls, rs) + root.val;
		}

		// If any of the two children is empty, return
		// root sum for root being on one side
		return (root.left == null) ? rs + root.val : ls + root.val;
	}

	private static int maxPathSum(Node root) {
		getResult(root);
		return result;
	}

	public static void main(String[] args) {
		Node root;
		root = new Node(-15);
		root.left = new Node(5);
		root.right = new Node(6);
		root.left.left = new Node(-8);
		root.left.right = new Node(1);
		root.left.left.left = new Node(2);
		root.left.left.right = new Node(6);
		root.right.left = new Node(3);
		root.right.right = new Node(9);
		root.right.right.right = new Node(0);
		root.right.right.right.left = new Node(4);
		root.right.right.right.right = new Node(-1);
		root.right.right.right.right.left = new Node(10);

		System.out.println(maxPathSum(root));
	}
}
