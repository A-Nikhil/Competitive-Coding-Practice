/*
Check if a given Binary Tree is SumTree
A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in its
left subtree and right subtree. An empty tree is SumTree and sum of an empty tree can be considered as 0.
A leaf node is also considered as SumTree.

Following is an example of SumTree.
          26
        /   \
      10     3
    /    \     \
  4      6      3

This method uses following rules to get the sum directly.
1) If the node is a leaf node then sum of subtree rooted with this node is equal to value of this node.
2) If the node is not a leaf node then sum of subtree rooted with this node is twice the value of this node
(Assuming that the tree rooted with this node is SumTree).
 */

package DataStructures.BinaryTree.CheckingAndPrinting;

import Commons.Node;

@SuppressWarnings("Duplicates")
public class BinarySumTree {
	private static boolean isLeaf(Node root) {
		if (root == null) {
			return false;
		}
		return root.left == null && root.right == null;
	}

	private static boolean isSumTree(Node root) {
		int left = 0, right = 0;
		if (root == null || isLeaf(root)) {
			return true;
		}
		if (isSumTree(root.left) && isSumTree(root.right)) {
			if (root.left != null) {
				if (isLeaf(root.left)) {
					left = root.left.val;
				} else {
					left = 2 * root.left.val;
				}
			}
			if (root.right != null) {
				if (isLeaf(root.right)) {
					right = root.right.val;
				} else {
					right = 2 * root.right.val;
				}
			}
			return (root.val == (left + right));
		}
		return false;
	}

	public static void main(String[] args) {
		Node root;
		root = new Node(26);
		root.left = new Node(10);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(6);
		root.right.right = new Node(3);
		System.out.println(isSumTree(root));
	}
}
