/*
Level Order Tree Traversal
              1
            /   \
           2     3
         /   \
        4    5

printLevelOrder(tree)
1) Create an empty queue q
2) temp_node = root start from root
3) Loop while temp_node is not NULL
		a) print temp_node->data.
		b) Enqueue temp_node’s children (first left then right children) to q
		c) Dequeue a node from q and assign it’s value to temp_node

https://www.geeksforgeeks.org/level-order-tree-traversal/
 */

package DataStructures.BinaryTree.Traversals;

import Commons.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	@SuppressWarnings("Duplicates")
	public static void main(String[] args) {
		Node root;
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		System.out.println("Level order traversal of binary tree is - ");
		levelOrder(root);
	}

	private static void levelOrder(Node root) {
		Queue<Node> queue = new LinkedList<>();
		Node tempNode = root;
		queue.add(tempNode);
		while (!queue.isEmpty()) {
			tempNode = queue.poll();
			System.out.print(tempNode.val + " ");
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}
}
