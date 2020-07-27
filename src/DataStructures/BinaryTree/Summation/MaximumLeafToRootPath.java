/*
Find the maximum sum leaf to root path in a Binary Tree
Given a Binary Tree, find the maximum sum path from a leaf to root.
For example, in the following tree, there are three leaf to root paths 8->-2->10, -4->-2->10 and 7->10.
The sums of these three paths are 16, 4 and 17 respectively. The maximum of them is 17
and the path for maximum is 7->10.
                  10
               /      \
             -2        7
           /   \
          8     -4
Solution
1) First find the leaf node that is on the maximum sum path.
	In the following code getTargetLeaf() does this by assigning the result to *target_leaf_ref.
2) Once we have the target leaf node, we can print the maximum sum path by traversing the tree.
	In the following code, printPath() does this.

The main function is maxSumPath() that uses above two functions to get the complete solution.
 */

package DataStructures.BinaryTree.Summation;

import Commons.Node;

public class MaximumLeafToRootPath {
	private static int result = -9999;
	private static Node target = null;

	private static void getTargetLeaf(Node root, int currentSum) {
		if (root == null) {
			return;
		}

		currentSum = currentSum + root.val;

		if (root.left == null && root.right == null) {
			if (currentSum > result) {
				result = currentSum;
				target = root;
			}
		}

		getTargetLeaf(root.left, currentSum);
		getTargetLeaf(root.right, currentSum);
	}

	private static boolean printPath(Node root, Node target) {
		if (root == null) {
			return false;
		}

		if (root == target ||
				printPath(root.left, target) ||
				printPath(root.right, target)) {
			System.out.print(root.val + " ");
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(-2);
		root.right = new Node(7);
		root.left.left = new Node(8);
		root.left.right = new Node(-4);

		getTargetLeaf(root, 0);
		printPath(root, target);
		System.out.println("\n" + result);
	}
}
