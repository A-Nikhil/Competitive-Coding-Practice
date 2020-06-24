/*
Input :  K = 3
              8
            /   \
           7     10
         /      /   \
        2      9     13
Output : 17
Explanation : Kth smallest element is 8 so sum of all
              element smaller then or equal to 8 are
              2 + 7 + 8

Approach =>
The idea is to traverse BST in inorder traversal.
Note that Inorder traversal of BST accesses elements in sorted (or increasing) order.
While traversing, we keep track of count of visited Nodes and keep adding Nodes
until the count becomes k.
 */

package binarySearchTree.checkingAndPrinting;

import commons.Node;

@SuppressWarnings("Duplicates")
public class SumOfKSmallestElements {
	private static int sum = 0;
	private static void inorderTraversal(Node root, int k, int count) {
		if (root == null) {
			return;
		}

		inorderTraversal(root.left, k, count);
	}
}
