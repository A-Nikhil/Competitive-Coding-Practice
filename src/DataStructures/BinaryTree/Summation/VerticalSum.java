/*
Vertical Sum in a given Binary Tree | Set 1
Given a Binary Tree, find the vertical sum of the nodes that are in the same vertical line.
Print all sums through different vertical lines.
Examples:

      1
    /   \
  2      3
 / \    / \
4   5  6   7
The tree has 5 vertical lines

Vertical-Line-1 has only one node 4 => vertical sum is 4
Vertical-Line-2: has only one node 2=> vertical sum is 2
Vertical-Line-3: has three nodes: 1,5,6 => vertical sum is 1+5+6 = 12
Vertical-Line-4: has only one node 3 => vertical sum is 3
Vertical-Line-5: has only one node 7 => vertical sum is 7

We need to check the Horizontal Distances from the root for all nodes.
If two nodes have the same Horizontal Distance (HD), then they are on the same vertical line.
The idea of HD is simple. HD for root is 0, a right edge (edge connecting to right subtree)
is considered as +1 horizontal distance and a left edge is considered as -1 horizontal distance.
For example, in the above tree, HD for Node 4 is at -2, HD for Node 2 is -1, HD for 5 and 6 is 0
and HD for node 7 is +2.
We can do an in-order traversal of the given Binary Tree.
While traversing the tree, we can recursively calculate HDs.
We initially pass the horizontal distance as 0 for root. For left subtree,
we pass the Horizontal Distance as Horizontal distance of root minus 1.
For right subtree, we pass the Horizontal Distance as Horizontal Distance of root plus 1.

https://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
 */

package DataStructures.BinaryTree.Summation;

import Commons.Node;

import java.util.HashMap;
import java.util.HashSet;

public class VerticalSum {
	private static HashMap<Node, Integer> hd;
	private static int[] arr;

	private static void getHorizontalDistances(Node root, int hDist, boolean doSum) {
		if (root == null) {
			return;
		}
		getHorizontalDistances(root.left, hDist - 1, doSum);
		if (doSum) {
			if (hDist >= 0) {
				arr[hDist] += root.val;
			} else {
				arr[arr.length + hDist] += root.val;
			}
		} else {
			hd.put(root, hDist);
		}
		getHorizontalDistances(root.right, hDist + 1, doSum);
	}

	private static void printSums(Node root) {
		hd = new HashMap<>();
		getHorizontalDistances(root, 0, false);
		int val = new HashSet<>(hd.values()).size();
		arr = new int[val];
		getHorizontalDistances(root, 0, true);
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.println("Level Sum of " + i + " => " + arr[i]);
		}
	}

	@SuppressWarnings("Duplicates")
	public static void main(String[] args) {
		Node root;
		/* Create the following Binary Tree
              1
            /    \
          2        3
         / \      / \
        4   5    6   7

        */
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		printSums(root);
	}
}
