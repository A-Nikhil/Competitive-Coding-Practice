/*
Following is simple O(n) algorithm to find LCA of n1 and n2.
1) Find path from root to n1 and store it in a vector or array.
2) Find path from root to n2 and store it in another vector or array.
3) Traverse both paths till the values in arrays are same.
Return the common element just before the mismatch.
 */

package DataStructures.BinaryTree.LowestCommonAncestor;

import Commons.Node;

import java.util.ArrayList;

public class LCAUsing3Arrays {
	private static ArrayList<Integer> node1path, node2path;

	private static boolean traversal(Node root, int data, boolean one) {
		if (root == null) {
			return true;
		}

		int current = root.val;
		if (root.left != null && traversal(root.left, data, one)) {
			if (one) {
				if (!node1path.contains(current)) {
					node1path.add(current);
				}
			} else {
				if (!node2path.contains(current)) {
					node2path.add(current);
				}
			}
			return true;
		}

		if (root.right != null && traversal(root.right, data, one)) {
			if (one) {
				if (!node1path.contains(current)) {
					node1path.add(current);
				}
			} else {
				if (!node2path.contains(current)) {
					node2path.add(current);
				}
			}
			return true;
		}

		return root.val == data;
	}

	private static int findLCA(Node root, int n1, int n2) {
		node1path = new ArrayList<>();
		node2path = new ArrayList<>();
		traversal(root, n1, true);
		traversal(root, n2, false);
		int size = Math.min(node1path.size(), node2path.size());
		int i;
		for (i = size - 1; i > 0; i--) {
			if (!node1path.get(i).equals(node2path.get(i)))
				break;
		}
		return node2path.get(i);
	}

	@SuppressWarnings("Duplicates")
	public static void main(String[] args) {
		Node root;
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println("LCA(4, 5) = " +
				findLCA(root, 4, 5));
		System.out.println("LCA(4, 6) = " +
				findLCA(root, 4, 6));
		System.out.println("LCA(3, 4) = " +
				findLCA(root, 3, 4));
		System.out.println("LCA(2, 4) = " +
				findLCA(root, 2, 4));
	}
}
