/*
Subtree with given sum in a Binary Tree
You are given a binary tree and a given sum.
The task is to check if there exist a subtree whose sum of all nodes is equal to the given sum.

The idea is to traverse tree in Postorder fashion because here we have to think bottom-up.
First calculate the sum of left subtree then right subtree and check
if sum_left + sum_right + cur_node = sum is satisfying the condition that means any subtree
with given sum exist. Below is the recursive implementation of algorithm.

https://www.geeksforgeeks.org/subtree-given-sum-binary-tree/
 */

package DataStructures.BinaryTree.Summation;

import Commons.GlobalVar;
import Commons.Node;

public class SubTreeWithGivenSum {
	private static boolean check(Node root, GlobalVar currentSum, int x) {
		if (root == null) {
			return true;
		}
		GlobalVar sumLeft = new GlobalVar(0),
				sumRight = new GlobalVar(0);

		currentSum.var = sumLeft.var + sumRight.var + root.val;

		return (check(root.left, sumLeft, x) ||
				check(root.right, sumRight, x) ||
				((currentSum.var) == x));
	}

	@SuppressWarnings("Duplicates")
	public static void main(String[] args) {
		Node root = new Node(8);
		root.left = new Node(5);
		root.right = new Node(4);
		root.left.left = new Node(9);
		root.left.right = new Node(7);
		root.left.right.left = new Node(1);
		root.left.right.right = new Node(12);
		root.left.right.right.right = new Node(2);
		root.right.right = new Node(11);
		root.right.right.left = new Node(3);
		int sum = 22;
		GlobalVar currentSum = new GlobalVar(0);
		System.out.println(check(root, currentSum, sum));
	}
}
