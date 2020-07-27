/*
Check if given sorted sub-sequence exists in binary search tree

An efficient solution is to match elements of sub-sequence while we are traversing BST
in inorder fashion. We take index as a iterator for given sorted sub-sequence and
start inorder traversal of given bst, if current node matches with seq[index]
then move index in forward direction by incrementing 1 and after complete traversal of BST
if index==n that means all elements of given sub-sequence have been matched and exist as a
sorted sub-sequence in given BST.

https://www.geeksforgeeks.org/check-if-given-sorted-sub-sequence-exists-in-binary-search-tree/
 */

package DataStructures.BinarySearchTree.CheckingAndPrinting;

import Commons.BinarySearchTree;
import Commons.GlobalVar;
import Commons.Node;

public class SortedSubsequenceExists {
	private static void traverseAndCheck(Node root, int[] arr, GlobalVar index) {
		if (root == null) {
			return;
		}
		traverseAndCheck(root.left, arr, index);
		if (root.val == arr[index.var]) {
			index.var++;
		}
		traverseAndCheck(root.right, arr, index);
	}

	private static boolean subsequenceExists(Node root, int[] arr, int n) {
		GlobalVar index = new GlobalVar(0);
		traverseAndCheck(root, arr, index);
		return index.var == n;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		Node root;
		root = bst.insert(null, 8);
		bst.insert(root, 10);
		bst.insert(root, 3);
		bst.insert(root, 6);
		bst.insert(root, 1);
		bst.insert(root, 4);
		bst.insert(root, 7);
		bst.insert(root, 14);
		bst.insert(root, 13);

		int[] seq1 = {4, 6, 8, 14};
		int[] seq2 = {4, 6, 8, 12, 13};

		System.out.println(subsequenceExists(root, seq1, seq1.length));
		System.out.println(subsequenceExists(root, seq2, seq2.length));
	}
}
