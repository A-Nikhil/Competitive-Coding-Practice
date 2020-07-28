package DataStructures.BinaryTree.CheckingAndPrinting;

import Commons.Node;

public class FlattenABT {
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right = new Node(5);
		root.right.right = new Node(6);
		flatten(root);
	}

	private static void flatten(Node root) {
		root.left = root.right = null;
		return;
	}
}
