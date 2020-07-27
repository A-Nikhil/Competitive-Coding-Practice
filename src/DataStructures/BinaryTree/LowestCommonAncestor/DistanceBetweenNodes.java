/*
Find the distance between two nodes in a tree

Approach =>
1. Find the LCA of both nodes
2. Find distance of LCA from Node 1 and Node 2

 */

package DataStructures.BinaryTree.LowestCommonAncestor;

import Commons.Node;

public class DistanceBetweenNodes {
	private static int findLevelFromRoot(Node root, int element, int level) {
		// Distance is basically the level from the root
		if (root == null) {
			return 0;
		}
		if (root.val == element) {
			return level;
		}
		int left = findLevelFromRoot(root.left, element, level + 1);
		if (left == 0) {
			return findLevelFromRoot(root.right, element, level + 1);
		}
		return left;
	}

	private static Node findLCA(Node root, int n1, int n2) {
		if (root == null) {
			return null;
		}

		if (root.val == n1 || root.val == n2) {
			return root;
		}
		Node left = findLCA(root.left, n1, n2);
		Node right = findLCA(root.right, n1, n2);

		if (left != null && right != null) {
			return root;
		}

		return left != null ? left : right;
	}

	private static int findDistance(Node root, int n1, int n2) {
		Node lca = findLCA(root, n1, n2);
		return findLevelFromRoot(lca, n1, 0)
				+ findLevelFromRoot(lca, n2, 0);
	}

	@SuppressWarnings("Duplicates")
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);

		System.out.println("Dist(4, 5) = " + findDistance(root, 4, 5));
		System.out.println("Dist(4, 6) = " + findDistance(root, 4, 6));
		System.out.println("Dist(3, 4) = " + findDistance(root, 3, 4));
		System.out.println("Dist(2, 4) = " + findDistance(root, 2, 4));
		System.out.println("Dist(8, 5) = " + findDistance(root, 8, 5));
	}
}
