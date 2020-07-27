/*
Print the longest leaf to leaf path in a Binary tree
The diameter of a tree (sometimes called the width) is the number of nodes on the longest path
between two end nodes. In this post, we will see how to print the nodes involved in the diameter
of the tree. The diagram below shows two trees each with diameter nine, the leaves that form the
ends of the longest path are shaded (note that there is more than one path in each tree of length
nine, but no path longer than nine nodes).

Input:      1
          /   \
        2      3
      /  \
    4     5

Output : 4 2 1 3
       or 5 2 1 3

Input:      1
          /   \
        2      3
      /  \      \
    4     5      6

Output : 4 2 1 3 6
       or 5 2 1 3 6

Approach =>
We know that Diameter of a tree can be calculated by only using the height function because the
diameter of a tree is nothing but the maximum value of (left_height + right_height + 1) for each node.
Now for the node which has the maximum value of (left_height + right_height + 1), we find the
longest root to leaf path on the left side and similarly on the right side. Finally, we print
left side path, root and right side path.
 */

package DataStructures.BinaryTree.CheckingAndPrinting;

import Commons.Node;

@SuppressWarnings("Duplicates")
public class PrintDiameter {
	private static int height;
	private static int pathLength;

	private static int getHeight(Node root) {
		if (root == null) {
			return 0;
		}
		int left = getHeight(root.left), right = getHeight(root.right);
		height = Math.max(height, 1 + left + right);
		return 1 + Math.max(left, right);
	}

	private static void printPath(Node root, int[] path, int f, int max) {
		if (root == null) {
			return;
		}

		path[pathLength] = root.val;
		pathLength++;

		if (root.left == null && root.right == null) {
			if (pathLength == max && (f == 0 || f == 1)) {
				printArray(path, pathLength, f);
				f = 2;
			}
		} else {
			printPath(root.left, path, f, max);
			printPath(root.right, path, f, max);
		}
	}

	private static void printArray(int[] path, int pathLength, int f) {
		int i;

		// Left path in reverse order
		if (f == 0) {
			for (i = pathLength - 1; i >= 0; i--) {
				System.out.print(path[i] + " => ");
			}
		}

		// right in straight order
		if (f == 1) {
			for (i = 0; i < pathLength; i++) {
				System.out.print(path[i] + " => ");
			}
		}
	}

	private static void printDiameter(Node root) {
		int[] path = new int[100];
		getHeight(root);
		pathLength = 0;
		printPath(root.left, path, 0, height);
		printPath(root.right, path, 1, height);
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(6);
		root.left.right.right = new Node(7);
		root.left.left.right = new Node(8);
		root.left.left.right.left = new Node(9);
		printDiameter(root);
	}
}
