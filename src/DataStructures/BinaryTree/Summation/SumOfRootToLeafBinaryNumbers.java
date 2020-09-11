package DataStructures.BinaryTree.Summation;

import Commons.Node;

public class SumOfRootToLeafBinaryNumbers {
	private int sum;

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(0);
		root.left.left = new Node(0);
		root.left.right = new Node(1);
		root.right = new Node(1);
		root.right.left = new Node(0);
		root.right.right = new Node(1);
		System.out.println(new SumOfRootToLeafBinaryNumbers().sumRootToLeaf(root));
	}

	private int convertToDecimal(String binary) {
		int two = 1, x = 0;
		for (int i = binary.length() - 1; i >= 0; i--) {
			x += (binary.charAt(i) - '0') * two;
			two *= 2;
		}
		return x;
	}

	private void traverser(Node root, String binary) {
		if (root.right == null && root.left == null) {
			System.out.println(binary + root.val);
			sum += convertToDecimal(binary + root.val);
			return;
		}
		if (root.left != null) {
			traverser(root.left, binary + root.val);
		}
		if (root.right != null) {
			traverser(root.right, binary + root.val);
		}
	}

	public int sumRootToLeaf(Node root) {
		sum = 0;
		if (root == null) {
			return sum;
		}
		traverser(root, "");
		return sum;
	}

}
