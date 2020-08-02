package Commons;

public class ListNodeString {
	public String val;
	public ListNodeString next;
	public ListNodeString head = null;

	public ListNodeString(String val) {
		this.val = val;
		this.next = null;
	}

	public ListNodeString() {
		this.head = null;
	}

	public void push(String data) {
		ListNodeString newNode = new ListNodeString(data);
		newNode.next = head;
		this.head = newNode;
	}

	public void printList() {
		ListNodeString node = this.head;
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public void printList(ListNodeString head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	public void convertCircular() {
		ListNodeString node = this.head;
		while (node.next != null) {
			node = node.next;
		}
		node.next = this.head;
	}

	public void printCircularList() {
		ListNodeString node = this.head;
		while (this.head.next != node) {
			System.out.print(this.head.val + " ");
			this.head = this.head.next;
		}
		System.out.println(this.head.val);
		this.head = node;
	}

	public void printCircularList(ListNodeString head) {
		ListNodeString node = head;
		while (head.next != node) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println(head.val);
	}
}
