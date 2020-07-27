/*
Input :  K = 3
              8
            /   \
           7     10
         /      /   \
        2      9     13
Output : 17
Explanation : Kth smallest element is 8 so sum of all
              element smaller then or equal to 8 are
              2 + 7 + 8

Approach =>
The idea is to traverse BST in inorder traversal.
Note that Inorder traversal of BST accesses elements in sorted (or increasing) order.
While traversing, we keep track of count of visited Nodes and keep adding Nodes
until the count becomes k.
 */

package DataStructures.BinarySearchTree.CheckingAndPrinting;

import Commons.BinarySearchTree;
import Commons.Node;

import java.util.ArrayList;

@SuppressWarnings("Duplicates")
public class SumOfKSmallestElements {
	private static ArrayList<Integer> list;

	public static void main(String[] args) {
		/*    20
			/    \
		   8     22
		 /   \
		4     12
			 /   \
			10    14
          */
		BinarySearchTree bst = new BinarySearchTree();
		Node root = bst.insert(null, 20);
		bst.insert(root, 8);
		bst.insert(root, 4);
		bst.insert(root, 12);
		bst.insert(root, 10);
		bst.insert(root, 14);
		bst.insert(root, 22);
		int k = 3;
		list = new ArrayList<>();
		inorderTraversal(root);
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += list.get(i);
		}
		System.out.println(sum);
	}

	private static void inorderTraversal(Node root) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left);
		list.add(root.val);
		inorderTraversal(root.right);
	}
}
