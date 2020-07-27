package Commons;

public class BinarySearchTree {
	public Node root;

	public BinarySearchTree() {
		root = null;
	}

	public Node getRoot() {
		return root;
	}

	public Node insert(Node root, int element) {
		// Creating root of the tree
		if (root == null) {
			return new Node(element, null, null);
		}

		if (element < root.val) {
			root.left = insert(root.left, element);
		} else if (element > root.val) {
			root.right = insert(root.right, element);
		}

		return root;
	}
}
