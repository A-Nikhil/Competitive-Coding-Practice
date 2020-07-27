package DataStructures.BinaryTree.Summation;

import Commons.Node;

import java.util.ArrayList;
import java.util.List;

public class AllPathsWithSumKFromRootToLeaf {
	private static final List<List<Integer>> result = new ArrayList<>();

	private static List<List<Integer>> pathSum(Node root, int sum) {
		if (root == null) {
			return result;
		}
		List<Integer> list = new ArrayList<>();
		list.add(root.val);
		getPaths(list, root, sum - root.val);
		return result;
	}

	private static void getPaths(List<Integer> list, Node root, int sum) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null && sum == 0) {
			result.add(new ArrayList<>(list));
		}

		if (root.left != null) {
			list.add(root.left.val);
			getPaths(list, root.left, sum - root.left.val);
			list.remove(list.size() - 1);
		}

		if (root.right != null) {
			list.add(root.right.val);
			getPaths(list, root.right, sum - root.right.val);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(-2);
		root.right = new Node(7);
		root.left.left = new Node(8);
		root.left.right = new Node(-4);
		int sum = 0;
		System.out.println(pathSum(root, sum));
	}
}
