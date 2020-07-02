/*
Find postorder traversal of BST from preorder traversal

An efficient approach is to find postorder traversal without constructing the tree.
The idea is to traverse the given preorder array and maintain a range in which current element should lie.
This is to ensure that BST property is always satisfied. Initially the range is set to
{minval = INT_MIN, maxval = INT_MAX}. In preorder traversal, the first element is always the
root and it will certainly lie in initial range. So store the first element of the preorder array.
In postorder traversal, first left and right subtrees are printed and then root data is printed.
So first recursive call for left and right subtrees are performed and then the value of root is printed.
For left subtree range is updated to {minval, root->data} and for right subtree range is updated to
{root->data, maxval}. If current preorder array element does not lie in the range specified for it,
then it does not belong to a current subtree, return from recursive calls until correct position of
that element is not found.

https://www.geeksforgeeks.org/find-postorder-traversal-of-bst-from-preorder-traversal/
 */

package DataStructures.BinaryTree.Traversals;

public class PostorderFromPreorderBST {
	private static void postOrder(int[] preorder, int n, int min, int max, int preIndex) {
		if (preorder[preIndex] == n) {
			return;
		}
		if (preorder[preIndex] < min || preorder[preIndex] > max) {
			return;
		}
		int val = preorder[preIndex++];
		postOrder(preorder, n, min, val, preIndex);
		postOrder(preorder, n, val, max, preIndex);
		System.out.println(val + " ");
	}

	public static void main(String[] args) {
		int[] pre = {40, 30, 35, 80, 100};
		int n = pre.length;
		postOrder(pre, n, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
	}
}
