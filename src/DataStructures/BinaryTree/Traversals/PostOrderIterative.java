package DataStructures.BinaryTree.Traversals;

import Commons.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class PostOrderIterative {
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println(new PostOrderIterative().postorderTraversal(root));
	}

	public List<Integer> postorderTraversal(Node root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Set<Node> set = new HashSet<>();
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		boolean doneRight, doneLeft;
		while (!stack.isEmpty()) {
			doneLeft = doneRight = false;
			root = stack.peek();
			// leaf node
			if (root.right == null && root.left == null) {
				stack.pop();
				set.add(root);
				result.add(root.val);
				continue;
			}
			if (root.right != null && !set.contains(root.right)) {
				stack.push(root.right);
			} else {
				doneRight = true;
			}
			if (root.left != null && !set.contains(root.left)) {
				stack.push(root.left);
			} else {
				doneLeft = true;
			}

			if (doneLeft && doneRight) {
				result.add(root.val);
				set.add(root);
				stack.pop();
			}
		}
		return result;
	}
}
