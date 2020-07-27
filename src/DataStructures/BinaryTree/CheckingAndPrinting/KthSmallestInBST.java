package DataStructures.BinaryTree.CheckingAndPrinting;

import Commons.Node;

public class KthSmallestInBST {
	private static int kth;
	private static boolean found;
	private static int count;

	private static int kthSmallest(Node root, int k) {
		if (root == null) {
			return 0;
		}
		kth = 0;
		count = 0;
		found = false;
		helper(root, k);
		return kth;
	}

	private static void helper(Node root, int k) {
		if (root == null) {
			return;
		}
		helper(root.left, k);
		count++;
		if (count == k && !found) {
			kth = root.val;
			found = true;
			return;
		}
		helper(root.right, k);
	}

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(6);
		root.left.left = new Node(2);
		root.left.right = new Node(4);
		root.left.left.left = new Node(1);
		int k = 3;
		System.out.println(kthSmallest(root, k));
	}
}
