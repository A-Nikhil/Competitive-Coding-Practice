package DataStructures.LinkedList.SinglyLinkedLists;

import Commons.ListNode;

@SuppressWarnings("Duplicates")
public class MiddleOfTheList {
	public static void main(String[] args) {
		ListNode list = new ListNode();
		list.push(1);
		list.push(2);
		list.push(3);
		list.push(4);
		list.push(5);
		list.push(6);
		ListNode head = list.head;
		System.out.println(findMiddle(head));
	}

	private static int findMiddle(ListNode head) {
		if (head == null) {
			return -1;
		}
		ListNode slow = head, fast = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		assert slow != null;
		return slow.val;
	}
}
