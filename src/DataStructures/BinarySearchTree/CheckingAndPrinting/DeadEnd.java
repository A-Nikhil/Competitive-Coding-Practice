/*
Simple Recursive solution to check whether BST contains dead end
Given a Binary Search Tree that contains positive integer values greater than 0.
The task is to check whether the BST contains a dead end or not.
Here Dead End means, we are not able to insert any integer element after that node.

Examples:

Input :        8
             /   \
           5      9
         /   \
        2     7
       /
      1
Output : Yes
Explanation : Node "1" is the dead End because
         after that we cant insert any element.

Input :       8
            /   \
           7     10
         /      /   \
        2      9     13

Output :Yes
Explanation : We can't insert any element at
              node 9.

First of all, it is given that it is a BST and nodes are greater than zero, root node can be
in the range [1, ∞] and if root val is say, val, then left sub-tree can have the value in the
range [1, val-1] and right sub-tree the value in range [val+1, ∞].
we need to traverse recursively and when the the min and max value of range coincided
it means that we cannot add any node further in the tree.
Hence we encounter a dead end.

https://www.geeksforgeeks.org/simple-recursive-solution-check-whether-bst-contains-dead-end/
 */

package DataStructures.BinarySearchTree.CheckingAndPrinting;

import Commons.BinarySearchTree;
import Commons.Node;

public class DeadEnd {
	private static boolean deadEndExists(Node root, int min, int max) {
		if (root == null) {
			return false;
		}

		if (min == max) {
			return true;
		}

		return deadEndExists(root.left, min, root.val - 1)
				|| deadEndExists(root.right, root.val + 1, max);
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		Node root;

        /*       8
               /   \
              5    11
             /  \
            2    7
             \
              3
               \
                4 */
		root = tree.insert(null, 8);
		tree.insert(root, 5);
		tree.insert(root, 2);
		tree.insert(root, 3);
		tree.insert(root, 7);
		tree.insert(root, 11);
		tree.insert(root, 4);
		System.out.println(deadEndExists(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
}
