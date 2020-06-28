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

	public void convertCircular() {
		ListNode<T> node = this.head;
		while (node.next != null) {
			node = node.next;
		}
		node.next = this.head;
	}

	public void printCircularList() {
		ListNode<T> node = this.head;
		while (this.head.next != node) {
			System.out.print(this.head.data + " ");
			this.head = this.head.next;
		}
		System.out.println(this.head.data);
		this.head = node;
	}

	public void printCircularList(ListNode<T> head) {
		ListNode<T> node = head;
		while (head.next != node) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println(head.data);
	}
}
