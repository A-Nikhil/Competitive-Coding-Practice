package DataStructures.LinkedList.SinglyLinkedLists;

import Commons.ListNode;

import java.util.Stack;

@SuppressWarnings("Duplicates")
public class PalindromeList {
	public static void main(String[] args) {
		ListNode<String> list = new ListNode<>();
		list.push("R");
		list.push("A");
		list.push("D");
		list.push("A");
		list.push("R");

		ListNode<String> list1 = new ListNode<>();
		list1.push("R");
		list1.push("A");
		list1.push("D");
		list1.push("A");
		list1.push("R");
		list1.push("D");
		System.out.println(isPalindrome(list.head));
		System.out.println(isPalindrome(list1.head));
	}

	private static boolean isPalindrome(ListNode<String> head) {
		Stack<String> stack = new Stack<>();
		ListNode<String> temp = head;
		while (head != null) {
			stack.push(head.data);
			head = head.next;
		}

		head = temp;
		while (!stack.isEmpty()) {
			if (!stack.pop().equalsIgnoreCase(head.data)) {
				return false;
			}
			head = head.next;
		}
		return true;
	}
}
