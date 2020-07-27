/*
Replace every element with the least greater element on its right
Given an array of integers, replace every element with the least greater element on its
right side in the array. If there are no greater element on right side, replace it with -1.

Examples:

Input: [8, 58, 71, 18, 31, 32, 63, 92,
         43, 3, 91, 93, 25, 80, 28]
Output: [18, 63, 80, 25, 32, 43, 80, 93,
         80, 25, 93, -1, 28, -1, -1]

A tricky solution would be to use Binary Search Trees.
We start scanning the array from right to left and insert each element into the BST.
For each inserted element, we replace it in the array by its inorder successor in BST.
If the element inserted is the maximum so far (i.e. its inorder successor doesn’t exists),
we replace it by -1.
 */

package DataStructures.BinarySearchTree.CheckingAndPrinting;

import Commons.ArrayPrinter;
import Commons.BinarySearchTree;
import Commons.Node;

import java.util.ArrayList;

public class ReplaceWithLeastGreatestOnRight {
	private static ArrayList<Integer> list;

	private static void inorder(Node root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		list.add(root.val);
		inorder(root.right);
	}

	private static int[] replace(int[] arr, int n) {
		BinarySearchTree tree = new BinarySearchTree();
		int[] newArray = new int[n];
		Node root = null;
		int index;
		for (int i = 0; i < n; i++) {
			tree.insert(root, arr[i]);
			list = new ArrayList<>();
			inorder(root);
			index = list.indexOf(arr[i]);
			if (index < list.size() - 1) {
				newArray[i] = list.get(index + 1);
			} else {
				newArray[i] = -1;
			}
		}

		return newArray;
	}

	public static void main(String[] args) {
		int[] arr = {8, 58, 71, 18, 31, 32, 63, 92,
				43, 3, 91, 93, 25, 80, 28};
		new ArrayPrinter().printArray(arr, arr.length);
		System.out.println("\nAfter => ");
		new ArrayPrinter().printArray(replace(arr, arr.length), arr.length);
	}
}
