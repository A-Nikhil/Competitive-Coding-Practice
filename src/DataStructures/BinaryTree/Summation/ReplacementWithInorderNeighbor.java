/*
Replace each node in binary tree with the sum of its inorder predecessor and successor
Given a binary tree containing n nodes.
The problem is to replace each node in the binary tree with the sum of its
inorder predecessor and inorder successor.

Examples:

Input :          1
               /   \
              2     3
            /  \  /  \
           4   5  6   7

Output :        11
              /    \
             9      13
            / \    /  \
           2   3   4   3

For 1:
Inorder predecessor = 5
Inorder successor  = 6
Sum = 11

For 4:
Inorder predecessor = 0
(as inorder predecessor is not present)
Inorder successor  = 2
Sum = 2

For 7:
Inorder predecessor = 3
Inorder successor  = 0
(as inorder successor is not present)
Sum = 3

Approach:
Create an array arr. Store 0 at index 0.
Now, store the inorder traversal of tree in the array arr.
Then, store 0 at last index. 0’s are stored as inorder predecessor of leftmost leaf and
inorder successor of rightmost leaf is not present. Now, perform inorder traversal and
while traversing node replace node’s value with arr[i-1] + arr[i+1] and then increment i.
In the beginning initialize i = 1. For an element arr[i], the values arr[i-1] and arr[i+1]
are its inorder predecessor and inorder successor respectively.
 */

package DataStructures.BinaryTree.Summation;

import Commons.ArrayPrinter;
import Commons.Node;

public class ReplacementWithInorderNeighbor {
	private static int[] arr;
	private static int i;

	private static void doInorder(Node root, boolean replace) {
		if (root == null) {
			return;
		}

		doInorder(root.left, replace);
		if (replace) {
			root.val = arr[i - 1] + arr[i + 1];
		} else {
			arr[i] = root.val;
		}
		i++;
		doInorder(root.right, replace);
	}

	@SuppressWarnings("Duplicates")
	public static void main(String[] args) {
		Node root = new Node(1);       //         1
		root.left = new Node(2);        //      /   \
		root.right = new Node(3);       //     2     3
		root.left.left = new Node(4);  //    /  \  /   \
		root.left.right = new Node(5); //   4   5  6   7
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		arr = new int[100];
		arr[0] = 0;
		doInorder(root, false);
		arr[i] = 0;
		(new ArrayPrinter()).printArray(arr, i);
		System.out.println();
		i = 1;
		doInorder(root, true);
		i = 1;
		doInorder(root, false);
		(new ArrayPrinter()).printArray(arr, i);
	}
}
