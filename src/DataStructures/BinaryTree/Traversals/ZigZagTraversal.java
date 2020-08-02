package DataStructures.BinaryTree.Traversals;

import Commons.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ZigZagTraversal {
	public static void main(String[] args) {
		Node root = new Node(12);
		root.left = new Node(10);
		root.right = new Node(30);
		root.left.left = new Node(60);
		root.left.right = new Node(70);
		root.right.left = new Node(25);
		root.right.right = new Node(40);
		List<Integer> result = new ZigZagTraversal().zigzag(root);
		System.out.println(result);
	}

	public List<Integer> zigzag(Node root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		LinkedList<Node> queue = new LinkedList<>();
		boolean leftToRight = true;
		int start, end;
		result.add(root.val);
		if (root.left != null) {
			queue.add(root.left);
		}
		if (root.right != null) {
			queue.add(root.right);
		}
		while (!queue.isEmpty()) {
			int size = queue.size();
			if (leftToRight) {
				start = 0;
				end = size - 1;
			} else {
				start = size - 1;
				end = 0;
			}
			for (int i = start; i <= end; i++) {
				root = queue.get(i);
				result.add(root.val);
				if (root.left != null) {
					queue.add(root.left);
				}
				if (root.right != null) {
					queue.add(root.right);
				}
			}
			leftToRight = !leftToRight;
		}
		return result;
	}
}