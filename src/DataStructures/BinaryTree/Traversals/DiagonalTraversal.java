/*
Diagonal Traversal of Tree

https://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/
 */

package DataStructures.BinaryTree.Traversals;

import Commons.Node;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class DiagonalTraversal {
	private static TreeMap<Integer, ArrayList<Integer>> traversal;

	private static void diagonalTraverse(Node root, int slope) {
		if (root == null) {
			return;
		}

		// Check if a arraylist exists at a particular slope
		if (traversal.containsKey(slope)) {
			traversal.get(slope).add(root.val);
		} else {
			// if does not exist, create one
			traversal.put(slope, new ArrayList<>());
			if (!traversal.get(slope).contains(root.val)) {
				traversal.get(slope).add(root.val);
			}
		}

		// traverse right with same slope
		diagonalTraverse(root.right, slope);
		// traverse left with slope+1
		diagonalTraverse(root.left, slope + 1);
	}

	private static void printDiagonal(Node root) {
		traversal = new TreeMap<>();
		diagonalTraverse(root, 1);
		for (Map.Entry<Integer, ArrayList<Integer>> entry : traversal.entrySet()) {
			for (int i : entry.getValue()) {
				System.out.print(i + " => ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Node root = new Node(8);
		root.left = new Node(3);
		root.right = new Node(10);
		root.left.left = new Node(1);
		root.left.right = new Node(6);
		root.right.right = new Node(14);
		root.right.right.left = new Node(13);
		root.left.right.left = new Node(4);
		root.left.right.right = new Node(7);
		printDiagonal(root);
	}
}
