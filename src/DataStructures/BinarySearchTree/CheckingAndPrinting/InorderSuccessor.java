/*
Inorder Successor in Binary Search Tree

If right subtree of node is not NULL, then succ lies in right subtree. Do the following.
Go to right subtree and return the node with minimum key value in the right subtree.
If right subtree of node is NULL, then start from the root and use search like technique.
Do the following.
Travel down the tree, if a node’s data is greater than root’s data then go right side,
otherwise, go to left side.

https://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
 */

package DataStructures.BinarySearchTree.CheckingAndPrinting;

import Commons.BinarySearchTree;
import Commons.Node;

public class InorderSuccessor {
	private static Node min;

	private static Node findSuccessor(Node node, Node element) {
		if (node == null) {
			return null;
		}

		if (element.right != null) {
			return findMinimum(node.right);
		}

		Node succ = null;
		while (node != null) {
			if (element.val < node.val) {
				succ = node;
				node = node.left;
			} else if (element.val > node.val) {
				node = node.right;
			} else {
				break;
			}
		}
		return succ;
	}

	private static Node findMinimum(Node node) {
		if (node == null) {
			return null;
		}
		if (min.val > node.val) {
			min = node;
		}
		findMinimum(node.left);
		findMinimum(node.right);
		return min;
	}

	@SuppressWarnings("Duplicates")
	public static void main(String[] args) {
		min = new Node(Integer.MAX_VALUE, null, null);
		BinarySearchTree tree = new BinarySearchTree();
		Node root = tree.insert(null, 20);
		tree.insert(root, 8);
		tree.insert(root, 22);
		tree.insert(root, 4);
		tree.insert(root, 12);
		tree.insert(root, 10);
		tree.insert(root, 14);
		Node n = root.left.right.right;
		System.out.println(findSuccessor(root, n).val);
	}
}
