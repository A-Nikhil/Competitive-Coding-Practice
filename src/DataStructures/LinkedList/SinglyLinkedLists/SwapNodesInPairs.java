package DataStructures.LinkedList.SinglyLinkedLists;

import Commons.LeetCodeListMaker;
import Commons.ListNode;

public class SwapNodesInPairs {
	public static void main(String[] args) {
		String x = "1->2->3->4->5->NULL";
		ListNode head = new LeetCodeListMaker().makeList(x);
		ListNode temp = new SwapNodesInPairs().swapPairs(head);
		temp.printList(temp);
		System.out.println();
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode h = new ListNode(0);
		h.next = head;
		ListNode p = h;

		while (p.next != null && p.next.next != null) {
			// use t1 to track first node
			ListNode t1 = p;
			p = p.next;
			t1.next = p.next;

			// use t2 to track next node of the pair
			ListNode t2 = p.next.next;
			p.next.next = p;
			p.next = t2;
		}

		return h.next;
	}

}