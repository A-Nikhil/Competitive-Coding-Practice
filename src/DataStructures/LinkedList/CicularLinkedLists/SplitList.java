package DataStructures.LinkedList.CicularLinkedLists;

import Commons.ListNode;

@SuppressWarnings("Duplicates")
public class SplitList {
	public static void main(String[] args) {
		ListNode list = new ListNode();
		list.push(1);
		list.push(2);
		list.push(3);
		list.push(4);
		list.push(5);
		list.push(6);
		list.convertCircular();
		list.printCircularList();
		split(list.head);
	}

	private static void split(ListNode head) {
		ListNode slow = head, fast = head, head1, head2 = null;
		while (fast.next != head && fast.next.next != head) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// For even number of nodes
		if (fast.next.next == head) {
			fast = fast.next;
		}

		head1 = head;
		if (head.next != head) {
			head2 = slow.next;
		}

		fast.next = slow.next; // Making 2nd half circular

		slow.next = head;


		new ListNode().printCircularList(head1);
		if (head2 != null) {
			new ListNode().printCircularList(head2);
		}
	}
}
