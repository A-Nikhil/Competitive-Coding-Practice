/*
K’th Largest Element in BST when modification to BST is not allowed

In this post, a method is discussed that takes O(h + k) time.
This method doesn’t require any change to BST.
h => height of the tree, k => kth element

The idea is to do reverse inorder traversal of BST.
The reverse inorder traversal traverses all nodes in decreasing order.
While doing the traversal, we keep track of count of nodes visited so far.
When the count becomes equal to k, we stop the traversal and print the key.

https://www.geeksforgeeks.org/kth-largest-element-in-bst-when-modification-to-bst-is-not-allowed/
*/
package DataStructures.BinarySearchTree.CheckingAndPrinting;

import Commons.BinarySearchTree;
import Commons.Node;

public class KthSmallestElement {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		Node root = bst.insert(null, 50);
		bst.insert(root, 30);
		bst.insert(root, 20);
		bst.insert(root, 40);
		bst.insert(root, 70);
		bst.insert(root, 60);
		bst.insert(root, 80);

		for (int k = 1; k <= 7; k++)
			System.out.print(kthSmallest(root, k) + " ");
	}

	private static int kthSmallest(Node root, int k) {
		int kSmall = 0, count = 0;
		Node pre, current = root;
		while (current != null) {
			if (current.left == null) {
				count++;
				if (count == k) {
					kSmall = current.val;
				}
				current = current.right;
			} else {
				pre = current.left;
				while (pre.right != null && pre.right != current) {
					pre = pre.right;
				}

				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				} else {
					pre.right = null;
					count++;
					if (count == k) {
						kSmall = current.val;
					}
					current = current.right;
				}
			}
		}
		return kSmall;
	}
}
