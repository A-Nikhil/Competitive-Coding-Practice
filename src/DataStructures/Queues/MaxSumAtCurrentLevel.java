package DataStructures.Queues;

import Commons.Node;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("Duplicates")
public class MaxSumAtCurrentLevel {
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(8);
		root.right.right.left = new Node(6);
		root.right.right.right = new Node(7);

                /*   Constructed Binary tree is:
                1
              /   \
            2      3
          /  \      \
         4    5      8
                   /   \
                  6     7    */

		System.out.println("Maximum width = " + getMaxSum(root));
	}

	private static int getMaxSum(Node root) {
		if (root == null) {
			return -1;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int maxSum = Integer.MIN_VALUE, count, currSum ;
		while (!queue.isEmpty()) {
			count = queue.size(); // level width of next level
			currSum = 0;
			while (count > 0) {
				root = queue.poll();
				if (root !=  null) {
					currSum += root.data;
					if (root.left != null) {
						queue.add(root.left);
					}
					if (root.right != null){
						queue.add(root.right);
					}
				}
				count--;
			}
			maxSum = Math.max(maxSum, currSum);
		}
		return maxSum;
	}
}
