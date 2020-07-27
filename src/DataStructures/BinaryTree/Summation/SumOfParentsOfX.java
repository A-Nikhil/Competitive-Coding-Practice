/*
Sum of all the parent nodes having child node x
Given a binary tree containing n nodes. The problem is to find the sum of all the parent node’s
which have a child node with value x.

Examples:

Input : Binary tree with x = 2:
        5
       / \
      2   5
     / \ / \
    7  2 2  3
Output : 11

The highlighted nodes (4, 2, 5) above
are the nodes having 2 as a child node.

Approach =>
sumOfParentOfX(root,sum,x)
    if root == NULL
        return

    if (root->left && root->left->data == x) ||
       (root->right && root->right->data == x)
        sum += root->data

    sumOfParentOfX(root->left, sum, x)
    sumOfParentOfX(root->right, sum, x)

sumOfParentOfXUtil(root,x)
    Declare sum = 0
    sumOfParentOfX(root, sum, x)
    return sum

https://www.geeksforgeeks.org/sum-parent-nodes-child-node-x/
 */
package DataStructures.BinaryTree.Summation;

import Commons.Node;

public class SumOfParentsOfX {
	private static int sum;

	private static void sumOfParentsX(Node root, int x) {
		if (root == null) {
			return;
		}

		if ((root.left != null && root.left.val == x) ||
				(root.right != null && root.right.val == x)) {
			sum += root.val;
		}

		sumOfParentsX(root.left, x);
		sumOfParentsX(root.right, x);
	}

	public static void main(String[] args) {
		sum = 0;
		Node root = new Node(5);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(7);
		root.left.right = new Node(2);
		root.right.left = new Node(2);
		root.right.right = new Node(3);

		int x = 2;
		sumOfParentsX(root, x);
		System.out.println(sum);
	}
}
