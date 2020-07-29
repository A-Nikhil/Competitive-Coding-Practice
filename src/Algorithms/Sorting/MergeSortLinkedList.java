package Algorithms.Sorting;

import Commons.ListNode;

public class MergeSortLinkedList {
	private static ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode middle = getMiddle(head);
		ListNode nextMiddle = middle.next;
		middle.next = null;
		ListNode left = mergeSort(head);
		ListNode right = mergeSort(nextMiddle);

		return sortedMerge(left, right);
	}

	private static ListNode getMiddle(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private static ListNode sortedMerge(ListNode left, ListNode right) {
		ListNode result;
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}
		if (left.val <= right.val) {
			result = left;
			result.next = sortedMerge(left.next, right);
		} else {
			result = right;
			result.next = sortedMerge(left, right.next);
		}
		return result;
	}

	public static void main(String[] args) {
		ListNode li = new ListNode();
		li.push(15);
		li.push(10);
		li.push(5);
		li.push(20);
		li.push(3);
		li.push(2);
		li.head = mergeSort(li.head);
		li.printList();
	}
}
