package DataStructures.LinkedList.SinglyLinkedLists;

import Commons.ListNodeString;

import java.util.Stack;

@SuppressWarnings("Duplicates")
public class PalindromeList {
	public static void main(String[] args) {
		ListNodeString list = new ListNodeString();
		list.push("R");
		list.push("A");
		list.push("D");
		list.push("A");
		list.push("R");

		ListNodeString list1 = new ListNodeString();
		list1.push("R");
		list1.push("A");
		list1.push("D");
		list1.push("A");
		list1.push("R");
		list1.push("D");
		System.out.println(isPalindrome(list.head));
		System.out.println(isPalindrome(list1.head));
	}

	private static boolean isPalindrome(ListNodeString head) {
		Stack<String> stack = new Stack<>();
		ListNodeString temp = head;
		while (head != null) {
			stack.push(head.val);
			head = head.next;
		}

		head = temp;
		while (!stack.isEmpty()) {
			if (!stack.pop().equalsIgnoreCase(head.val)) {
				return false;
			}
			head = head.next;
		}
		return true;
	}
}
