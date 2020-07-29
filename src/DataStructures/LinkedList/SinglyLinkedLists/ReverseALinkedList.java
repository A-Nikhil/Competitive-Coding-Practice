package DataStructures.LinkedList.SinglyLinkedLists;

import Commons.ListNode;

@SuppressWarnings("Duplicates")
public class ReverseALinkedList {
	public static void main(String[] args) {
		ListNode list1 = new ListNode();
		list1.push(6);
		list1.push(5);
		list1.push(4);
		list1.push(3);
		list1.push(2);
		list1.push(1);

		list1.printList(reversal(list1.head));
	}

	private static ListNode reversal(ListNode head) {
		ListNode curr = head, prev = null, next;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		return head;
	}
}
