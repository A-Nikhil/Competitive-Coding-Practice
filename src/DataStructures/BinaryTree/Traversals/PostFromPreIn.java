/*
Print Post order traversal from given Inorder and Preorder traversals
Given Inorder and Preorder traversals of a binary tree, print Post order traversal.

We can print postorder traversal without constructing the tree.
The idea is, root is always the first item in preorder traversal and it must be the last item
in postorder traversal. We first recursively print left subtree, then recursively print right subtree.
Finally, print root. To find boundaries of left and right subtrees in pre[] and in[],
we search root in in[], all elements before root in in[] are elements of left subtree and all
elements after root are elements of right subtree. In pre[], all elements after index of root
in in[] are elements of right subtree. And elements before index (including the element at index
and excluding the first element) are elements of left subtree.

 */

package DataStructures.BinaryTree.Traversals;

public class PostFromPreIn {
	private static int preIndex = 0;

	private static void printPost(int[] inorder, int[] preorder, int inStart, int inEnd) {
		if (inStart > inEnd) {
			return;
		}
		int index = search(inorder, preorder[preIndex++], inStart, inEnd);

		printPost(inorder, preorder, inStart, index - 1);
		printPost(inorder, preorder, index + 1, inEnd);
		System.out.print(inorder[index] + " ");
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

	public static void main(String[] args) {
		int[] in = {4, 2, 5, 1, 3, 6};
		int[] pre = {1, 2, 4, 5, 3, 6};
		int len = in.length;
		printPost(in, pre, 0, len - 1);
	}
}
