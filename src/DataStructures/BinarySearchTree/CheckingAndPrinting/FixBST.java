/*
Remove BST keys outside the given range

There are two possible cases for every node.
1) Node’s key is outside the given range. This case has two sub-cases.
…….a) Node’s key is smaller than the min value.
…….b) Node’s key is greater that the max value.
2) Node’s key is in range.

We don’t need to do anything for case 2.
In case 1, we need to remove the node and change root of sub-tree rooted with this node.
The idea is to fix the tree in Postorder fashion. When we visit a node,
we make sure that its left and right sub-trees are already fixed.
In case 1.a), we simply remove root and return right sub-tree as new root.
In case 1.b), we remove root and return left sub-tree as new root.

https://www.geeksforgeeks.org/remove-bst-keys-outside-the-given-range/
 */

package DataStructures.BinarySearchTree.CheckingAndPrinting;

import Commons.BinarySearchTree;
import Commons.Node;
import DataStructures.BinaryTree.Traversals.TreeTraversalBasics;

public class FixBST {
	private static Node fixBST(Node root, int min, int max) {
		if (root == null) {
			return null;
		}

		root.left = fixBST(root.left, min, max);
		root.right = fixBST(root.right, min, max);

		if (root.val < min) {
			root = root.right;
		}

		if (root.val > max) {
			root = root.left;
		}

		return root;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		Node root = bst.insert(null, 6);
		bst.insert(root, -13);
		bst.insert(root, 14);
		bst.insert(root, -8);
		bst.insert(root, 15);
		bst.insert(root, 13);
		bst.insert(root, 7);

		TreeTraversalBasics.inOrder(root);
		System.out.println();
		int min = -10, max = 13;
		root = fixBST(root, min, max);
		TreeTraversalBasics.inOrder(root);
		System.out.println();
	}
}
