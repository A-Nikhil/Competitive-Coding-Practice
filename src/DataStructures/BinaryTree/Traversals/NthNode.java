/*
Find n-th node of inorder traversal

Input : n = 4
              10
            /   \
           20     30
         /   \
        40     50
Output : 10
Inorder Traversal is : 40 20 50 10 30

We do simple Inorder Traversal. While doing the traversal,
we keep track of count of nodes visited so far. When count becomes n, we print the node.

https://www.geeksforgeeks.org/find-n-th-node-inorder-traversal/
 */

package DataStructures.BinaryTree.Traversals;

import Commons.Node;

public class NthNode {
	private static int position = 0;

	private static int inOrderTraversal(Node root, int n) {
		if (root == null) {
			return -1;
		}
		inOrderTraversal(root.left, n);
		position++;
		if (position == n) {
			return root.val;
		}
		inOrderTraversal(root.right, n);
		return -1;
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(50);

		int n = 4;
		System.out.println(inOrderTraversal(root, n));
	}

}
