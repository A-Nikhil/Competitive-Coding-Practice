package Commons;

public class ListNode<T> {
	public T data;
	public ListNode<T> next;
	public ListNode<T> head = null;

	public ListNode(T data) {
		this.data = data;
		this.next = null;
	}

	public ListNode() {
		this.head = null;
	}

	public void push(T data) {
		ListNode<T> newNode = new ListNode<>(data);
		newNode.next = head;
		this.head = newNode;
	}

	public void printList() {
		ListNode<T> node = this.head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public void printList(ListNode<T> head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
