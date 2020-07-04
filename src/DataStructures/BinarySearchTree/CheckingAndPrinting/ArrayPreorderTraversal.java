/*
Check if a given array can represent Preorder Traversal of Binary Search Tree

Given an array of numbers, return true if given array can represent preorder traversal
of a Binary Search Tree, else return false. Expected time complexity is O(n).

Examples:

Input:  pre[] = {2, 4, 3}
Output: true
Given array can represent preorder traversal
of below tree
    2
     \
      4
     /
    3

Input:  pre[] = {2, 4, 1}
Output: false
Given array cannot represent preorder traversal
of a Binary Search Tree.

Input:  pre[] = {40, 30, 35, 80, 100}
Output: true
Given array can represent preorder traversal
of below tree
     40
   /   \
 30    80
  \      \
  35     100


Input:  pre[] = {40, 30, 35, 20, 80, 100}
Output: false
Given array cannot represent preorder traversal
of a Binary Search Tree.

Approach =>
An Efficient Solution can solve this problem in O(n) time. The idea is to use a stack.
This problem is similar to Next (or closest) Greater Element problem.
Here we find the next greater element and after finding next greater,
if we find a smaller element, then return false.

1) Create an empty stack.
2) Initialize root as INT_MIN.
3) Do following for every element pre[i]
     a) If pre[i] is smaller than current root, return false.
     b) Keep removing elements from stack while pre[i] is greater
        then stack top. Make the last removed item as new root (to
        be compared next).
        At this point, pre[i] is greater than the removed root
        (That is why if we see a smaller element in step a), we
        return false)
     c) push pre[i] to stack (All elements in stack are in decreasing
        order)


https://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree/
 */

package DataStructures.BinarySearchTree.CheckingAndPrinting;

import java.util.Stack;

public class ArrayPreorderTraversal {
	public static void main(String[] args) {
		int[] pre1 = {2, 4, 3};
		int[] pre2 = {2, 4, 1};
		int[] pre3 = {40, 30, 35, 80, 100};
		int[] pre4 = {40, 30, 35, 20, 80, 100};
		System.out.println(checkIfPreorder(pre1, pre1.length));
		System.out.println(checkIfPreorder(pre2, pre2.length));
		System.out.println(checkIfPreorder(pre3, pre3.length));
		System.out.println(checkIfPreorder(pre4, pre4.length));
	}

	private static boolean checkIfPreorder(int[] preorder, int n) {
		Stack<Integer> stack = new Stack<>();
		int root = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (preorder[i] < root) {
				return false;
			}

			while (!stack.isEmpty() && preorder[i] > stack.peek()) {
				root = stack.pop();
			}
			stack.push(preorder[i]);
		}
		return true;
	}
}
