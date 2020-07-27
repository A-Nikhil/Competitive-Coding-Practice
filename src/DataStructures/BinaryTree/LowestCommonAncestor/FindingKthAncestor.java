package DataStructures.BinaryTree.LowestCommonAncestor;

import Commons.Node;

public class FindingKthAncestor {
	private static int k;

	private static Node kThAncestorDFS(Node root, int element) {
		if (root == null) {
			return null;
		}

		if (root.val == element ||
				kThAncestorDFS(root.left, element) != null ||
				kThAncestorDFS(root.right, element) != null) {
			if (k > 0) {
				k--;
			} else if (k == 0) {
				System.out.println(root.val);
				return null;
			}
			return root;
		}
		return null;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		k = 3;
		int node = 4;
		Node parent = kThAncestorDFS(root, node);
		if (parent != null) {
			System.out.println("-1");
		}
	}
}
