/*
Check if all leaves are at same level

          12
        /    \
      5       7
    /          \
   3            1
  Leaves are at same level

          12
        /    \
      5       7
    /
   3
   Leaves are Not at same level


          12
        /
      5
    /   \
   3     9
  /      /
 1      2
 Leaves are at same level

Approach =>
	The idea is to first find level of the leftmost leaf and store it in a variable leafLevel. T
	hen compare level of all other leaves with leafLevel, if same, return true, else return false.
	We traverse the given Binary Tree in Preorder fashion. An argument leafLevel is passed to all calls.
	The value of leafLevel is initialized as 0 to indicate that the first leaf is not yet seen yet.
	The value is updated when we find first leaf.
	Level of subsequent leaves (in preorder) is compared with leafLevel.

https://www.geeksforgeeks.org/check-leaves-level/
 */

package DataStructures.BinaryTree.CheckingAndPrinting;

import Commons.Node;

@SuppressWarnings("Duplicates")
public class LeavesAtSameLevel {
	private static int leftLeafLevel(Node root) {
		if (root.left == null && root.right == null) {
			return 0;
		}
		if (root.left != null) {
			return 1 + leftLeafLevel(root.left);
		} else {
			return 0;
		}
	}

	private static boolean isLeaf(Node root) {
		if (root == null) {
			return false;
		}
		return root.left == null && root.right == null;
	}

	private static boolean checkSameLevel(Node root, int level, int currentLevel) {
		if (root == null) {
			return true;
		}
		if (isLeaf(root)) {
			return level == currentLevel;
		} else {
			return checkSameLevel(root.left, level, currentLevel + 1)
					&& checkSameLevel(root.right, level, currentLevel + 1);
		}
	}

	private static boolean isSameLevel(Node root) {
		int level = leftLeafLevel(root), currentLevel = 0;
		return checkSameLevel(root, level, currentLevel);
	}

	public static void main(String[] args) {
		Node root;
		root = new Node(12);
		root.left = new Node(5);
		root.left.left = new Node(3);
		root.left.right = new Node(9);
		root.left.left.left = new Node(1);
		root.left.right.left = new Node(1);
		System.out.println(isSameLevel(root));
	}
}
