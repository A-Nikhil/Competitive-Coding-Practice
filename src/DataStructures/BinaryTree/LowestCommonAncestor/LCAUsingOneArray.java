/*
Lowest Common Ancestor in a Binary Tree | Set 1
Given a binary tree (not a binary search tree) and two values say n1 and n2,
write a program to find the least common ancestor.

Let T be a rooted tree. The lowest common ancestor between two nodes n1 and n2 is defined
as the lowest node in T that has both n1 and n2 as descendants (where we allow a node to
be a descendant of itself).

The LCA of n1 and n2 in T is the shared ancestor of n1 and n2 that is located farthest from the root.
Computation of lowest common ancestors may be useful, for instance, as part of a procedure
for determining the distance between pairs of nodes in a tree: the distance from n1 to n2
can be computed as the distance from the root to n1, plus the distance from the root to n2,
minus twice the distance from the root to their lowest common ancestor

Approach =>
The idea is to traverse the tree starting from root.
If any of the given keys (n1 and n2) matches with root, then root is LCA (assuming that
both keys are present). If root doesn’t match with any of the keys, we recur for left and right subtree.
The node which has one key present in its left subtree and the other key present in
right subtree is the LCA. If both keys lie in left subtree, then left subtree has LCA also,
otherwise LCA lies in right subtree.

https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 */

package DataStructures.BinaryTree.LowestCommonAncestor;

import Commons.Node;

@SuppressWarnings("Duplicates")
public class LCAUsingOneArray {
	private static Node findLCA(Node root, int n1, int n2) {
		if (root == null) {
			return null;
		}

		if (root.val == n1 || root.val == n2) {
			return root;
		}

		// If either n1 or n2 matches with root's key, report
		// the presence by returning root (Note that if a key is
		// ancestor of other, then the ancestor key becomes LCA
		Node left = findLCA(root.left, n1, n2);
		Node right = findLCA(root.right, n1, n2);

		// If both of the above calls return Non-NULL, then one key
		// is present in once subtree and other is present in other,
		// So this node is the LCA
		if (left != null && right != null) {
			return root;
		}

		return left != null ? left : right;
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
				findLCA(root, 4, 5).val);
		System.out.println("LCA(4, 6) = " +
				findLCA(root, 4, 6).val);
		System.out.println("LCA(3, 4) = " +
				findLCA(root, 3, 4).val);
		System.out.println("LCA(2, 4) = " +
				findLCA(root, 2, 4).val);
	}
}
