package Algorithms.Sorting;

import Commons.ListNode;

public class MergeSortLinkedList {
	private static ListNode<Integer> mergeSort(ListNode<Integer> head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode<Integer> middle = getMiddle(head);
		ListNode<Integer> nextMiddle = middle.next;
		middle.next = null;
		ListNode<Integer> left = mergeSort(head);
		ListNode<Integer> right = mergeSort(nextMiddle);

		return sortedMerge(left, right);
	}

	private static ListNode<Integer> getMiddle(ListNode<Integer> head) {
		if (head == null) {
			return head;
		}
		ListNode<Integer> slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private static ListNode<Integer> sortedMerge(ListNode<Integer> left, ListNode<Integer> right) {
		ListNode<Integer> result;
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}
		if (left.data <= right.data) {
			result = left;
			result.next = sortedMerge(left.next, right);
		} else {
			result = right;
			result.next = sortedMerge(left, right.next);
		}
		return result;
	}

	public static void main(String[] args) {
		ListNode<Integer> li = new ListNode<>();
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
