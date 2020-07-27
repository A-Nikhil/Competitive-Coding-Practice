package Commons;

public class Node {
	public Node left, right;
	public int val;

	public Node(int item) {
		val = item;
		left = right = null;
	}

	public Node(int val, Node left, Node right) {
		this.left = left;
		this.right = right;
		this.val = val;
	}
}
