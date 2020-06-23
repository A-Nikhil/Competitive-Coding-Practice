package binaryTree.traversals;

import commons.Node;

public class TreeTraversalBasics {
	private static void preOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}

	private static void inOrder(Node root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}

	private static void postOrder(Node root) {
		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);
	}

	public static void main(String[] args) {
		Node root;
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.println("Preorder traversal of binary tree is ");
		preOrder(root);

		System.out.println("\nInorder traversal of binary tree is ");
		inOrder(root);

		System.out.println("\nPostorder traversal of binary tree is ");
		postOrder(root);
	}
}
