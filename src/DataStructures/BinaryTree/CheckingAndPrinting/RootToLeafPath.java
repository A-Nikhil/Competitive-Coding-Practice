/*
Given a binary tree, print out all of its root-to-leaf paths one per line.

Approach =>
initialize: pathlen = 0, path[1000]
1000 is some max limit for paths, it can change

printPathsRecur traverses nodes of tree in preorder
printPathsRecur(tree, path[], pathlen)
		1) If node is not NULL then
			a) push data to path array:
				path[pathlen] = node->data.
			b) increment pathlen
				pathlen++
		2) If node is a leaf node then print the path array.
		3) Else
			a) Call printPathsRecur for left subtree
				printPathsRecur(node->left, path, pathLen)
			b) Call printPathsRecur for right subtree.
				printPathsRecur(node->right, path, pathLen)
*/

package DataStructures.BinaryTree.CheckingAndPrinting;

import Commons.Node;

public class RootToLeafPath {
	private static void printPaths(Node root, int[] path, int pathLength) {
		if (root == null) {
			return;
		}
		path[pathLength] = root.val;
		pathLength++;
		if (root.left == null && root.right == null) {
			for (int i = 0; i < pathLength; i++) {
				System.out.print(path[i] + " => ");
			}
			System.out.println();
		} else {
			printPaths(root.left, path, pathLength);
			printPaths(root.right, path, pathLength);
		}
	}

	public static void main(String[] args) {
		Node root;
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		int[] paths = new int[100];
		printPaths(root, paths, 0);
	}
}
