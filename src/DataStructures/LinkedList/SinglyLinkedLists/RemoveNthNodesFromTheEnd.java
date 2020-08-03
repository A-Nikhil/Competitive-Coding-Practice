// https://leetcode.com/problemset/algorithms/?topicSlugs=linked-list

package DataStructures.LinkedList.SinglyLinkedLists;

import Commons.LeetCodeListMaker;
import Commons.ListNode;

public class RemoveNthNodesFromTheEnd {
	public static void main(String[] args) {
		String x = "1->2->3->4->5->NULL";
		int n = 2;
		ListNode root = new LeetCodeListMaker().makeList(x);
		root = new RemoveNthNodesFromTheEnd().removeNthFromEnd(root, n);
		root.printList(root);
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		ListNode fast = head, slow = head;
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}
		// => End of the list
		if (fast == null) {
			head = head.next;
			return head;
		}

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;

		return head;
	}
}
