package LeetCode;

import Commons.LeetCodeListMaker;
import Commons.ListNode;

public class OddEvenLinkedList {
	public static void main(String[] args) {
		ListNode root = new LeetCodeListMaker().makeList("1->2->3->4->5->NULL");
		new ListNode().printList(new OddEvenLinkedList().oddEvenList(root));
	}

	public ListNode oddEvenList(ListNode head) {
		ListNode evens = null, evensEnd = null, odds = null, oddsEnd = null;
		boolean even = false;
		if (head == null || head.next == null || head.next.next == null) {
			return head;
		}
		while (head != null) {
			if (even) {
				even = false;
				if (evensEnd == null) {
					evens = head;
				} else {
					evensEnd.next = head;
				}
				evensEnd = head;
			} else {
				even = true;
				if (oddsEnd == null) {
					odds = head;
				} else {
					oddsEnd.next = head;
				}
				oddsEnd = head;
			}
			head = head.next;
		}
		oddsEnd.next = evens;
		evensEnd.next = null;
		return odds;
	}
}
