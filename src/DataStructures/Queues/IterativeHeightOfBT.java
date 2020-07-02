package DataStructures.Queues;

import Commons.Node;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("Duplicates")
public class IterativeHeightOfBT {
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

		System.out.println("Maximum height = " + returnHeight(root));
	}

	private static int returnHeight(Node root) {
		if (root == null) {
			return -1;
		}
		Queue<Node> queue = new LinkedList<>();
		Node currNode;
		queue.add(root);
		int nodeCount, height = 0;
		while (true) {
			nodeCount = queue.size();
			if (nodeCount == 0) {
				return height;
			}
			height++;
			while (nodeCount > 0 && !queue.isEmpty()) {
				currNode = queue.remove();
				if (currNode.left != null) {
					queue.add(currNode.left);
				}
				if (currNode.right != null) {
					queue.add(currNode.right);
				}
				nodeCount--;
			}
		}
	}
}
