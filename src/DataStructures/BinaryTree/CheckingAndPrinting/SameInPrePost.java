/*
Check if given Preorder, Inorder and Postorder traversals are of same tree

The most basic approach to solve this problem will be to first construct a tree using two of
the three given traversals and then do the third traversal on this constructed tree and compare it
with the given traversal. If both of the traversals are same then print Yes otherwise print No.
Here, we use Inorder and Preorder traversals to construct the tree.

Input : Inorder -> 4 2 5 1 3
        Preorder -> 1 2 4 5 3
        Postorder -> 4 5 2 3 1
Output : Yes
Explanation : All of the above three traversals are of
the same tree
						   1
                         /   \
                        2     3
                      /   \
                     4     5

https://www.geeksforgeeks.org/check-if-given-preorder-inorder-and-postorder-traversals-are-of-same-tree/
 */

package DataStructures.BinaryTree.CheckingAndPrinting;

public class SameInPrePost {
	private static int preIndex = 0, postIndex = 0;
	private static int[] tempPostorder;

	private static void createPostOrder(int[] inorder, int[] preorder,
										int inStart, int inEnd) {
		if (inStart > inEnd) {
			return;
		}
		int index = search(inorder, preorder[preIndex++], inStart, inEnd);

		createPostOrder(inorder, preorder, inStart, index - 1);
		createPostOrder(inorder, preorder, index + 1, inEnd);
		tempPostorder[postIndex] = inorder[index];
		postIndex++;
	}

	private static boolean isSame(int[] inorder, int[] preorder, int[] postorder) {
		int V = inorder.length;
		tempPostorder = new int[V];
		createPostOrder(inorder, preorder, 0, V - 1);
		for (int i = 0; i < V; i++) {
			if (postorder[i] != tempPostorder[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] inOrder = {4, 2, 5, 1, 3};
		int[] preOrder = {1, 2, 4, 5, 3};
		int[] postOrder = {4, 5, 2, 3, 1};
		System.out.println(isSame(inOrder, preOrder, postOrder));
	}

	private static int search(int[] inorder, int data, int start, int end) {
		int pos;
		for (pos = start; pos < end; pos++) {
			if (data == inorder[pos]) {
				return pos;
			}
		}
		return pos;
	}
}
