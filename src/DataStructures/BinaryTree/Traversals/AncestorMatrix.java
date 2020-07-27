/*
Construct Ancestor Matrix from a Given Binary Tree

Given a Binary Tree where all values are from 0 to n-1.
Construct an ancestor matrix mat[n][n]. Ancestor matrix is defined as below.
mat[i][j] = 1 if i is ancestor of j
mat[i][j] = 0, otherwise

Input: Root of below Binary Tree.
           5
        /    \
       1      2
      /  \    /
     0    4  3
Output: 0 0 0 0 0 0
        1 0 0 0 1 0
        0 0 0 1 0 0
        0 0 0 0 0 0
        0 0 0 0 0 0
        1 1 1 1 1 0

https://www.geeksforgeeks.org/construct-ancestor-matrix-from-a-given-binary-tree/
 */

package DataStructures.BinaryTree.Traversals;

import Commons.Node;

public class AncestorMatrix {
	private static void ancestorMatrix(Node root, int[][] matrix, int size) {
		if (root == null) {
			return;
		}
		ancestorMatrix(root.left, matrix, size);
		ancestorMatrix(root.right, matrix, size);

		if (root.left != null) {
			matrix[root.val][root.left.val] = 1;

			// iterate through all the columns of children node
			// all nodes which are children to
			// children of root node will also
			// be children of root node
			for (int i = 0; i < size; i++) {
				if (matrix[root.left.val][i] == 1) {
					matrix[root.val][i] = 1;
				}
			}
		}

		// same procedure followed for right node as well
		if (root.right != null) {
			matrix[root.val][root.right.val] = 1;

			for (int i = 0; i < size; i++) {
				if (matrix[root.right.val][i] == 1)
					matrix[root.val][i] = 1;
			}
		}
	}

	public static void main(String[] args) {
		Node tree_root = new Node(5);
		tree_root.left = new Node(1);
		tree_root.right = new Node(2);
		tree_root.left.left = new Node(0);
		tree_root.left.right = new Node(4);
		tree_root.right.left = new Node(3);

		// size of matrix
		int size = 6;
		int[][] matrix = new int[size][size];

		ancestorMatrix(tree_root, matrix, size);

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
