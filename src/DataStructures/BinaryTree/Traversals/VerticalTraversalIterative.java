package DataStructures.BinaryTree.Traversals;

//import java.util.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalTraversalIterative {

	public static void main(String[] args) {
		Commons.Node root = new Commons.Node(12);
		root.left = new Commons.Node(10);
		root.right = new Commons.Node(30);
		root.right.left = new Commons.Node(25);
		root.right.right = new Commons.Node(40);

		List<List<Integer>> result = verticalTraversal(root);
		for (List<Integer> lister : result) {
			for (int x : lister) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}

	private static List<List<Integer>> verticalTraversal(Commons.Node root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		TreeMap<Integer, List<Integer>> map = new TreeMap<>();
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(new Node(root, 0));
		int size;
		Node temp;
		while (!queue.isEmpty()) {
			size = queue.size();
			Collections.sort(queue);
			for (int i = 0; i < size; i++) {
				temp = queue.removeFirst();
				if (!map.containsKey(temp.hd)) {
					map.put(temp.hd, new ArrayList<>());
				}
				map.get(temp.hd).add(temp.root.val);
				if (temp.root.left != null) {
					queue.add(new Node(temp.root.left, temp.hd - 1));
				}
				if (temp.root.right != null) {
					queue.add(new Node(temp.root.right, temp.hd + 1));
				}
			}
		}

		int index = 0;
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			result.add(new ArrayList<>());
			for (int x : entry.getValue()) {
				result.get(index).add(x);
			}
			index++;
		}
		return result;
	}

	static class Node implements Comparable<Node> {
		Commons.Node root;
		int hd;

		Node(Commons.Node root, int hd) {
			this.root = root;
			this.hd = hd;
		}

		@Override
		public int compareTo(Node n) {
			return Integer.compare(this.root.val, n.root.val);
		}
	}
}