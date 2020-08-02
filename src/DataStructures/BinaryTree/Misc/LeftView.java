package DataStructures.BinaryTree.Misc;

import Commons.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftView {
	public static void main(String[] args) {
		Node root = new Node(12);
		root.left = new Node(10);
		root.right = new Node(30);
		root.right.left = new Node(25);
		root.right.right = new Node(40);

		List<Integer> result = new LeftView().printLeftView(root);
		System.out.println(result);
	}

	public List<Integer> printLeftView(Node root) {
		List<Integer> leftmost = new ArrayList<>();
		if (root == null) {
			return leftmost;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				root = queue.poll();
				if (i == 0) {
					leftmost.add(root.val);
				}
				if (root.left != null) {
					queue.add(root.left);
				}
				if (root.right != null) {
					queue.add(root.right);
				}
			}
		}

		return leftmost;
	}

}