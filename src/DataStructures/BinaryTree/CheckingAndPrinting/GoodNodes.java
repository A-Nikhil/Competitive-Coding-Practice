// https://leetcode.com/problems/count-good-nodes-in-binary-tree/

package DataStructures.BinaryTree.CheckingAndPrinting;

import Commons.Node;

public class GoodNodes {
	private static int count;

	private static int goodNodes(Node root) {
		if (root == null) {
			return 0;
		}
		count = 0;
		helper(root, Integer.MIN_VALUE);
		return count;
	}

	private static void helper(Node root, int max) {
		if (root == null) {
			return;
		}

		if (root.data >= max) {
			count++;
		}

		helper(root.left, Math.max(max, root.data));
		helper(root.right, Math.max(max, root.data));
	}

	public static void main(String[] args) {
		Node root = new Node(3);

	}
}
