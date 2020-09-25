// https://leetcode.com/problems/palindrome-linked-list/

package DataStructures.LinkedList.SinglyLinkedLists;

import Commons.LeetCodeListMaker;
import Commons.ListNode;

public class PalindromeLinkedList {
	public static void main(String[] args) {
		String x = "1->0->0->NULL";
//		String x = "1->2->2->1->NULL";
//		String x = "1->2->3->2->1->NULL";
//		String x = "1->2->NULL";
		System.out.println(
				new PalindromeLinkedList().isPalindrome(
						new LeetCodeListMaker().makeList(x)));
	}

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		if (head.next.next == null) {
			return head.val == head.next.val;
		}
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		slow.next = reverse(slow.next);
		fast = slow.next;
		slow = head;
		while (fast != null && slow != null) {
			if (slow.val != fast.val) {
				return false;
			}
			fast = fast.next;
			slow = slow.next;
		}
		return true;
	}

	public ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode rest = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return rest;
	}
}
