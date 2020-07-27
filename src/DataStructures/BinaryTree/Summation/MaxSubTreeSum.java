/*
Find largest subtree sum in a tree
Given a binary tree, task is to find subtree with maximum sum in tree.

Examples:

Input :       1
            /   \
           2      3
          / \    / \
         4   5  6   7
Output : 28
As all the tree elements are positive,
the largest subtree sum is equal to
sum of all tree elements.

Input :       1
            /    \
          -2      3
          / \    /  \
         4   5  -6   2
Output : 7
Subtree with largest sum is :  -2
                             /  \
                            4    5
Also, entire tree sum is also 7.

Approach :
Do post order traversal of the binary tree. At every node, find left subtree value and
right subtree value recursively. The value of subtree rooted at current node is equal to
sum of current node value, left node subtree sum and right node subtree sum.
Compare current subtree sum with overall maximum subtree sum so far.

https://www.geeksforgeeks.org/find-largest-subtree-sum-tree/
 */

package DataStructures.BinaryTree.Summation;

import Commons.Node;

public class MaxSubTreeSum {
	private static int sum = 0;

	private static int getSum(Node root) {
		if (root == null) {
			return 0;
		}

		int ls = getSum(root.left),
				rs = getSum(root.right);

		int currentNodeSum = ls + rs + root.val;

		if (currentNodeSum > sum) {
			sum = currentNodeSum;
		}

		return currentNodeSum;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(-2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(-6);
		root.right.right = new Node(2);
		getSum(root);
		System.out.println(sum);
	}
}
