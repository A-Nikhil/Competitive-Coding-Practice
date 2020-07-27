/*
Morris Traversal

Using Morris Traversal, we can traverse the tree without using stack and recursion.
The idea of Morris Traversal is based on Threaded Binary Tree.
In this traversal, we first create links to Inorder successor and print the data using these links,
and finally revert the changes to restore original tree.

1. Initialize current as root
2. While current is not NULL
   If the current does not have left child
      a) Print current’s data
      b) Go to the right, i.e., current = current->right
   Else
      a) Make current as the right child of the rightmost
         node in current's left subtree
      b) Go to this left child, i.e., current = current->left

https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
 */

package DataStructures.BinaryTree.Traversals;

import Commons.Node;

public class MorrisTraversal {
	@SuppressWarnings("Duplicates")
	public static void main(String[] args) {
		Node root;
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		morrisTraversal(root);
	}

	private static void morrisTraversal(Node root) {
		Node current, temp;
		current = root;
		while (current != null) {
			if (current.left == null) {
				System.out.print(current.val + " ");
				current = current.right;
			} else {
				temp = current.left;
				/* Find the inorder predecessor of current */
				while (temp.right != null && temp.right != current) {
					temp = temp.right;
				}

				/* Make current as right child of its inorder predecessor */
				if (temp.right == null) {
					temp.right = current;
					current = current.left;
				} else {
					/* Revert the changes made in the 'if' part to restore the
                    original tree i.e., fix the right child of predecessor*/
					temp.right = null;
					System.out.print(current.val + " ");
					current = current.right;
				}
			}
		}
	}
}
