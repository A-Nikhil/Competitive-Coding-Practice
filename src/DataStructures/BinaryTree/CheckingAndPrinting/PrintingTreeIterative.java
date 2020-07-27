/*
Printing a tree using iteration

        6
     /    \
    3      5
  /   \     \
 2     5     4
     /   \
    7     4

There are 4 leaves, hence 4 root to leaf paths -
  6->3->2
  6->3->5->7
  6->3->5->4
  6->5>4

We can traverse tree iteratively (we have used iterative preorder).
The question is, how to extend the traversal to print root to leaf paths?
The idea is to maintain a map to store parent pointers of binary tree nodes.
Now whenever we encounter a leaf node while doing iterative preorder traversal,
we can easily print root to leaf path using parent pointer.

https://www.geeksforgeeks.org/print-root-leaf-path-without-using-recursion/
 */

package DataStructures.BinaryTree.CheckingAndPrinting;

import Commons.Node;

import java.util.HashMap;
import java.util.Stack;

public class PrintingTreeIterative {
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(2);

		printPaths(root);
	}

	private static void printPaths(Node root) {
		Stack<Node> stack = new Stack<>();
		HashMap<Node, Node> parent = new HashMap<>();
		stack.push(root);
		parent.put(root, null);

		/* Pop all items one by one. Do following for
        every popped item
            a) push its right child and set its parent
            pointer
            b) push its left child and set its parent
            pointer
        Note that right child is pushed first so that
        left is processed first */
		while (!stack.isEmpty()) {
			root = stack.pop();
			if (root.left == null && root.right == null) {
				printTopToBottomPath(root, parent);
			}

			if (root.right != null) {
				stack.push(root.right);
				parent.put(root.right, root);
			}

			if (root.left != null) {
				stack.push(root.left);
				parent.put(root.left, root);
			}
		}
	}

	private static void printTopToBottomPath(Node root, HashMap<Node, Node> parent) {
		Stack<Node> stack = new Stack<>();
		while (root != null) {
			// Push leaf node
			stack.push(root);
			// Iterate upwards
			root = parent.get(root);
		}

		while (!stack.isEmpty()) {
			root = stack.pop();
			System.out.print(root.val + " => ");
		}
		System.out.println();
	}
}
