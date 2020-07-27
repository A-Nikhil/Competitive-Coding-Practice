/*
Largest number in BST which is less than or equal to N

We follow recursive approach for solving this problem.
We start searching for element from root node. If we reach a leaf and its value is greater than N,
element does not exist so return -1. Else if node’s value is less than or equal to N and
right value is NULL or greater than N, then return the node value as it will be the answer.
Otherwise if node’s value is greater than N, then search for the element in the left
subtree else search for the element in the right subtree by calling the same function
by passing the left or right values accordingly.

https://www.geeksforgeeks.org/largest-number-bst-less-equal-n/
 */

package DataStructures.BinarySearchTree.CheckingAndPrinting;

import Commons.BinarySearchTree;
import Commons.Node;

public class ClosestElementToN {
	private static int findElement(Node root, int N) {
		if (root == null) {
			return -1;
		}

		if (root.val <= N &&
				(root.right == null || root.right.val > N)) {
			return root.val;
		}

		if (root.val > N) {
			return findElement(root.left, N);
		} else if (root.val < N) {
			return findElement(root.right, N);
		}

		return -1;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		Node root = bst.insert(null, 25);
		bst.insert(root, 2);
		bst.insert(root, 1);
		bst.insert(root, 3);
		bst.insert(root, 12);
		bst.insert(root, 9);
		bst.insert(root, 21);
		bst.insert(root, 19);
		bst.insert(root, 5);
		int N = 22;
		System.out.println(findElement(root, N));
	}
}
