/*
Count subtrees that sum up to a given value x only using single recursive function

Given a binary tree containing n nodes. The problem is to count subtrees having
total node’s data sum equal to a given value using only single recursive function x.

Examples:

Input :
             5
           /   \
        -10     3
        /  \   /  \
       9    8 -4   7

       x = 7

Output : 2
There are 2 subtrees with sum 7.

1st one is leaf node:
7.

2nd one is:

      -10
     /   \
    9     8

Approach:

countSubtreesWithSumX(root, count, x)
    if !root then
        return 0

    ls = countSubtreesWithSumX(root->left, count, x)
    rs = countSubtreesWithSumX(root->right, count, x)
    sum = ls + rs + root->data

    if sum == x then
    count++
    return sum

countSubtreesWithSumXUtil(root, x)
    if !root then
        return 0

    Initialize count = 0
    ls = countSubtreesWithSumX(root->left, count, x)
    rs = countSubtreesWithSumX(root->right, count, x)

    if (ls + rs + root->data) == x
        count++
    return count

https://www.geeksforgeeks.org/count-subtress-sum-given-value-x/
 */

package DataStructures.BinaryTree.Summation;

import Commons.Node;

public class SubTreesWithSumX {
	private static int count;

	private static int utilFunction(Node root, int x) {
		if (root == null) {
			return 0;
		}

		int ls = utilFunction(root.left, x),
				rs = utilFunction(root.right, x);
		int sum = ls + rs + root.val;
		if (sum == x) {
			count++;
		}

		return sum;
	}

	private static int findCount(Node root, int x) {
		if (root == null) {
			return 0;
		}

		count = 0;
		int ls = utilFunction(root.left, x),
				rs = utilFunction(root.right, x);


		if ((ls + rs + root.val) == x) {
			count++;
		}

		return count;
	}

	public static void main(String[] args) {
		 /* binary tree creation
           5
          / \
        -10  3
        / \ / \
        9 8 -4 7
    */
		Node root = new Node(5);
		root.left = new Node(-10);
		root.right = new Node(3);
		root.left.left = new Node(9);
		root.left.right = new Node(8);
		root.right.left = new Node(-4);
		root.right.right = new Node(7);

		int x = 7;

		System.out.println(findCount(root, x));
	}
}
