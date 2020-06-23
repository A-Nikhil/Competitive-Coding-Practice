package commons;

public class Node {
	public Node left, right;
	public int data;

	public Node(int item) {
		data = item;
		left = right = null;
	}

	public Node(int data, Node left, Node right) {
		this.left = left;
		this.right = right;
		this.data = data;
	}
}
