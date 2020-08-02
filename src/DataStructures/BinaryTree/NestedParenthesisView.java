package DataStructures.BinaryTree;

import Commons.Node;

public class NestedParenthesisView {
	public String x;

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(6);

		System.out.println(new NestedParenthesisView().nestedParenthesis(root));
	}

	public String nestedParenthesis(Node root) {
		x = "";
		helper(root);
		return x.substring(1, x.length() - 1);
	}

	public void helper(Node root) {
		if (root.left == null && root.right == null) {
			x = x + "(" + root.val + ")";
			return;
		}

		x = x + "(" + root.val;

		if (root.left != null) {
			helper(root.left);
		}
//		x = x + ")";
		if (root.right != null) {
			helper(root.right);
		}
		x = x + ")";
	}
}
