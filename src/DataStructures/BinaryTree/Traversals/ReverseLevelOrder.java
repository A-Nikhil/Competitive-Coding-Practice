/*
The method 2 of normal level order traversal can also be easily modified to print level order traversal
in reverse order. The idea is to use a stack to get the reverse level order.
If we do normal level order traversal and instead of printing a node,
push the node to a stack and then print contents of stack, we get “5 4 3 2 1” for above example tree,
but output should be “4 5 2 3 1”. So to get the correct sequence (left to right at every level),
we process children of a node in reverse order, we first push the right subtree to stack, then left subtree.

https://www.geeksforgeeks.org/reverse-level-order-traversal/
 */

package DataStructures.BinaryTree.Traversals;

import Commons.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

@SuppressWarnings("Duplicates")
public class ReverseLevelOrder {
	public static void main(String[] args) {
		Node root;
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		System.out.println("Level order traversal of binary tree is - ");
		reverseLevelOrder(root);
	}

	private static void reverseLevelOrder(Node root) {
		Queue<Node> queue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		Node tempNode = root;
		queue.add(tempNode);
		while (!queue.isEmpty()) {
			tempNode = queue.poll();
			stack.add(tempNode.val);
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
}
