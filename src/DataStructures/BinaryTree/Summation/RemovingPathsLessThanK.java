/*
Remove all nodes which don’t lie in any path with sum>= k
Given a binary tree, a complete path is defined as a path from root to a leaf.
The sum of all nodes on that path is defined as the sum of that path. Given a number K,
you have to remove (prune the tree) all nodes which don’t lie in any path with sum>=k.

Note: A node can be part of multiple paths. So we have to delete it only in case when all
paths from it have sum less than K.

Consider the following Binary Tree
          1
      /      \
     2        3
   /   \     /  \
  4     5   6    7
 / \    /       /
8   9  12      10
   / \           \
  13  14         11
      /
     15

For input k = 20, the tree should be changed to following
(Nodes with values 6 and 8 are deleted)
          1
      /      \
     2        3
   /   \        \
  4     5        7
   \    /       /
    9  12      10
   / \           \
  13  14         11
      /
     15

For input k = 45, the tree should be changed to following.
      1
    /
   2
  /
 4
  \
   9
    \
     14
     /
    15

The idea is to keep reducing the sum when traversing down.
When we reach a leaf and sum is greater than the leaf’s data,
then we delete the leaf. Note that deleting nodes may convert a non-leaf node to a
leaf node and if the data for the converted leaf node is less than the current sum,
then the converted leaf should also be deleted.

https://www.geeksforgeeks.org/remove-all-nodes-which-lie-on-a-path-having-sum-less-than-k/
 */

package DataStructures.BinaryTree.Summation;

import Commons.Node;

public class RemovingPathsLessThanK {
	private static Node prune(Node root, int sum) {
		if (root == null) {
			return null;
		}
		root.left = prune(root.left, sum - root.val);
		root.right = prune(root.right, sum - root.val);
		if (root.left == null && root.right == null) {
			if (sum > root.val) {
				root = null;
			}
		}

		return root;
	}

	private static void printInorder(Node root) {
		if (root == null) {
			return;
		}
		printInorder(root.left);
		System.out.print(root.val + " ");
		printInorder(root.right);
	}

	@SuppressWarnings("Duplicates")
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right.left = new Node(12);
		root.right.right.left = new Node(10);
		root.right.right.left.right = new Node(11);
		root.left.left.right.left = new Node(13);
		root.left.left.right.right = new Node(14);
		root.left.left.right.right.left = new Node(15);
		int sum = 45;
		printInorder(prune(root, sum));
	}
}
