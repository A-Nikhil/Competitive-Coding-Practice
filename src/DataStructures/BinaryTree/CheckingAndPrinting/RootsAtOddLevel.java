/*
Print the nodes at odd levels of a tree

For example consider the following tree
          1
       /     \
      2       3
    /   \       \
   4     5       6
        /  \     /
       7    8   9

Output  1 4 5 6

 */

package DataStructures.BinaryTree.CheckingAndPrinting;

import Commons.Node;

@SuppressWarnings("Duplicates")
public class RootsAtOddLevel {
	private static void nodePrinter(Node root, boolean isOdd) {
		if (root == null) {
			return;
		}
		if (isOdd) {
			System.out.print(root.val + " ");
		}
		if (root.left != null) {
			nodePrinter(root.left, !isOdd);
		}
		if (root.right != null) {
			nodePrinter(root.right, !isOdd);
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		nodePrinter(root, true);
	}
}
