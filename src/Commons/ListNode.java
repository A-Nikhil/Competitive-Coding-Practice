package Commons;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode head = null;

	public ListNode(int val) {
		this.val = val;
		this.next = null;
	}

	public ListNode() {
		this.head = null;
	}

	public void push(int data) {
		ListNode newNode = new ListNode(data);
		newNode.next = head;
		this.head = newNode;
	}

	public void printList() {
		ListNode node = this.head;
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	public void convertCircular() {
		ListNode node = this.head;
		while (node.next != null) {
			node = node.next;
		}
		node.next = this.head;
	}

	public void printCircularList() {
		ListNode node = this.head;
		while (this.head.next != node) {
			System.out.print(this.head.val + " ");
			this.head = this.head.next;
		}
		System.out.println(this.head.val);
		this.head = node;
	}

	public void printCircularList(ListNode head) {
		ListNode node = head;
		while (head.next != node) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println(head.val);
	}

	public String toString(ListNode head) {
		String x = "";
		while (head != null) {
			x = x.concat(head.val + " ");
			head = head.next;
		}
		return x;
	}
}
