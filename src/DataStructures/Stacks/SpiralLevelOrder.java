package DataStructures.Stacks;

import Commons.Node;

import java.util.Stack;

@SuppressWarnings("Duplicates")
public class SpiralLevelOrder {
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(7);
		root.left.right = new Node(6);
		root.right.left = new Node(5);
		root.right.right = new Node(4);
		printSpiral(root);
	}

	private static void printSpiral(Node root) {
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.push(root);
		while (!s1.isEmpty() || !s2.isEmpty()) {
			while (!s1.isEmpty()) {
				root = s1.pop();
				System.out.print(root.val + " ");
				if (root.right != null) {
					s2.push(root.right);
				}
				if (root.left != null) {
					s2.push(root.left);
				}
			}

			while (!s2.isEmpty()) {
				root = s2.pop();
				System.out.print(root.val + " ");
				if (root.right != null) {
					s1.push(root.right);
				}
				if (root.left != null) {
					s1.push(root.left);
				}
			}
		}
	}
}
