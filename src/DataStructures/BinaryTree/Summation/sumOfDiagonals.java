/*
Diagonal Sum of a Binary Tree
Consider lines of slope -1 passing between nodes (dotted lines in below diagram).
Diagonal sum in a binary tree is sum of all node’s data lying between these lines.
Given a Binary Tree, print all diagonal sums.

The idea is to keep track of vertical distance from top diagonal passing through root. We increment the vertical distance we go down to next diagonal.
1. Add root with vertical distance as 0 to the queue.
2. Process the sum of all right child and right of right child and so on.
3. Add left child current node into the queue for later processing.
	The vertical distance of left child is vertical distance of current node plus 1.
4. Keep doing 2nd, 3rd and 4th step till the queue is empty.

https://www.geeksforgeeks.org/diagonal-sum-binary-tree/
 */

package DataStructures.BinaryTree.Summation;

import Commons.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class sumOfDiagonals {
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(9);
		root.left.right = new Node(6);
		root.right.left = new Node(4);
		root.right.right = new Node(5);
		root.right.left.left = new Node(12);
		root.right.left.right = new Node(7);
		root.left.right.left = new Node(11);
		root.left.left.right = new Node(10);

		System.out.println(getSumDiagonal(root));
	}

	private static int getSumDiagonal(Node root) {
		Queue<VerticalDistance> queue = new LinkedList<>();
		HashMap<Integer, Integer> diagonalSum = new HashMap<>();
		queue.add(new VerticalDistance(root, 0));
		VerticalDistance current;
		int vd;
		while (!queue.isEmpty()) {
			current = queue.poll();
			vd = current.vd;

			while (current.root != null) {
				int prevSum = (diagonalSum.get(vd) == null) ? 0 : diagonalSum.get(vd);
				diagonalSum.put(vd, prevSum + current.root.val);

				if (current.root.left != null) {
					queue.add(new VerticalDistance(current.root.left, vd + 1));
				}

				current = new VerticalDistance(current.root.right, vd);
			}
		}

		int sum = 0;
		for (Map.Entry<Integer, Integer> entry : diagonalSum.entrySet()) {
			System.out.print(entry.getValue() + " ");
			sum += entry.getValue();
		}
		System.out.println();
		return sum;
	}

	static class VerticalDistance {
		Node root;
		int vd;

		public VerticalDistance(Node root, int vd) {
			this.root = root;
			this.vd = vd;
		}
	}
}
