package binarySearchTree.checkingAndPrinting;

import commons.BinarySearchTree;
import commons.Node;

public class InorderPredAndSucc {
	private static Node max = new Node(0),
			min = new Node(0);

	private static void findLimit(Node node, boolean findMax) {
		if (node == null) {
			return;
		}
		if (findMax) {
			if (node.data > max.data) {
				max = node;
			}
		} else {
			if (node.data < min.data) {
				min = node;
			}
		}
		findLimit(node.left, findMax);
		findLimit(node.right, findMax);
	}

	private static void findPredAndSucc(Node root, int element) {
		if (root == null) {
			return;
		}

		if (root.data == element) {
			if (root.left != null) {
				max = new Node(Integer.MIN_VALUE);
				findLimit(root.left, true);
			}
			if (root.right != null) {
				min = new Node(Integer.MAX_VALUE);
				findLimit(root.right, false);
			}
			return;
		}

		if (root.data > element) {
			min = root;
			findPredAndSucc(root.left, element);
		} else {
			max = root;
			findPredAndSucc(root.right, element);
		}
	}

	@SuppressWarnings("Duplicates")
	public static void main(String[] args) {
		min = new Node(Integer.MAX_VALUE, null, null);
		BinarySearchTree tree = new BinarySearchTree();
		Node root = tree.insert(null, 20);
		tree.insert(root, 8);
		tree.insert(root, 22);
		tree.insert(root, 4);
		tree.insert(root, 12);
		tree.insert(root, 10);
		tree.insert(root, 14);
		int n = 10;
		findPredAndSucc(root, n);
		System.out.println("pred => " + max.data);
		System.out.println("succ => " + min.data);
	}
}
