// https://leetcode.com/problems/insertion-sort-list/

package DataStructures.LinkedList.SinglyLinkedLists;

import Commons.LeetCodeListMaker;
import Commons.ListNode;

public class InsertionSortOnLinkedList {
	public ListNode sorted;

	public static void main(String[] args) {
		String x = "4->2->1->3->NULL";
		ListNode root = new LeetCodeListMaker().makeList(x);
		System.out.println(root.toString(new InsertionSortOnLinkedList().insertionSortList(root)));
	}

	public ListNode insertionSortList(ListNode head) {
		sorted = null;
		ListNode current = head;
		while (current != null) {
			ListNode next = current.next;
			sortedInsert(current);
			current = next;
		}
		return sorted;
	}

	public void sortedInsert(ListNode newNode) {
		if (sorted == null || sorted.val >= newNode.val) {
			newNode.next = sorted;
			sorted = newNode;
		} else {
			ListNode current = sorted;
			while (current.next != null && current.next.val < newNode.val) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
		}
	}
}
