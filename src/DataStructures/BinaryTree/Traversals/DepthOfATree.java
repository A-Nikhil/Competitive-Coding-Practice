/*
Calculate depth of a full Binary tree from Preorder
Given preorder of a binary tree, calculate its depth(or height) [starting from depth 0].
The preorder is given as a string with two possible characters.

‘l’ denotes the leaf
‘n’ denotes internal node
The given tree can be seen as a full binary tree where every node has 0 or two children.
The two children of a node can ‘n’ or ‘l’ or mix of both.

Input  : nlnll
Output : 2
			  n
            /   \
           l     n
			   /   \
			  l     l

The recursion function would be:
1) Base Case: return 0; when tree[i] = ‘l’ or i >= strlen(tree)
2) find_depth( tree[i++] ) //left subtree
3) find_depth( tree[i++] ) //right subtree

Where i is the index of the string tree.

https://www.geeksforgeeks.org/calculate-depth-full-binary-tree-preorder/
 */

package DataStructures.BinaryTree.Traversals;

public class DepthOfATree {
	private static int findDepth(String tree, int index) {
		if (index >= tree.length() || tree.charAt(index) == 'l') {
			return 0;
		}
		index++;
		int left = findDepth(tree, index);
		index++;
		int right = findDepth(tree, index);
		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		String tree = "nlnnlll";
		System.out.println(findDepth(tree, 0));
	}
}
