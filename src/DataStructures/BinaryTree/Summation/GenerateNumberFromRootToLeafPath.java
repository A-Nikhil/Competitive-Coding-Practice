/*
Sum of all the numbers that are formed from root to leaf paths
Given a binary tree, where every node value is a Digit from 1-9.
Find the sum of all the numbers which are formed from root to leaf paths.
For example consider the following Binary Tree.

           6
       /      \
     3          5
   /   \          \
  2     5          4
      /   \
     7     4
  There are 4 leaves, hence 4 root to leaf paths:
   Path                    Number
  6->3->2                   632
  6->3->5->7               6357
  6->3->5->4               6354
  6->5>4                    654
Answer = 632 + 6357 + 6354 + 654 = 13997
The idea is to do a preorder traversal of the tree.
In the preorder traversal, keep track of the value calculated till the current node,
let this value be val. For every node, we update the val as val*10 plus node’s data.

https://www.geeksforgeeks.org/sum-numbers-formed-root-leaf-paths/
 */

package DataStructures.BinaryTree.Summation;

import Commons.Node;

import java.util.ArrayList;

public class GenerateNumberFromRootToLeafPath {
	private static ArrayList<Integer> numbers;

	private static void preorderTraversal(Node root, int val) {
		if (root == null) {
			return;
		}

		// if leaf, add number generated to list
		if (root.left == null && root.right == null) {
			numbers.add(val * 10 + root.val);
		}

		preorderTraversal(root.left, val * 10 + root.val);
		preorderTraversal(root.right, val * 10 + root.val);
	}

	private static int getSum(Node root) {
		numbers = new ArrayList<>();
		preorderTraversal(root, 0);
		int sum = 0;
		for (int i : numbers) {
			System.out.println(i);
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		Node root;
		root = new Node(6);
		root.left = new Node(3);
		root.right = new Node(5);
		root.right.right = new Node(4);
		root.left.left = new Node(2);
		root.left.right = new Node(5);
		root.left.right.right = new Node(4);
		root.left.right.left = new Node(7);
		System.out.println(getSum(root));
	}
}
