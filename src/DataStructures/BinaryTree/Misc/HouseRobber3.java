// https://leetcode.com/problems/house-robber-iii/

package DataStructures.BinaryTree.Misc;

import Commons.Node;

public class HouseRobber3 {
	private static int rob(Node root) {
		if (root == null) {
			return 0;
		}

		int[] result = helper(root);
		return Math.max(result[0], result[1]);
	}

	private static int[] helper(Node root) {
		if (root == null) {
			return new int[]{0, 0};
		}

		int[] result = new int[2];
		int[] left = helper(root.left);
		int[] right = helper(root.right);

		// result[0] is when root is selected, result[1] is when not.
		result[0] = root.val + left[1] + right[1];
		result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		return result;
	}

	public static void main(String[] args) {
		/*
		     3
			/ \
		   4   5
		  / \   \
		 1   3   1

		*/
		Node root = new Node(3);
		root.left = new Node(4);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.right = new Node(1);

		System.out.println(rob(root));
	}
}
