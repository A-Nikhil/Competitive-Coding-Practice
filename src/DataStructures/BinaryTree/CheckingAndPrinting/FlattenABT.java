package DataStructures.BinaryTree.CheckingAndPrinting;

import Commons.Node;

import java.util.Stack;

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
		if (root == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		Node newRoot = new Node(root.data);
		Node end = newRoot;
		if (root.left != null) {
			stack.push(root.left);
		} else {
			stack.push(root.right);
		}
		while (!stack.isEmpty()) {
			root = stack.pop();
			end.right = new Node(root.data);
			end = end.right;
			if (root.left != null) {
				stack.push(root.left);
			} else if (root.right != null) {
				stack.push(root.right);
			}
		}
		root = newRoot;
	}
}
