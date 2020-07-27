package DataStructures.Stacks;

import Commons.Node;

import java.util.Stack;

public class AncestorsOfABinaryTree {
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		root.left.right.right = new Node(9);
		root.right.right.left = new Node(10);
		int key = 5;
		printAncestors(root, key);
	}

	private static void printAncestors(Node root, int key) {
		if (root == null) {
			return;
		}

		Stack<Node> stack = new Stack<>();
		while (true) {

			// Traverse the left side. While traversing, push the nodes into
			// the stack so that their right subtrees can be traversed later
			while (root != null && root.val != key) {
				stack.push(root);
				root = root.left;
			}

			if (root != null && root.val == key) {
				break;
			}

			if (stack.peek().right == null) {
				// remove the node and go up
				root = stack.pop();

				// If the popped node is right child of top, then remove the top
				// as well. Left child of the top must have processed before.
				while (!stack.isEmpty() && stack.peek().right == root) {
					root = stack.pop();
				}
			}

			root = stack.isEmpty() ? null : stack.peek().right;
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop().val + " ");
		}
	}
}
