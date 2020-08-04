// https://leetcode.com/problems/reorder-list/

package DataStructures.LinkedList.SinglyLinkedLists;

import Commons.LeetCodeListMaker;
import Commons.ListNode;

public class ReorderList {
	public static void main(String[] args) {
		String x = "1->2->3->4->5->NULL";
		ListNode root = new LeetCodeListMaker().makeList(x);
		new ReorderList().reorderList(root);
		new ListNode().printList(root);
	}

	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}

		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode m = head;
		ListNode n = reverseList(slow.next);
		slow.next = null;
		while (m != null && n != null) {
			ListNode temp1 = m.next, temp2 = n.next;
			m.next = n;
			n.next = temp1;
			m = temp1;
			n = temp2;
		}
	}

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode m = head;
		ListNode n = head.next;
		head.next = null;
		while (m != null && n != null) {
			ListNode temp = n.next;
			n.next = m;
			m = n;
			n = temp;
		}
		return m;
	}
}
