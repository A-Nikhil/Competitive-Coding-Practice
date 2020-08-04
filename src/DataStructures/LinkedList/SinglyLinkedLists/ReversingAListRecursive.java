package DataStructures.LinkedList.SinglyLinkedLists;

import Commons.LeetCodeListMaker;
import Commons.ListNode;

public class ReversingAListRecursive {
	public static void main(String[] args) {
		String x = "1->2->3->4->5->NULL";
		new ListNode().printList(
				new ReversingAListRecursive().reverseList(
						new LeetCodeListMaker().makeList(x)));

	}

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode rest = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return rest;
	}
}
