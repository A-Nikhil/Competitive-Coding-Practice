/*
Find if there is a pair in root to a leaf path with sum equals to root’s data

Given a binary tree, find if there is a pair in root to a leaf path such that
sum of values in pair is equal to root’s data

Approach =>
	Create an empty hash table.
	Start traversing tree in Preorder fashion.
	If we reach a leaf node, we return false.
	For every visited node, check if root’s data minus current node’s data exists in hash table or not.
		If yes, return true. Else insert current node in hash table.
	Recursively check in left and right subtrees.
	Remove current node from hash table so that it doesn’t appear in other root to leaf paths.

https://www.geeksforgeeks.org/find-pair-root-leaf-path-sum-equals-roots-data/
 */

package DataStructures.BinaryTree.Summation;

import Commons.Node;

import java.util.HashSet;

public class PairSumEqualToRoot {
	private static boolean doesPairExist(Node root) {
		HashSet<Integer> map = new HashSet<>();
		return pairCheck(root, map, root.val);
	}

	private static boolean pairCheck(Node root, HashSet<Integer> map, int rootData) {
		if (root == null) {
			return true;
		}

		if (map.contains(rootData - root.val)) {
			return true;
		}

		map.add(root.val);

		boolean result = pairCheck(root.left, map, rootData)
				|| pairCheck(root.left, map, rootData);

		map.remove(root.val);

		return result;
	}

	@SuppressWarnings("Duplicates")
	public static void main(String[] args) {
		Node root = new Node(8);
		root.left = new Node(5);
		root.right = new Node(4);
		root.left.left = new Node(9);
		root.left.right = new Node(7);
		root.left.right.left = new Node(1);
		root.left.right.right = new Node(12);
		root.left.right.right.right = new Node(2);
		root.right.right = new Node(11);
		root.right.right.left = new Node(3);

		System.out.println(doesPairExist(root));
	}
}
